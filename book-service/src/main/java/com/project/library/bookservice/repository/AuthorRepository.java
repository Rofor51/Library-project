package com.project.library.bookservice.repository;

import com.project.library.bookservice.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByNameIgnoreCaseAndLastNameIgnoreCase(String name,String lastName);
}
