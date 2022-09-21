package com.example.Ejercicio.Controller;

import com.example.Ejercicio.Model.Producto;
import com.example.Ejercicio.Servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IProductoServicio service;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Producto> productos = service.listar();
        model.addAttribute("productos", productos);
        return "index";
    }

    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("producto",new Producto());
        return "index";
    }

    @PostMapping("/save")
    public String save(@Validated Producto p, Model model){
        service.save(p);
        return "redirect:/listar";
    }
}
