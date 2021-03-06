package com.project.library.bookservice.repository;

import com.project.library.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByAuthorsName(String name);

    List<Book> findAllByAuthorsName(String name);

    List<Book> findAll();
}
