package com.example.Ejercicio.Model;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
public class Boleta {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    ////////////////////////////////
    @Column(name = "titulo", nullable = false, length = 120)
    private String titulo;


    @Column(name = "total", nullable = false)
    private Long total;

    @Column(name = "fecha")
    private Timestamp fecha;

    @ManyToOne

    @JoinColumn(name = "autor_id", nullable = false)
    private User autor;

    public Boleta() {
    }


}
