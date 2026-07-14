package pl.ksiegarnia.online.controller;



import org.springframework.web.bind.annotation.*;


import pl.ksiegarnia.online.cart.Cart;
import pl.ksiegarnia.online.cart.CartItem;
import pl.ksiegarnia.online.dto.CartCalculationResponse;
import pl.ksiegarnia.online.model.Book;
import pl.ksiegarnia.online.repository.BookRepository;
import pl.ksiegarnia.online.service.CartCalculatorService;


import java.util.List;



/*
    REST Controller.

    Obsługuje zapytania HTTP.

    Tutaj znajduje się endpoint
    wymagany w zadaniu.
*/
@RestController
@RequestMapping("/api/cart")
public class CartController {



    private final BookRepository bookRepository;


    private final CartCalculatorService calculatorService;





    public CartController(
            BookRepository bookRepository,
            CartCalculatorService calculatorService
    ){

        this.bookRepository = bookRepository;
        this.calculatorService = calculatorService;

    }






    /*
        POST:

        /api/cart/calculate


        Przykładowe wejście:

        [
          1,
          3,
          5
        ]


        Są to ID książek.
    */
    @PostMapping("/calculate")
    public CartCalculationResponse calculateCart(
            @RequestBody List<Long> bookIds
    ){



        /*
            Tworzymy pusty koszyk.
        */
        Cart cart = new Cart();





        /*
            Dla każdego ID:

            pobieramy książkę z bazy

            i dodajemy do koszyka.
        */
        for(Long id : bookIds){



            Book book =
                    bookRepository
                    .findById(id)
                    .orElse(null);



            if(book != null){


                cart.addItem(
                        new CartItem(
                                book,
                                1
                        )
                );

            }


        }





        /*
            Liczymy promocję.
        */
        var result =
                calculatorService.calculate(cart);





        /*
            Zamieniamy wynik
            na obiekt JSON.
        */
        return new CartCalculationResponse(

                result.getSubtotal(),

                result.getDiscount(),

                result.getTotal(),

                result.getPromotion()

        );


    }


}
