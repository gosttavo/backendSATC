package com.example.exercicio07;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/recomendar")
    public String recomendarFilme(@RequestParam String genero, @RequestParam String ambiente) {
        String[] ambienteList = { "scifi", "medieval" };
        String[] generoList = { "comedia", "drama" };
        String[] movieList = {"Homens de Preto", "Arrival", "Shrek", "Gladiador"};

        String filmeReturn = "Please send a genero and ambiente param";

        if (genero.equals("comedia")) {
            if (ambiente.equals("scifi")) {
                filmeReturn = movieList[0];
            }

            if (ambiente.equals("medieval")) {
                filmeReturn = movieList[2];
            }
        }

        if (genero.equals("drama")) {
            if (ambiente.equals("scifi")) {
                filmeReturn = movieList[1];
            }

            if (ambiente.equals("medieval")) {
                filmeReturn = movieList[3];
            }
        }

        return filmeReturn;
    }
}
