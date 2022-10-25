package com.nestdigital.books.controller;

import com.nestdigital.books.dao.BookDao;
import com.nestdigital.books.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/bookadd",consumes = "application/json",produces = "application/json")
    public String bookadd(@RequestBody BookModel book){
        System.out.println(book.toString());
        dao.save(book);
        return "(status:'success')";
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewbooks")
    public List<BookModel> viewbooks(){
        return (List<BookModel>) dao.findAll();

    }
    @CrossOrigin (origins = "*")
    @Transactional
    @PostMapping (path = "/deleteBook",consumes = "application/json",produces = "application/json")
    public String deleteBook(@RequestBody BookModel book){
        dao.deleteBookById(book.getId());
        return "(status:'success')";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchbook",consumes = "application/json",produces = "application/json")
    public  List<BookModel>searchbook(@RequestBody BookModel book){
        System.out.println(book.getBookname());
        return (List<BookModel>) dao.searchbook(book.getBookname());
    }
    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(value = "editBook",consumes = "application/json",produces = "application/json")
    public String editBook(@RequestBody BookModel book){
        dao.editBook(book.getBookname(),book.getBookdiscription(),book.getPages(),book.getLanguage(),book.getId());
        return "(status:'success')";
    }


}
