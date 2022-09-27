package com.example.Ejercicio.Servicio;

import com.example.Ejercicio.Model.Producto;
import com.example.Ejercicio.Repository.RepoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService{

    @Autowired
    private RepoProducto dataProducto;


    public List<Producto> mostrar() {
        return (List<Producto>) dataProducto.findAll();
    }


    public Optional<Producto> getID(int id) {
        return dataProducto.findById(id);
    }


    public int save(Producto p) {
        int res = 0;
        Producto producto = dataProducto.save(p);
        if (!producto.equals(null)) {
            res = 1;
        }
        return 0;
    }


    public void delete(int id) {
        dataProducto.deleteById(id);
    }
}
