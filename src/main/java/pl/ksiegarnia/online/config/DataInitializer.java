package pl.ksiegarnia.online.config;



import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import pl.ksiegarnia.online.model.Book;
import pl.ksiegarnia.online.repository.BookRepository;


import java.math.BigDecimal;



/*
    Klasa uruchamiająca się podczas startu aplikacji.

    Dodaje przykładowe dane do bazy H2.

    Dzięki temu po wejściu na stronę
    od razu mamy książki.
*/
@Configuration
public class DataInitializer {



    @Bean
    CommandLineRunner initDatabase(
            BookRepository repository
    ){


        return args -> {



            /*
                Dodajemy przykładowe książki.
            */


            repository.save(
                    new Book(
                            "Java od podstaw",
                            new BigDecimal("80.00"),
                            "Programowanie"
                    )
            );


            repository.save(
                    new Book(
                            "Spring Boot w praktyce",
                            new BigDecimal("120.00"),
                            "Programowanie"
                    )
            );



            repository.save(
                    new Book(
                            "Władca Pierścieni",
                            new BigDecimal("60.00"),
                            "Fantasy"
                    )
            );



            repository.save(
                    new Book(
                            "Hobbit",
                            new BigDecimal("45.00"),
                            "Fantasy"
                    )
            );



            repository.save(
                    new Book(
                            "Czysty Kod",
                            new BigDecimal("95.00"),
                            "Programowanie"
                    )
            );



            repository.save(
                    new Book(
                            "Historia Polski",
                            new BigDecimal("70.00"),
                            "Historia"
                    )
            );



            repository.save(
                    new Book(
                            "Minecraft poradnik",
                            new BigDecimal("50.00"),
                            "Gry"
                    )
            );



            repository.save(
                    new Book(
                            "Algorytmy",
                            new BigDecimal("130.00"),
                            "Programowanie"
                    )
            );



            repository.save(
                    new Book(
                            "Cyberbezpieczeństwo",
                            new BigDecimal("110.00"),
                            "IT"
                    )
            );



            repository.save(
                    new Book(
                            "Linux dla początkujących",
                            new BigDecimal("75.00"),
                            "IT"
                    )
            );



            System.out.println(
                    "==== Dodano książki startowe ===="
            );


        };


    }


}
