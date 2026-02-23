package com.example.Assignment12.controller;

import com.example.Assignment12.model.Book;
import com.example.Assignment12.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class LibraryController {

    @Autowired
    LibraryService lc;

    @GetMapping("/test")
    public String testing() {
        return "<h1>its</h1><br> <h2>working</h2>";
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return lc.getBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book b) {
        lc.addBook(b);
    }

    @GetMapping("/author/{authorName}")
    public List<Book> getBooksByAuthor(@PathVariable String authorName) {
        return lc.getByAuthor(authorName);
    }

    @GetMapping("/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable Book.Genre g) {
        return lc.getByGenre(g);
    }

    @GetMapping("/publication/{publication}/summary")
    public HashMap<String, Integer> getBooksByPublication(@PathVariable String publication) {
        return null;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
        return lc.getById(id);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable long id, @RequestBody Book b) {
        //return lc.addBook(b);
        lc.updateBook(id,b);
    }
    @DeleteMapping("/{id}")
    public void deleteABook(@PathVariable long id) {
        lc.delete(id);
    }


}
