package com.example.Ejercicio.Servicio;

import com.example.Ejercicio.Model.InicioSesion;
import com.example.Ejercicio.Repository.RepoInicioSesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Esta clase es el servicio para InicioSesion.
 * </p>
 * <p>Maneja toda la parte logistica y se la envia a el controlador</p>
 *
 * <p>Utiliza los datos del Repositorio y los maneja como data</p>
 *
 * @autor Manuel Alvial
 */
@Service
public class InicioSesionService {

    @Autowired
    private RepoInicioSesion dataInicioSesion;

    /**
     * <p>
     * Esta funcion busca en la base de datos InicioSesion si los datos ingresados existen.
     * </p>
     * <p>Se le tienen que ingresar los datos del Nombreuser y su contraseña</p>
     *
     * @autor Manuel Alvial
     */
    public InicioSesion Iniciar(String nombreuser, String contrasena) {
        InicioSesion usuario = dataInicioSesion.findByNombreuserAndContrasena(nombreuser, contrasena);
        return usuario;
    }

    /**
     * <p>
     * Esta funcion guarda un usuario con todos sus datos ingresados en la base de datos.
     * </p>
     * <p>Se le tiene que ingresar como parametro un InicioSesion ya creado con un constructor y lo guarda</p>
     *
     * @autor Manuel Alvial
     */
    public void save(InicioSesion u) {

        dataInicioSesion.save(u);

    }
}
