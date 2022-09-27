package com.example.Ejercicio.Repository;

import com.example.Ejercicio.Model.InicioSesion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoInicioSesion extends CrudRepository<InicioSesion,Long> {

    InicioSesion findByNombreuserAndContrasena(String nombreuser, String contrasena);
}
