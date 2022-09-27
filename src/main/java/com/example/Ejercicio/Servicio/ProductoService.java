package com.example.Ejercicio.Servicio;

import com.example.Ejercicio.Model.Producto;
import com.example.Ejercicio.Repository.RepoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * Esta clase es el servicio para Producto.
 * </p>
 * <p>Maneja toda la parte logistica y se la envia a el controlador</p>
 *
 * <p>Utiliza los datos del Repositorio y los maneja como data</p>
 *
 * @autor Manuel Alvial
 */
@Service
public class ProductoService {

    @Autowired
    private RepoProducto dataProducto;

    /**
     * <p>
     * Esta funcion retorna toda la informacion de la tabla de Producto
     * </p>
     * <p>Como parametro necesita la Lista de Producto</p>
     *
     * @autor Manuel Alvial
     */
    public List<Producto> mostrar() {
        return (List<Producto>) dataProducto.findAll();
    }

    /**
     * <p>
     * Esta funcion Retorna un Producto dependiendo de la ID dada.
     * </p>
     *
     * <p>Se tiene que ingresar como parametro una ID, y la busca en la base de datos</p>
     *
     * @autor Manuel Alvial
     */
    public Optional<Producto> getID(int id) {
        return dataProducto.findById(id);
    }

    /**
     * <p>
     * Esta funcion guarda un Producto con todos sus datos en la base de datos.
     * </p>
     *
     * <p>Se le tiene que ingresar como parametro un Producto ya creado con un constructor y lo guarda</p>
     *
     * @autor Manuel Alvial
     */

    public void save(Producto p) {
        dataProducto.save(p);
    }

    /**
     * <p>
     * Esta funcion Elimina un Producto
     * </p>
     *
     * <p>Se le tiene que Ingresar como parametro la id de el producto que desea eliminar y la elimina</p>
     *
     * @autor Manuel Alvial
     */
    public void delete(int id) {
        dataProducto.deleteById(id);
    }
}
