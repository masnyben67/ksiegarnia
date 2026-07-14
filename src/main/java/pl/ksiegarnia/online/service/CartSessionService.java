package pl.ksiegarnia.online.service;


import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Service;


import pl.ksiegarnia.online.cart.Cart;
import pl.ksiegarnia.online.cart.CartItem;
import pl.ksiegarnia.online.model.Book;



/*
    Serwis obsługujący koszyk użytkownika.


    Koszyk przechowywany jest w sesji HTTP.


    Dzięki temu:

    user A -> swój koszyk

    user B -> swój koszyk

*/
@Service
public class CartSessionService {



    /*
        Nazwa pod jaką zapisujemy koszyk
        w sesji.
    */
    private static final String CART_KEY =
            "USER_CART";





    /*
        Pobranie koszyka.

        Jeżeli użytkownik nie ma koszyka,
        tworzymy nowy.
    */
    public Cart getCart(
            HttpSession session
    ){


        Cart cart =
                (Cart) session.getAttribute(
                        CART_KEY
                );



        if(cart == null){


            cart = new Cart();


            session.setAttribute(
                    CART_KEY,
                    cart
            );

        }



        return cart;

    }







    /*
        Dodawanie książki.
    */
    public void addBook(
            HttpSession session,
            Book book
    ){


        Cart cart =
                getCart(session);



        cart.addItem(
                new CartItem(
                        book,
                        1
                )
        );


    }







    /*
        Czyszczenie koszyka.
    */
    public void clear(
            HttpSession session
    ){


        Cart cart =
                getCart(session);


        cart.clear();


    }



}
