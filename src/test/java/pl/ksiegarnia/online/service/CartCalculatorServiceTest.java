package pl.ksiegarnia.online.service;


import org.junit.jupiter.api.Test;

import pl.ksiegarnia.online.cart.Cart;
import pl.ksiegarnia.online.cart.CartItem;
import pl.ksiegarnia.online.model.Book;


import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.*;



/*
    Testy kalkulatora koszyka.


    Sprawdzamy czy:

    - promocje działają
    - wybierana jest najlepsza promocja
    - kwoty są poprawne
*/
public class CartCalculatorServiceTest {



    /*
        Tworzymy kalkulator,
        który będziemy testować.
    */
    private final CartCalculatorService calculator =
            new CartCalculatorService();






    /*
        TEST 1


        Kupujemy 3 książki.


        Najtańsza powinna być za połowę ceny.
    */
    @Test
    void shouldApplyHalfPriceForCheapestBook(){



        Cart cart = new Cart();




        cart.addItem(

                new CartItem(

                        new Book(
                                "Java",
                                new BigDecimal("100"),
                                "IT"
                        ),

                        1

                )

        );




        cart.addItem(

                new CartItem(

                        new Book(
                                "Spring",
                                new BigDecimal("80"),
                                "IT"
                        ),

                        1

                )

        );




        cart.addItem(

                new CartItem(

                        new Book(
                                "Hobbit",
                                new BigDecimal("40"),
                                "Fantasy"
                        ),

                        1

                )

        );





        var result =
                calculator.calculate(cart);





        /*
            Najtańsza książka:

            40 zł

            połowa:

            20 zł rabatu
        */
        assertEquals(
                new BigDecimal("20.00"),
                result.getDiscount()
        );



        assertEquals(
                "3 książki - najtańsza 50%",
                result.getPromotion()
        );



    }







    /*
        TEST 2


        Koszyk powyżej 200 zł.


        Powinno dać 15%.
    */
    @Test
    void shouldApply15PercentDiscount(){



        Cart cart = new Cart();




        cart.addItem(

                new CartItem(

                        new Book(
                                "Książka",
                                new BigDecimal("300"),
                                "IT"
                        ),

                        1

                )

        );






        var result =
                calculator.calculate(cart);





        /*
            300 * 15%

            =45 zł
        */
        assertEquals(

                new BigDecimal("45.00"),

                result.getDiscount()

        );



        assertEquals(

                "15% powyżej 200 zł",

                result.getPromotion()

        );



    }








    /*
        TEST 3


        Sprawdzamy wybór lepszej promocji.


        Koszyk:

        120
        100
        40


        Razem:

        260


        Promocja 1:

        20 rabatu


        Promocja 2:

        39 rabatu


        Powinna wygrać 15%.
    */
    @Test
    void shouldChooseBetterPromotion(){



        Cart cart = new Cart();




        cart.addItem(

                new CartItem(

                        new Book(
                                "A",
                                new BigDecimal("120"),
                                "IT"
                        ),
                        1

                )

        );



        cart.addItem(

                new CartItem(

                        new Book(
                                "B",
                                new BigDecimal("100"),
                                "IT"
                        ),
                        1

                )

        );



        cart.addItem(

                new CartItem(

                        new Book(
                                "C",
                                new BigDecimal("40"),
                                "IT"
                        ),
                        1

                )

        );





        var result =
                calculator.calculate(cart);





        assertEquals(

                new BigDecimal("39.00"),

                result.getDiscount()

        );



        assertEquals(

                "15% powyżej 200 zł",

                result.getPromotion()

        );



    }








    /*
        TEST 4


        Brak promocji.


        Koszyk poniżej 200 zł
        i mniej niż 3 książki.
    */
    @Test
    void shouldNotApplyDiscount(){



        Cart cart = new Cart();



        cart.addItem(

                new CartItem(

                        new Book(
                                "Test",
                                new BigDecimal("50"),
                                "IT"
                        ),

                        1

                )

        );






        var result =
                calculator.calculate(cart);






        assertEquals(

                BigDecimal.ZERO,

                result.getDiscount()

        );



        assertEquals(

                "Brak promocji",

                result.getPromotion()

        );



    }



}
