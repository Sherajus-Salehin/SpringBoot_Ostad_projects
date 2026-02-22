package com.example.Assignment12.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Getter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    String title;
    String author;
    String publication;
    String publicationYear;
    int availableCopies;
    public enum Genre {Fiction, Science_Fiction, Non_Fiction, Fantasy}
    private Genre genre;

    public Book(String testTitle, String testAuth, String testPub, String year, int copies, Genre g) {
        title=testTitle;
        author=testAuth;
        publication=testPub;
        publicationYear=year;
        availableCopies=copies;
        genre=g;
    }


}
