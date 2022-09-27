package com.example.Ejercicio.Model;

import javax.persistence.*;

@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreuser() {
        return nombreuser;
    }

    public void setNombreuser(String nombreuser) {
        this.nombreuser = nombreuser;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}