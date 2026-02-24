package com.example.Assignment12.repo;

import com.example.Assignment12.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepo extends JpaRepository<Book,Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByGenre(Book.Genre g);

    List<Book> findByPublication(String p);
}
