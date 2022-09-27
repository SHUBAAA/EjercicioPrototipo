package com.example.Ejercicio.Servicio;

import com.example.Ejercicio.Model.InicioSesion;
import com.example.Ejercicio.Model.Producto;
import com.example.Ejercicio.Repository.RepoInicioSesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InicioSesionService {

    @Autowired
    private RepoInicioSesion dataInicioSesion;

    public InicioSesion Iniciar(String nombreuser, String contrasena) {
        InicioSesion usuario = dataInicioSesion.findByNombreuserAndContrasena(nombreuser, contrasena);
        return usuario;
    }

    public int save(InicioSesion u) {
        int res = 0;
        InicioSesion usuario = dataInicioSesion.save(u);
        if (!usuario.equals(null)) {
            res = 1;
        }
        return 0;
    }
}
