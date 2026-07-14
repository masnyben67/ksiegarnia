package pl.ksiegarnia.online.cart;



import java.util.ArrayList;
import java.util.List;



/*
    Koszyk użytkownika.


    Przechowuje wszystkie produkty
    przed złożeniem zamówienia.
*/
public class Cart {



    private List<CartItem> items = new ArrayList<>();




    public List<CartItem> getItems(){

        return items;

    }




    /*
        Dodawanie produktu do koszyka.
    */
    public void addItem(
            CartItem item
    ){

        items.add(item);

    }




    /*
        Usunięcie wszystkich produktów.
    */
    public void clear(){

        items.clear();

    }

}
