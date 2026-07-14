package pl.ksiegarnia.online.cart;


import pl.ksiegarnia.online.model.Book;



/*
    Element koszyka.

    Przykład:

    Klient dodał:

    Java od podstaw x2


    W koszyku mamy:

    book = Java od podstaw
    quantity = 2
*/
public class CartItem {



    private Book book;


    private int quantity;



    public CartItem(
            Book book,
            int quantity
    ){

        this.book = book;
        this.quantity = quantity;

    }



    public Book getBook(){

        return book;

    }



    public int getQuantity(){

        return quantity;

    }



    public void setQuantity(int quantity){

        this.quantity = quantity;

    }



}
