package com.example.Ejercicio.Controller;


import com.example.Ejercicio.Model.User;
import com.example.Ejercicio.Servicio.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
public class ControladorAdmin {

    @Autowired
    private UserService userservice;

    @GetMapping("/admin")
    public String listar(Model model) {
        List<User> usuario = userservice.listar();
        model.addAttribute("usuarios", usuario);
        return "admin";
    }

    @PostMapping("/register")
    public String guardarUsuario(User usuario, SessionStatus status) {

        usuario.setClave(userservice.cifrarClave(usuario.getClave()));
        userservice.guardar(usuario);
        status.setComplete();
        return "redirect:/admin";
    }



}
