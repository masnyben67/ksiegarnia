package pl.ksiegarnia.online.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;



/*
    Główna konfiguracja bezpieczeństwa.


    Spring Security odpowiada za:

    - logowanie
    - sesje użytkowników
    - blokowanie stron
*/
@Configuration
public class SecurityConfig {




    /*
        Konfiguracja dostępu do stron.
    */
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {



        http


        /*
            Wyłączenie CSRF.

            Przy prostym projekcie
            egzaminacyjnym ułatwia obsługę formularzy.
        */
        .csrf(csrf -> csrf.disable())



        .authorizeHttpRequests(auth -> auth



            /*
                Strony dostępne dla każdego.
            */
            .requestMatchers(

                    "/",
                    "/books",
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/api/cart/calculate"

            )
            .permitAll()



            /*
                Wszystko inne wymaga logowania.
            */
            .anyRequest()
            .authenticated()


        )




        /*
            Włączamy standardową stronę logowania Springa.
        */
        .formLogin(login -> login


                /*
                    Po zalogowaniu
                    wracamy do katalogu.
                */
                .defaultSuccessUrl(
                        "/books",
                        true
                )

                .permitAll()

        );




        return http.build();

    }







    /*
        Tworzenie użytkownika.


        Na potrzeby egzaminu
        użytkownik jest w pamięci.


        Login:

        user


        Hasło:

        1234
    */
    @Bean
    public UserDetailsService users(){



        UserDetails user = User

                .withUsername(
                        "user"
                )

                .password(
                        passwordEncoder()
                        .encode("1234")
                )

                .roles(
                        "CLIENT"
                )

                .build();




        return new InMemoryUserDetailsManager(
                user
        );

    }






    /*
        Kodowanie hasła.

        Spring Security nie przechowuje
        zwykłego tekstu.
    */
    @Bean
    public PasswordEncoder passwordEncoder(){


        return new BCryptPasswordEncoder();


    }



}
