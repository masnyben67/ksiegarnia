package pl.ksiegarnia.online.controller;



import jakarta.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;


import pl.ksiegarnia.online.model.Book;
import pl.ksiegarnia.online.repository.BookRepository;
import pl.ksiegarnia.online.service.CartCalculatorService;
import pl.ksiegarnia.online.service.CartSessionService;




/*
    Kontroler zwykłych stron koszyka.
*/
@Controller
public class CartPageController {



    private final CartSessionService cartService;


    private final BookRepository bookRepository;


    private final CartCalculatorService calculator;





    public CartPageController(
            CartSessionService cartService,
            BookRepository bookRepository,
            CartCalculatorService calculator
    ){

        this.cartService = cartService;
        this.bookRepository = bookRepository;
        this.calculator = calculator;

    }








    /*
        Dodanie książki.


        Przykład:

        /cart/add/1

        dodaje książkę o ID 1
    */
    @GetMapping("/cart/add/{id}")
    public String add(
            @PathVariable Long id,
            HttpSession session
    ){



        Book book =
                bookRepository
                .findById(id)
                .orElse(null);



        if(book != null){


            cartService.addBook(
                    session,
                    book
            );


        }



        return "redirect:/cart";

    }







    /*
        Widok koszyka.
    */
    @GetMapping("/cart")
    public String cart(
            HttpSession session,
            Model model
    ){



        var cart =
                cartService.getCart(session);




        var result =
                calculator.calculate(cart);





        model.addAttribute(
                "cart",
                cart
        );



        model.addAttribute(
                "result",
                result
        );




        return "cart";


    }





}
