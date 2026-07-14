package pl.ksiegarnia.online.service;


import org.springframework.stereotype.Service;

import pl.ksiegarnia.online.model.Book;
import pl.ksiegarnia.online.repository.BookRepository;


import java.util.List;



/*
    Warstwa Service.

    Tutaj trzymamy logikę programu.

    Controller nie powinien gadać bezpośrednio
    z bazą danych.

    Schemat:

    Controller
          |
          v
       Service
          |
          v
      Repository
          |
          v
        Baza
*/
@Service
public class BookService {



    private final BookRepository bookRepository;



    /*
        Spring sam wstrzyknie repozytorium.
    */
    public BookService(
            BookRepository bookRepository
    ){

        this.bookRepository = bookRepository;

    }




    /*
        Pobranie wszystkich książek.
    */
    public List<Book> getAllBooks(){

        return bookRepository.findAll();

    }




    /*
        Pobranie książki po ID.
    */
    public Book getBookById(Long id){

        return bookRepository.findById(id)
                .orElse(null);

    }



}
