package pl.ksiegarnia.online.service;


import org.springframework.stereotype.Service;


import pl.ksiegarnia.online.cart.Cart;
import pl.ksiegarnia.online.cart.CartItem;

import pl.ksiegarnia.online.model.Order;
import pl.ksiegarnia.online.model.OrderItem;

import pl.ksiegarnia.online.repository.OrderRepository;


import java.time.LocalDate;



/*
    Serwis odpowiedzialny za zamówienia.


    Tutaj zamieniamy koszyk
    na prawdziwe zamówienie zapisane w bazie.
*/
@Service
public class OrderService {



    private final OrderRepository orderRepository;




    public OrderService(
            OrderRepository orderRepository
    ){

        this.orderRepository = orderRepository;

    }







    /*
        Tworzenie zamówienia.

        Dostaje koszyk klienta.

        Tworzy:

        Order

        oraz

        OrderItem
    */
    public Order createOrder(
            Cart cart
    ){



        /*
            Tworzymy nowe zamówienie.
        */
        Order order =
                new Order(
                        LocalDate.now()
                );





        /*
            Przechodzimy po produktach koszyka.
        */
        for(CartItem item : cart.getItems()){



            OrderItem orderItem =
                    new OrderItem(

                            item.getBook(),

                            item.getQuantity()

                    );




            /*
                Łączymy element z zamówieniem.
            */
            orderItem.setOrder(
                    order
            );



            /*
                Dodajemy do listy.
            */
            order.getItems()
                    .add(orderItem);



        }





        /*
            Zapis do bazy.

            Cascade zapisze również
            OrderItem.
        */
        return orderRepository.save(
                order
        );


    }



}
