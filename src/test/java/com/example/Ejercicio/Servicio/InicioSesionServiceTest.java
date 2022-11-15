package com.example.Ejercicio.Servicio;

import com.example.Ejercicio.Model.InicioSesion;
import com.example.Ejercicio.Model.Producto;
import com.example.Ejercicio.Repository.RepoInicioSesion;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;
import java.util.function.BooleanSupplier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InicioSesionServiceTest {


    @Autowired
    private RepoInicioSesion dataInicioSesion;



    @ParameterizedTest
    @ValueSource(strings = {"juan", "pedro", "rodrigo", "ismael", "antonia"})
    @Rollback(false)
    @Order(1)
    @DisplayName("Test para registrar usuarios")
    public void save(String username) {
        InicioSesion user = new InicioSesion(username, "test", "correoprueba@ufromail.cl");
        InicioSesion usuarioguardado = dataInicioSesion.save(user);

        assertNotNull(usuarioguardado);
    }



    @ParameterizedTest
    @CsvSource({"juan, 1", "pedro, 2", "rodrigo, 3", "ismael, 4", "antonia, 5"})
    @Rollback(false)
    @Order(1)
    @DisplayName("Test para Login")
    void iniciar(String username, int id) {

        Optional<InicioSesion> usuarioRegistrado = dataInicioSesion.findById(id);
        assertThat(username).isEqualTo(usuarioRegistrado.get().getNombreuser());

        assertThat("test").isEqualTo(usuarioRegistrado.get().getContrasena());
    }


}