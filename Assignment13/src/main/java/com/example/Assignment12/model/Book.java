package com.example.Assignment12.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;
//lombok getter/ setter doesnt work
@Data
@Component
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String title;
    private String author;
    private String publication;
    private String publicationYear;
    private int availableCopies;
    public enum Genre {Fiction, Science_Fiction, Non_Fiction, Fantasy}
    private Genre genre;

    public Book() {
    }

    public Book(String testTitle, String testAuth, String testPub, String year, int copies, Genre g) {
        title=testTitle;
        author=testAuth;
        publication=testPub;
        publicationYear=year;
        availableCopies=copies;
        genre=g;
    }
    public long getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getPublication() {
        return publication;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public Genre getGenre() {
        return genre;
    }

}
