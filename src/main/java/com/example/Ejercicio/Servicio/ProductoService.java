package com.example.Ejercicio.Servicio;

import com.example.Ejercicio.Model.Producto;
import com.example.Ejercicio.Repository.InterProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoServicio {

    @Autowired
    private InterProducto dataProducto;

    @Override
    public List<Producto> listar() {
        return (List<Producto>) dataProducto.findAll();
    }

    @Override
    public Optional<Producto> listarId(int id) {
        return Optional.empty();
    }

    @Override
    public int save(Producto p) {
        int res = 0;
        Producto producto = dataProducto.save(p);
        if (!producto.equals(null)) {
            res = 1;
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
