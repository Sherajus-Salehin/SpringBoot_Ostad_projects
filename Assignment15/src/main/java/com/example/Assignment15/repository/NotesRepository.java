package com.example.Assignment15.repository;

import com.example.Assignment15.model.Note;
import com.example.Assignment15.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotesRepository extends JpaRepository<Note,Long> {
    Optional<Note> findByIdAndUser(Long id, User user);
    List<Note> findByUser(User user);

}
