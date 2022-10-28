package com.example.Ejercicio.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String clave;
    private String roles;

    public User() {
    }

    public User(String nombre, String clave, String roles) {
        this.nombre = nombre;
        this.clave = clave;
        this.roles = roles;
    }
}
