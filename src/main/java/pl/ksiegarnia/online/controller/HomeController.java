package pl.ksiegarnia.online.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;



/*
    Zwykły kontroler stron HTML.
*/
@Controller
public class HomeController {



    /*
        Strona startowa.
    */
    @GetMapping("/")
    public String home(){


        return "redirect:/books";


    }


}
