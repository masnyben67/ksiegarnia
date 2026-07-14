package pl.ksiegarnia.online.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



/*
    Encja zamówienia.

    Jedno zamówienie może posiadać wiele książek.
*/
@Entity
@Table(name = "orders")
public class Order {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    /*
        Data stworzenia zamówienia.
    */
    private LocalDate date;



    /*
        Aktualny status.
    */
    @Enumerated(EnumType.STRING)
    private OrderStatus status;



    /*
        Lista książek w zamówieniu.

        Cascade oznacza:
        jeżeli usuniemy zamówienie,
        usunięte zostaną także elementy.

    */
    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL
    )
    private List<OrderItem> items = new ArrayList<>();




    // Konstruktor wymagany przez JPA
    public Order(){

    }



    /*
        Tworzymy nowe zamówienie.

        Automatycznie ustawiamy:
        - dzisiejszą datę
        - status NEW
    */
    public Order(LocalDate date){

        this.date = date;
        this.status = OrderStatus.NEW;

    }



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }


    public OrderStatus getStatus() {
        return status;
    }


    public void setStatus(OrderStatus status) {
        this.status = status;
    }


    public List<OrderItem> getItems() {
        return items;
    }


    public void setItems(List<OrderItem> items) {
        this.items = items;
    }


}
