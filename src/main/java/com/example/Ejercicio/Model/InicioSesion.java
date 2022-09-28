package com.example.Ejercicio.Model;

import lombok.Data;

import javax.persistence.*;

/**
 * Esta clase es el modelo para InicioSesion.
 *
 * <p>
 * Esta clase crea la base de datos InicioSesion y crea las respectivas Columnas ingresadas como variables. * </p>
 *
 * @author Manuel Alvial
 */
@Entity
@Data
public class InicioSesion {


    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nombreuser;
    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private String correo;

    public InicioSesion() {
    }

    public InicioSesion(Long id, String nombreuser, String contrasena, String correo) {
        this.id = id;
        this.nombreuser = nombreuser;
        this.contrasena = contrasena;
        this.correo = correo;
    }

}