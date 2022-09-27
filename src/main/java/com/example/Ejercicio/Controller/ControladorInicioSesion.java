package com.example.Ejercicio.Controller;

import com.example.Ejercicio.Model.InicioSesion;
import com.example.Ejercicio.Servicio.InicioSesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

/**
 * <p>
 * Este es el controlador para InicioSesion.
 * </p>
 *
 * @autor Manuel Alvial
 */
@Controller
public class ControladorInicioSesion {
    @Autowired
    private InicioSesionService service;


    /**
     * <p>
     * Esta funcion guarda los datos ingresados en el html de Login.
     * </p>
     *
     * @autor Manuel Alvial
     */
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView logindata = new ModelAndView("login");
        logindata.addObject("usuario", new InicioSesion());
        return logindata;
    }


    /**
     * <p>
     * Esta funcion tomas los datos ingresados previamente, y los compara con la base de datos de InicioSesion.
     * </p>
     * <p>Si no existe devuelve un null y te redirecciona a login, pero si existe te redirecciona a main</p>
     *
     * @autor Manuel Alvial
     */
    @PostMapping("/login")
    public String login(@ModelAttribute("usuario") InicioSesion usuarios) {
        InicioSesion usuarioAut = service.Iniciar(usuarios.getNombreuser(), usuarios.getContrasena());


        if (Objects.nonNull(usuarioAut)) {
            return "redirect:/main";
        } else {

            return "redirect:/login";
        }
    }



    /**
     * <p>
     * Esta funcion guarda en la base de datos de InicioSesion.
     * </p>
     * <p> Esto lo hace con la funcion th:action de Thymeleaf</p>
     *
     * @autor Manuel Alvial
     */
    @PostMapping("/saveuser")
    public String save(@Validated InicioSesion u, Model model) {
        service.save(u);
        return "redirect:/login";
    }

}
