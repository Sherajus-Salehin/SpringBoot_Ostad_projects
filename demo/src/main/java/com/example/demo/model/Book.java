package com.example.demo.model;

import lombok.Data;

@Data
public class Book {
    private long Id;
    String title;
    String author;
    String publication;
    String publicationYear;
    int availableCopies;

    enum genre {Fiction, Science_Fiction, Non_Fiction, Fantasy}

    ;

}
