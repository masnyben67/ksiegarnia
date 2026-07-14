package pl.ksiegarnia.online.controller;


import jakarta.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;


import pl.ksiegarnia.online.model.Order;
import pl.ksiegarnia.online.service.CartSessionService;
import pl.ksiegarnia.online.service.OrderService;



/*
    Obsługa składania zamówienia.
*/
@Controller
public class OrderController {



    private final CartSessionService cartService;


    private final OrderService orderService;





    public OrderController(
            CartSessionService cartService,
            OrderService orderService
    ){

        this.cartService = cartService;
        this.orderService = orderService;

    }






    /*
        Adres:

        /order/create


        Dostępny tylko dla
        zalogowanego użytkownika
        (Security blokuje).
    */
    @GetMapping("/order/create")
    public String createOrder(
            HttpSession session,
            Model model
    ){



        var cart =
                cartService.getCart(session);




        /*
            Zapis zamówienia.
        */
        Order order =
                orderService.createOrder(
                        cart
                );





        /*
            Czyścimy koszyk
            po zakupie.
        */
        cartService.clear(
                session
        );





        model.addAttribute(
                "order",
                order
        );




        return "order-success";


    }



}
