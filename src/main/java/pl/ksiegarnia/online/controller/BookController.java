package pl.ksiegarnia.online.controller;



import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;


import pl.ksiegarnia.online.service.BookService;



/*
    Kontroler odpowiedzialny za katalog książek.
*/
@Controller
public class BookController {



    private final BookService bookService;





    public BookController(
            BookService bookService
    ){

        this.bookService = bookService;

    }







    /*
        Widok:

        localhost:8080/books
    */
    @GetMapping("/books")
    public String books(
            Model model
    ){



        /*
            Przekazujemy książki
            do HTML.
        */
        model.addAttribute(
                "books",
                bookService.getAllBooks()
        );



        return "books";


    }


}
