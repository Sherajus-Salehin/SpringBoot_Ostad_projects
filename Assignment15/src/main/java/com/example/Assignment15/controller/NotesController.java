package com.example.Assignment15.controller;

import com.example.Assignment15.model.Note;
import com.example.Assignment15.model.User;
import com.example.Assignment15.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {
    @Autowired
    NotesService service;

    //User
    @PostMapping
    Note newNotes(@RequestBody Note notes, Authentication authentication) {
        return service.addNote(notes, authentication.getName());
    }
    @GetMapping
    List<Note> allNotes(Authentication authentication) {
        User user= service.getUser(authentication.getName());
        return service.findAll(user);
    }
    @GetMapping("/{id}")
    Note findNoteById(@PathVariable Long id, Authentication authentication) {
        User user= service.getUser(authentication.getName());
        return service.findById(id, user);
    }
    @PutMapping("/{id}")
    Note updateNote(@PathVariable Long id,@RequestBody Note note, Authentication authentication) {
        User user= service.getUser(authentication.getName());
        return service.updateNote(id, note, user);
    }
    @DeleteMapping("/{id}")
    void deleteNote(@PathVariable Long id, Authentication authentication) {
        User user= service.getUser(authentication.getName());
        service.deleteById(id,user);
    }
}
