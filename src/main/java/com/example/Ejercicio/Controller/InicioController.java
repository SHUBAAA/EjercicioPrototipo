package com.example.Ejercicio.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping({"/"})
    public String inicio() {
        return "login";
    }

    @GetMapping("/saludo")
    public String saludo() {
        return "saludo";
    }



}
