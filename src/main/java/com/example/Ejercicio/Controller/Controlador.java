package com.example.Ejercicio.Controller;

import com.example.Ejercicio.Model.Producto;
import com.example.Ejercicio.Servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


/**
 * <p>
 * Este es el controlador de Producto.
 * </p>
 * <p> Esta clase maneja las operaciones de CRUD de Producto, y tambien las paginas web.</p>
 *
 * @autor Manuel Alvial
 */

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private ProductoService service;


    /**
     * <p>
     * Esta funcion lista todos los productos creados en la base de datos Producto.
     * </p>
     *
     * @autor Manuel Alvial
     */
    @GetMapping("/main")
    public String listar(Model model) {
        List<Producto> productos = service.mostrar();
        model.addAttribute("productos", productos);
        return "index";
    }

    /**
     * @Manuel Esta Funcion Sirve para editar un producto ya creado en la base de datos de producto, las llama por su id correspondiente.
     */

    /**
     * <p>
     * Esta funcion Edita un producto previamente creado en la base de datos Producto, esto lo hace llamando un Producto por su id.
     * </p>
     *
     * @autor Manuel Alvial
     */
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Producto> producto = service.getID(id);
        model.addAttribute("producto", producto);
        return "modificar";
    }


    /**
     * <p>
     * Esta funcion guarda un Producto creado en el html.
     * </p>
     *
     * <p>Requiere utilizar la funcion "th:action" de Thymeleaf en el html</p>
     *
     * @autor Manuel Alvial
     */
    @PostMapping("/save")
    public String save(@Validated Producto p, Model model) {
        service.save(p);
        return "redirect:/main";
    }

    /**
     * @Manuel Esta funcion obtiene la id de un producto en especifico y la elimina de la base de datos.
     */
    /**
     * <p>
     * Esta funcion elimina un Producto de la base de datos.
     * </p>
     * <p> Esto lo hace obteniendo la id de el Producto que desea eliminar, y luego utilizando la funcion deleteById de CRUDRepository</p>
     *
     * @autor Manuel Alvial
     */
    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable int id, Model model) {
        service.delete(id);
        return "redirect:/main";
    }
}