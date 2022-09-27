package com.example.Ejercicio.Repository;

import com.example.Ejercicio.Model.InicioSesion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Esta interface aplica los metodos CRUD y los guarda como un repositorio.
 *
 * @autor Manuel Alvial
 */
@Repository
public interface RepoInicioSesion extends CrudRepository<InicioSesion, Long> {

    /**
     * <p>
     * Esta funcion busca los datos ingresados en la base de datos.
     * </p>
     *
     *
     * @autor Manuel Alvial
     */
    InicioSesion findByNombreuserAndContrasena(String nombreuser, String contrasena);
}
