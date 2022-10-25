package com.nestdigital.books.dao;

import com.nestdigital.books.model.BookModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookDao extends CrudRepository<BookModel,Integer> {
    @Modifying
    @Query(value = "DELETE FROM `books` WHERE id=:id",nativeQuery = true)
    void deleteBookById(Integer id);
    @Query(value = "SELECT `id`, `bookdiscription`, `bookname`, `language`, `pages` FROM `books` WHERE bookname=:bookname",nativeQuery = true)
    List<BookModel>searchbook(String bookname);
}
