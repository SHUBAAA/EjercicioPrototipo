package com.example.Ejercicio.Repository;

import com.example.Ejercicio.Model.Producto;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioBoleta extends CrudRepository<Producto, Integer> {
}
