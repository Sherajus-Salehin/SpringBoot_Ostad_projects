package com.example.Assignment15.controller;

import com.example.Assignment15.model.Note;
import com.example.Assignment15.model.User;
import com.example.Assignment15.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotesController {
    @Autowired
    NotesService service;

    //User
    @PostMapping("/notes")
    void newNotes(@RequestBody Note notes) {
        service.addNote(notes);
    }
    @GetMapping("/notes")
    List<Note> allNotes(){
        return service.findAll();
    }
    @GetMapping("/notes/{id}")
    Note findNoteById(@PathVariable Long id){
        return service.findById(id);
    }
    @PutMapping("/notes/{id}")
    void updateNote(@RequestBody Note note){
        service.updateNote(note);
    }
    @DeleteMapping("/notes/{id}")
    void deleteNote(@PathVariable Long id){
        service.deleteById(id);
    }

    //Admin
    @GetMapping("/admin/notes")
    List<Note> allNotesAdmin(){
        return service.findAll();
    }
    @DeleteMapping("/admin/notes/{id}")
    void deleteNoteById(@PathVariable Long id){
        service.deleteById(id);
    }

    //Public
    @PostMapping("/auth/register/user")
    void registerUser(@RequestBody User user){

    }
    @PostMapping("/auth/register/admin")
    void registerUserByAdmin(@RequestBody User user){

    }

}
