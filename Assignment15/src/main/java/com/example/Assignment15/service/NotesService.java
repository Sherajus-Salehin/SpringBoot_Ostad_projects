package com.example.Assignment15.service;

import com.example.Assignment15.model.Note;
import com.example.Assignment15.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    @Autowired
    NotesRepository repo;

    public void addNote(Note note){
        repo.save(note);
    }
    public List<Note> findAll(){
        return repo.findAll();
    }
    public Note findById(Long id){
        return repo.findById(id).get();
    }
    public void deleteById(Long id){
        repo.deleteById(id);
    }
    public void updateNote(Note note){
        repo.save(note);
    }


}
