package com.example.Ejercicio.Controller;

import com.example.Ejercicio.Model.InicioSesion;
import com.example.Ejercicio.Model.Producto;
import com.example.Ejercicio.Servicio.InicioSesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class ControladorInicioSesion {
    @Autowired
    private InicioSesionService service;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView result = new ModelAndView("login");
        result.addObject("usuario", new InicioSesion());
        return result;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("usuario") InicioSesion usuarios) {
        InicioSesion usuarioAut = service.Iniciar(usuarios.getNombreuser(), usuarios.getContrasena());

        System.out.println(usuarioAut);
        if (Objects.nonNull(usuarioAut)) {
            return "redirect:/listar";
        } else {

            return "redirect:/login";
        }
    }

    @PostMapping("/saveuser")
    public String save(@Validated InicioSesion u, Model model){
        service.save(u);
        return "redirect:/login";
    }

}
