package com.example.Assignment15.service;

import com.example.Assignment15.model.Note;
import com.example.Assignment15.repository.NotesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    @Autowired
    NotesRepository notesRepository;
    public List<Note> findAll(){
        return notesRepository.findAll();

    }

    public Note findById(Long id){
        return notesRepository.findById(id).orElseThrow(()->new RuntimeException("Note not found"));
    }

    public void deleteById(Long id){
        notesRepository.deleteById(id);
    }

}
