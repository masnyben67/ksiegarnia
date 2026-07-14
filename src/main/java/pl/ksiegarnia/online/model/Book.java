package pl.ksiegarnia.online.model;


import jakarta.persistence.*;

import java.math.BigDecimal;


/*
    Encja książki.

    Każdy obiekt tej klasy będzie jednym rekordem
    w tabeli BOOK.

    Przykład:

    id = 1
    title = "Java od podstaw"
    price = 80.00
    category = "Programowanie"
*/


@Entity
@Table(name = "books")
public class Book {


    /*
        Automatycznie generowane ID.

        Baza sama nada numer:
        1,2,3,4...
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    /*
        Tytuł książki
    */
    @Column(nullable = false)
    private String title;



    /*
        Cena książki.

        BigDecimal jest używany zamiast double,
        ponieważ pieniądze wymagają dokładności.
    */
    @Column(nullable = false)
    private BigDecimal price;



    /*
        Kategoria książki.

        Przykłady:
        - Fantasy
        - Programowanie
        - Historia
    */
    private String category;



    // ==========================
    // KONSTRUKTORY
    // ==========================


    /*
        Konstruktor wymagany przez JPA.
    */
    public Book() {

    }



    /*
        Konstruktor pomocniczy.

        Przyda się przy dodawaniu danych startowych.
    */
    public Book(
            String title,
            BigDecimal price,
            String category
    ) {

        this.title = title;
        this.price = price;
        this.category = category;

    }



    // ==========================
    // GETTERY I SETTERY
    // ==========================


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


}
