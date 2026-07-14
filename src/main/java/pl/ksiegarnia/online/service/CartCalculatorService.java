package pl.ksiegarnia.online.service;



import org.springframework.stereotype.Service;


import pl.ksiegarnia.online.cart.Cart;
import pl.ksiegarnia.online.cart.CartItem;
import pl.ksiegarnia.online.cart.DiscountResult;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;



/*
    Serwis odpowiedzialny za liczenie koszyka.


    Tutaj znajduje się logika promocji.

*/
@Service
public class CartCalculatorService {



    /*
        Główna metoda.


        Dostaje koszyk.

        Zwraca najlepszą promocję.
    */
    public DiscountResult calculate(
            Cart cart
    ){



        /*
            Liczymy normalną wartość koszyka.
        */
        BigDecimal subtotal =
                cart.getItems()
                .stream()
                .map(item ->
                        item.getBook()
                        .getPrice()
                        .multiply(
                            BigDecimal.valueOf(
                                item.getQuantity()
                            )
                        )
                )
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );





        /*
            Obliczamy pierwszą promocję.

            Kup 3 książki:

            najtańsza -50%
        */
        BigDecimal discount1 =
                calculateThreeBooksDiscount(cart);





        /*
            Druga promocja:

            Koszyk powyżej 200 zł

            -15%
        */
        BigDecimal discount2 =
                calculateOver200Discount(subtotal);





        /*
            Wybieramy większy rabat.
        */


        if(discount1.compareTo(discount2) > 0){


            return createResult(
                    subtotal,
                    discount1,
                    "3 książki - najtańsza 50%"
            );


        }else if(discount2.compareTo(BigDecimal.ZERO)>0){


            return createResult(
                    subtotal,
                    discount2,
                    "15% powyżej 200 zł"
            );


        }




        /*
            Brak promocji.
        */
        return createResult(
                subtotal,
                BigDecimal.ZERO,
                "Brak promocji"
        );


    }







    /*
        Promocja:

        Minimum 3 książki

        Najtańsza połowę taniej
    */
    private BigDecimal calculateThreeBooksDiscount(
            Cart cart
    ){


        int amount =
                cart.getItems()
                .stream()
                .mapToInt(
                    CartItem::getQuantity
                )
                .sum();



        if(amount < 3){

            return BigDecimal.ZERO;

        }




        BigDecimal cheapest =
                cart.getItems()
                .stream()
                .map(item ->
                        item.getBook()
                        .getPrice()
                )
                .min(
                    Comparator.naturalOrder()
                )
                .orElse(BigDecimal.ZERO);



        return cheapest
                .divide(
                    BigDecimal.valueOf(2),
                    2,
                    RoundingMode.HALF_UP
                );

    }






    /*
        Promocja:

        wartość koszyka > 200 zł

        rabat 15%
    */
    private BigDecimal calculateOver200Discount(
            BigDecimal subtotal
    ){


        if(
            subtotal.compareTo(
                BigDecimal.valueOf(200)
            ) > 0
        ){


            return subtotal
                    .multiply(
                        BigDecimal.valueOf(0.15)
                    )
                    .setScale(
                        2,
                        RoundingMode.HALF_UP
                    );

        }



        return BigDecimal.ZERO;

    }







    /*
        Tworzenie wyniku.
    */
    private DiscountResult createResult(
            BigDecimal subtotal,
            BigDecimal discount,
            String name
    ){


        return new DiscountResult(

                subtotal,

                discount,

                subtotal.subtract(discount),

                name

        );

    }



}
