package pl.ksiegarnia.online.model;


import jakarta.persistence.*;



/*
    Element zamówienia.

    Przykład:

    Zamówienie:

    Java książka x2

    tworzy:

    OrderItem:
    book = Java
    quantity = 2

*/
@Entity
@Table(name="order_items")
public class OrderItem {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    /*
        Ile sztuk książki kupiono
    */
    private Integer quantity;



    /*
        Konkretna książka.

        Wiele elementów może wskazywać
        na jedną książkę.
    */
    @ManyToOne
    private Book book;



    /*
        Zamówienie do którego należy element.
    */
    @ManyToOne
    private Order order;




    public OrderItem(){

    }



    public OrderItem(
            Book book,
            Integer quantity
    ){

        this.book = book;
        this.quantity = quantity;

    }



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Integer getQuantity() {
        return quantity;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Book getBook() {
        return book;
    }


    public void setBook(Book book) {
        this.book = book;
    }


    public Order getOrder() {
        return order;
    }


    public void setOrder(Order order) {
        this.order = order;
    }


}
