package com.example.Assignment15;

import com.example.Assignment15.model.Note;
import com.example.Assignment15.model.User;
import com.example.Assignment15.repository.NotesRepository;
import com.example.Assignment15.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class Assignment15ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NotesRepository notesRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
	}

	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		notesRepository.deleteAll();
		userRepository.deleteAll();
	}

	@Test
	void registerUserEndpointIsPublic() throws Exception {
		mockMvc.perform(post("/api/auth/register/user")
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
								{
								  "username": "user1",
								  "password": "pass123"
								}
								"""))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username").value("user1"))
				.andExpect(jsonPath("$.role").value("ROLE_USER"));
	}

	@Test
	void registerAdminEndpointIsPublic() throws Exception {
		mockMvc.perform(post("/api/auth/register/admin")
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
								{
								  "username": "admin1",
								  "password": "pass123"
								}
								"""))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username").value("admin1"))
				.andExpect(jsonPath("$.role").value("ROLE_ADMIN"));
	}

	@Test
	void userCanCreateNote() throws Exception {
		createUser("user1", "pass123", "ROLE_USER");

		mockMvc.perform(post("/api/notes")
						.with(httpBasic("user1", "pass123"))
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
								{
								  "title": "First note",
								  "content": "Hello"
								}
								"""))
				.andExpect(status().isOk());
	}

	@Test
	void userCanListOwnNotes() throws Exception {
		User user = createUser("user1", "pass123", "ROLE_USER");
		createNote(user, "First note", "Hello");

		mockMvc.perform(get("/api/notes")
						.with(httpBasic("user1", "pass123")))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].title").value("First note"));
	}

	@Test
	void userCanGetOwnNoteById() throws Exception {
		User user = createUser("user1", "pass123", "ROLE_USER");
		Note note = createNote(user, "First note", "Hello");

		mockMvc.perform(get("/api/notes/{id}", note.getId())
						.with(httpBasic("user1", "pass123")))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(note.getId()))
				.andExpect(jsonPath("$.title").value("First note"));
	}

	@Test
	void userCanUpdateOwnNote() throws Exception {
		User user = createUser("user1", "pass123", "ROLE_USER");
		Note note = createNote(user, "Old title", "Old content");

		mockMvc.perform(put("/api/notes/{id}", note.getId())
						.with(httpBasic("user1", "pass123"))
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
								{
								  "title": "Updated title",
								  "content": "Updated content"
								}
								"""))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title").value("Updated title"))
				.andExpect(jsonPath("$.content").value("Updated content"));
	}

	@Test
	void userCanDeleteOwnNote() throws Exception {
		User user = createUser("user1", "pass123", "ROLE_USER");
		Note note = createNote(user, "Delete me", "Soon gone");

		mockMvc.perform(delete("/api/notes/{id}", note.getId())
						.with(httpBasic("user1", "pass123")))
				.andExpect(status().isOk());
	}

	@Test
	void adminCanListAllNotes() throws Exception {
		User user = createUser("user1", "pass123", "ROLE_USER");
		createUser("admin1", "admin123", "ROLE_ADMIN");
		createNote(user, "Visible to admin", "Hello");

		mockMvc.perform(get("/api/admin/notes")
						.with(httpBasic("admin1", "admin123")))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].title").value("Visible to admin"));
	}

	@Test
	void adminCanDeleteAnyNote() throws Exception {
		User user = createUser("user1", "pass123", "ROLE_USER");
		createUser("admin1", "admin123", "ROLE_ADMIN");
		Note note = createNote(user, "Admin delete", "Hello");

		mockMvc.perform(delete("/api/admin/notes/{id}", note.getId())
						.with(httpBasic("admin1", "admin123")))
				.andExpect(status().isOk());
	}

	private User createUser(String username, String rawPassword, String role) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(rawPassword));
		user.setRole(role);
		return userRepository.save(user);
	}

	private Note createNote(User user, String title, String content) {
		Note note = new Note();
		note.setTitle(title);
		note.setContent(content);
		note.setUser(user);
		return notesRepository.save(note);
	}

}
