package pl.ksiegarnia.online.model;



/*
    Enum przechowuje możliwe statusy zamówienia.

    Zamiast pisać String:

    "NOWE"
    "WYSŁANE"


    mamy bezpieczne wartości.
*/
public enum OrderStatus {


    // Zamówienie zostało złożone
    NEW,


    // Książki zostały wysłane
    SENT,


    // Zamówienie zakończone
    COMPLETED

}
