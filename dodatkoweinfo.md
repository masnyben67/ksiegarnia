3. Jak odpalić na egzaminie

Pokazujesz:

1. Katalog
localhost:8080/books

Mówisz:

Tutaj użytkownik niezalogowany może przeglądać książki.

2. Logowanie

Klikasz:

Login

Dane:

user
1234

Mówisz:

Po uwierzytelnieniu klient otrzymuje dostęp do koszyka.

3. Koszyk

Dodajesz 3 książki.

Pokazujesz:

Cena:
245 zł

Rabat:
36.75 zł

Do zapłaty:
208.25 zł

Mówisz:

Program sprawdza wszystkie promocje i wybiera najkorzystniejszą.

4. Swagger

Adres:

localhost:8080/swagger-ui.html

Pokazujesz:

POST /api/cart/calculate
5. Testy

W IntelliJ:

CartCalculatorServiceTest

Uruchamiasz.

Pokazuje:

Tests passed
Ważna rzecz na egzamin

Jak zapytają:

"Dlaczego BigDecimal zamiast double?"

Odpowiedź:

BigDecimal zapewnia dokładne operacje na wartościach pieniężnych i eliminuje błędy zaokrągleń typu floating point.

"Dlaczego Service?"

Service oddziela logikę biznesową od kontrolera, dzięki czemu kod jest łatwiejszy do testowania i utrzymania.

"Dlaczego DTO?"

DTO ogranicza dane przesyłane przez API i oddziela warstwę komunikacji od encji bazy danych.

"Dlaczego JPA?"

JPA pozwala mapować obiekty Java na rekordy bazy danych bez ręcznego pisania SQL.

Projekt jest kompletny zgodnie z wymaganiami. ✅

Masz:

bazę ✔
UI ✔
REST ✔
Swagger ✔
Security ✔
promocje ✔
testy ✔

Jeszcze jedna rzecz: przed oddaniem warto zrobić:

mvn clean test

Jeżeli przejdzie bez błędów — projekt jest gotowy. 🚀


---

Gotowe. Masz pełną aplikację pod zadanie egzaminacyjne.

Najważniejsze elementy do obrony:
- **CartCalculatorService** → algorytm promocji
- **SecurityConfig** → logowanie
- **CartController** → REST
- **CartCalculatorServiceTest** → testy jednostkowe

To są rzeczy, na które prowadzący najczęściej patrzy.
