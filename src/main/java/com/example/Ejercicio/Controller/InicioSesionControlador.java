package com.example.Ejercicio.Controller;

import com.example.Ejercicio.Model.User;
import com.example.Ejercicio.Servicio.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class InicioSesionControlador {
    @Autowired
    private UserService userData;

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/register")
    public String registro(Model model) {
        model.addAttribute("usuario", new User());
        return "register";
    }

    @PostMapping("/register")
    public String guardarUsuario(User usuario, SessionStatus status) {

        //Pasar nueva contraseña cifrada
        usuario.setClave(userData.cifrarClave(usuario.getClave()));

        usuario.setRoles("ROLE_USER");

        userData.guardar(usuario);
        status.setComplete();
        return "redirect:/main";
    }

    @GetMapping("/info-usuario")
    public String userInfo() {
        return "info-usuario";
    }
}
