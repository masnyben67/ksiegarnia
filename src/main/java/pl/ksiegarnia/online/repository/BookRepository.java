package pl.ksiegarnia.online.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.ksiegarnia.online.model.Book;



/*
    Repozytorium książek.

    Dzięki JpaRepository dostajemy automatycznie:

    findAll()       - wszystkie książki
    findById()      - książka po ID
    save()          - zapisanie książki
    delete()        - usunięcie


    Nie musimy pisać SQL.
*/
@Repository
public interface BookRepository 
        extends JpaRepository<Book, Long> {


}
