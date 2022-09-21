package com.example.Ejercicio.Servicio;

import com.example.Ejercicio.Model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoServicio {

    public List<Producto> listar();

    public Optional<Producto> listarId(int id);

    public int save(Producto p);

    public int delete(int id);
}
