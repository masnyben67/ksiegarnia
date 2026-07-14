package pl.ksiegarnia.online.cart;


import java.math.BigDecimal;



/*
    Obiekt zwracany przez kalkulator.


    Przechowuje:

    cena przed rabatem
    wartość rabatu
    końcową cenę
    nazwę promocji
*/
public class DiscountResult {



    private BigDecimal subtotal;


    private BigDecimal discount;


    private BigDecimal total;


    private String promotion;




    public DiscountResult(
            BigDecimal subtotal,
            BigDecimal discount,
            BigDecimal total,
            String promotion
    ){

        this.subtotal = subtotal;
        this.discount = discount;
        this.total = total;
        this.promotion = promotion;

    }





    public BigDecimal getSubtotal(){

        return subtotal;

    }



    public BigDecimal getDiscount(){

        return discount;

    }



    public BigDecimal getTotal(){

        return total;

    }



    public String getPromotion(){

        return promotion;

    }


}
