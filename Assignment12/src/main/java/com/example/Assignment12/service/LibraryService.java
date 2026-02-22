package com.example.Assignment12.service;

import com.example.Assignment12.model.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LibraryService {
//    author;
//    String publication;
//    String publicationYear;
//    int availableCopies;
//
//    enum genre {Fiction, Scie
    List<Book> books= Arrays.asList(
            new Book("Title1","author1","publication1","2019",5, Book.Genre.Fantasy),
        new Book("Title2","author2","publication2","2119",6, Book.Genre.Science_Fiction));

public List<Book> getBooks(){
    return books;
}
}
