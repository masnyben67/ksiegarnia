# Księgarnia Internetowa


## Opis projektu

Aplikacja webowa sklepu internetowego sprzedającego książki.

Projekt wykonany w technologii:

- Java 21
- Spring Boot
- Spring MVC
- Thymeleaf
- Spring Data JPA
- H2 Database
- Spring Security
- Swagger
- JUnit 5



# Funkcje


## Katalog książek

Każdy użytkownik może:

- przeglądać książki
- zobaczyć cenę
- zobaczyć kategorię



## Koszyk

Zalogowany klient może:

- dodawać książki
- sprawdzić podsumowanie
- złożyć zamówienie



## Promocje


System automatycznie wybiera najlepszy rabat:


### Promocja 1

Kup 3 książki.

Najtańsza książka jest 50% taniej.


### Promocja 2

Koszyk powyżej 200 zł.

15% rabatu.



## REST API


Endpoint:


POST

/api/cart/calculate


Przykładowe dane:


[
1,
2,
3
]



Odpowiedź:


{
"subtotal":245,
"discount":36.75,
"total":208.25,
"promotion":"15% powyżej 200 zł"
}




# Logowanie


Użytkownik:


login:

user


hasło:

1234



# Swagger


Adres:


http://localhost:8080/swagger-ui.html




# Uruchomienie


1. Otworzyć projekt w IntelliJ IDEA.


2. Poczekać na pobranie zależności Maven.


3. Uruchomić klasę:


KsiegarniaApplication


4. Wejść:


http://localhost:8080/books

