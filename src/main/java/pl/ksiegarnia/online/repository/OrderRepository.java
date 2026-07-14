package pl.ksiegarnia.online.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.ksiegarnia.online.model.Order;



/*
    Repozytorium zamówień.

    Spring sam generuje implementację.
*/
@Repository
public interface OrderRepository 
        extends JpaRepository<Order, Long> {


}
