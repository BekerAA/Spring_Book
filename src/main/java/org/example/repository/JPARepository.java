package org.example.repository;

import org.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JPARepository extends JpaRepository<Book, Long> {}
