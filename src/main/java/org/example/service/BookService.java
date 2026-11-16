package org.example.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.entity.Book;
import org.example.repository.JPARepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private final JPARepository jpaRepository;

    public BookService(JPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Transactional
    public Book saveBook(Book book){
        return jpaRepository.save(book);
    }

    @Transactional(readOnly = true)
    public List<Book> findAllBook(){
        return jpaRepository.findAll();
    }

    @Transactional
    public Book findById(Long id){
        return jpaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Long id){
        jpaRepository.deleteById(id);
    }



}
