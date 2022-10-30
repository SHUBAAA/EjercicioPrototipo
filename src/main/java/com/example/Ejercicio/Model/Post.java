package com.example.Ejercicio.Model;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
public class Post {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    ////////////////////////////////
    @Column(name = "titulo", nullable = false, length = 120)
    private String titulo;

    @Column(name = "cuerpo", nullable = false, columnDefinition = "text")
    private String cuerpo;

    @Column(name = "fecha")
    private Timestamp fecha;

    @Column(name = "cover_picture", columnDefinition = "TEXT")
    private String coverPicture;

    @ManyToOne

    @JoinColumn(name = "autor_id", nullable = false)
    private User autor;

    public Post() {
    }


}
