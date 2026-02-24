package com.example.Assignment12.service;

import com.example.Assignment12.model.Book;
import com.example.Assignment12.repo.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LibraryService {
    @Autowired
    LibraryRepo repo;
//    List<Book> books= Arrays.asList(
//            new Book("Title1","author1","publication1","2019",5, Book.Genre.Fantasy),
//        new Book("Title2","author2","publication2","2119",6, Book.Genre.Science_Fiction));

    public List<Book> getBooks() {
        return repo.findAll();

    }
    public List<Book> getByAuthor(String author){
        //why stream api when JpaRepository gives me everything
        return repo.findByAuthor(author);
    }
    public List<Book> getByGenre(Book.Genre genre){
        //Book.Genre genre= Book.Genre.valueOf(g);
        return repo.findByGenre(genre);
    }

    public List<Book> getByPublication(String p){
        //Book.Genre genre= Book.Genre.valueOf(g);
        return repo.findByPublication(p);
    }
    public String publicationSummary(String p){
        List<Book> bl=getByPublication(p); //book from this publication
        List<Book> al= getBooks();//All the books
        int myBooks=bl.stream().mapToInt(Book::getAvailableCopies).sum();
        int allBooks=al.stream().mapToInt(Book::getAvailableCopies).sum();
        return "<h6>Publication: "+p+" has "+myBooks+" copies available out of a Total of: "+allBooks+" books</h6>";
    }

    public void updateBook(Long id,Book b){
        // Too lazy to work on the 404 exception 😢
        Book original=repo.findById(id).orElse(b);
        original.setTitle(b.getTitle());
        original.setAuthor(b.getAuthor());
        original.setPublicationYear(b.getPublicationYear());
        original.setAvailableCopies(b.getAvailableCopies());
        original.setGenre(b.getGenre());
        repo.save(original);

    }


    public Book getById(Long id) {
        return repo.findById(id).orElse(new Book());
    }

    //try using for both add and update
    public void addBook(Book book){
        repo.save(book);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}
