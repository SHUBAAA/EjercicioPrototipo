package com.example.Ejercicio.Repository;

import com.example.Ejercicio.Model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Esta interface aplica los metodos CRUD y los guarda como un repositorio.
 * </p>
 *
 * @autor Manuel Alvial
 */
@Repository
public interface RepoProducto extends CrudRepository<Producto, Integer> {
}
