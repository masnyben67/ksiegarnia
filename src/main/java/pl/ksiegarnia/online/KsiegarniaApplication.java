package pl.ksiegarnia.online;


// Import uruchamiający Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/*
    Główna klasa programu.

    Spring Boot zaczyna wykonywanie aplikacji właśnie tutaj.

    Adnotacja @SpringBootApplication oznacza:
    - włącz konfigurację Springa
    - znajdź kontrolery
    - znajdź serwisy
    - znajdź repozytoria
 */
@SpringBootApplication
public class KsiegarniaApplication {


    public static void main(String[] args) {


        /*
            Uruchomienie całej aplikacji.

            Po starcie będzie dostępna pod:

            http://localhost:8080
        */
        SpringApplication.run(
                KsiegarniaApplication.class,
                args
        );

    }

}
