package com.example.Ejercicio.Repository;

import com.example.Ejercicio.Model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterProducto extends CrudRepository<Producto,Integer> {
}
