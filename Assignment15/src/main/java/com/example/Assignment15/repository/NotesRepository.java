package com.example.Assignment15.repository;

import com.example.Assignment15.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Note,Long> {
    List<Note> findByIdAndUsername(Long id, String username);
    List<Note> findByUsername(String username);

}
