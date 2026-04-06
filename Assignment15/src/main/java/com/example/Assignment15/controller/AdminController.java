package com.example.Assignment15.controller;

import com.example.Assignment15.model.Note;
import com.example.Assignment15.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdminController {
    @Autowired
    AdminService service;
    @GetMapping("/notes")
    List<Note> allNotesAdmin(){
        return service.findAll();
    }



    @DeleteMapping("/notes/{id}")
    void deleteNoteById(@PathVariable Long id){
        service.deleteById(id);
    }

}
