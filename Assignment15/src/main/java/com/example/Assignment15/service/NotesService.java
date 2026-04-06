package com.example.Assignment15.service;

import com.example.Assignment15.model.Note;
import com.example.Assignment15.model.User;
import com.example.Assignment15.repository.NotesRepository;
import com.example.Assignment15.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    @Autowired
    NotesRepository repo;
    @Autowired
    UserRepository userRepo;

    public User getUser(String username) {
        return userRepo.findByUsername(username).orElseThrow(()->new RuntimeException("Username not found"));
    }

    public Note addNote(Note note, String name){
        User user = userRepo.findByUsername(name).orElseThrow(()->new RuntimeException("Username not found"));
        note.setUser(user);
        return repo.save(note);
    }
    public List<Note> findAll(User user){
        return repo.findByUser(user);
    }
    public Note findById(Long id,User user){
        //return repo.findById(id).orElseThrow(()->new RuntimeException("Note not found"));
    return repo.findByIdAndUser(id,user).orElseThrow(()->new RuntimeException("Username not found"));
    }
    public void deleteById(Long id,User user){
        Note note=repo.findByIdAndUser(id,user).orElseThrow(()->new RuntimeException("Note not found"));
        repo.delete(note);
    }
    public Note updateNote(Long id,Note update, User user){
        Note toUpdate=repo.findByIdAndUser(id , user).orElseThrow(()->new RuntimeException("Username not found"));
        toUpdate.setTitle(update.getTitle());
        toUpdate.setContent(update.getContent());
        return repo.save(toUpdate);
    }


}
