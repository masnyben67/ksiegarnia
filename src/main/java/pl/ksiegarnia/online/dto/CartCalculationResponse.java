package pl.ksiegarnia.online.dto;


import java.math.BigDecimal;


/*
    DTO (Data Transfer Object)

    Służy do przesyłania danych
    między backendem a frontendem.


    Nie wysyłamy całych obiektów encji,
    tylko potrzebne informacje.
*/
public class CartCalculationResponse {



    private BigDecimal subtotal;


    private BigDecimal discount;


    private BigDecimal total;


    private String promotion;





    public CartCalculationResponse(
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
