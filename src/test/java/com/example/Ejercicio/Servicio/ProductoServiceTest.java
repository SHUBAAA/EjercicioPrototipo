package com.example.Ejercicio.Servicio;

import com.example.Ejercicio.Model.Producto;
import com.example.Ejercicio.Repository.RepoProducto;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductoServiceTest {
    List<Producto> productos;
    @Autowired
    private RepoProducto repoproducto;


    @Before("before")
    public void setUp() {
        productos = (List<Producto>) repoproducto.findAll();

    }

    @After("after")
    public void after() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    @ParameterizedTest
    @CsvSource({"producto1,descripcion1,categoria1", "producto2,descripcion2,categoria2","producto3,descripcion3,categoria3", "producto4,descripcion4,categoria4", "producto5,descripcion5,categoria5"})
    @Rollback(false)
    @Order(1)
    @DisplayName("Test Guardado producto")
    public void testSaveProducto(String nombreProducto, String descripcionProducto, String categoriaProducto) {
        Producto producto = new Producto(nombreProducto, descripcionProducto, 999999, categoriaProducto);
        Producto productoGuardado = repoproducto.save(producto);

        assertNotNull(productoGuardado);

    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @Rollback(false)
    @Order(2)
    @DisplayName("Test Para Modificar Producto con valor incorrecto")
    public void testModificarProducto(int numeros) {
        String nombremod = "productomodificado";
        String descripcionmod = "descripcionmodificado";
        String categoriamod = "categoriaModificada";
        int id = numeros;
        Producto producto = new Producto(nombremod, descripcionmod, 333, categoriamod);
        producto.setId(id);

        repoproducto.save(producto);
        Optional<Producto> productoModificado = repoproducto.findById(id);
        assertThat(productoModificado.get().getId()).isEqualTo(id);
        assertThat(productoModificado.get().getNombre()).isEqualTo(nombremod);
        assertThat(productoModificado.get().getDescripcion()).isEqualTo(descripcionmod);
        assertThat(productoModificado.get().getCategoria()).isEqualTo(categoriamod);
    }

    @ParameterizedTest
    @CsvSource({"producto1,descripcion1,categoria1", "producto2,descripcion2,categoria2","producto3,descripcion3,categoria3", "producto4,descripcion4,categoria4", "producto5,descripcion5,categoria5"})
    @Rollback(false)
    @Order(3)
    @DisplayName("Test Para Modificar Producto")
    public void testModificarProductomalo(String nombre, String descripcion, String categoria) {
        String nombremod = "productomodificado2";
        String descripcionmod = "descripcionmodificado2";
        String categoriamod = "categoriaModificada2";
        int id = 1;
        Producto producto = new Producto(nombremod, descripcionmod, 333, categoriamod);
        producto.setId(id);

        repoproducto.save(producto);
        Optional<Producto> productoModificado = repoproducto.findById(id);
        assertThat(productoModificado.get().getId()).isEqualTo(id);
        assertThat(productoModificado.get().getNombre()).isNotEqualTo(nombre);
        assertThat(productoModificado.get().getDescripcion()).isNotEqualTo(descripcion);
        assertThat(productoModificado.get().getCategoria()).isNotEqualTo(categoria);
    }

    @Test
    @Order(4)
    @DisplayName("Test Para Mostrar Lista de Productos")
    public void testMostrarlista() {
        List<Producto> productos = (List<Producto>) repoproducto.findAll();
        assertThat(productos.size()).isGreaterThan(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @Rollback(false)
    @Order(5)
    @DisplayName("Test Para Borrar Producto")
    public void testDelete(int numeros) {
        int id = numeros;

        boolean existeAntes = repoproducto.findById(id).isPresent();

        repoproducto.deleteById(id);

        boolean noExisteDespues = repoproducto.findById(id).isPresent();

        assertTrue(existeAntes);
        assertFalse(noExisteDespues);
    }


    @Test
    @Order(6)
    @DisplayName("Test Saber si la Lista de Productos esta vacia")
    public void testMostrarlistavacia() {
        List<Producto> productos = (List<Producto>) repoproducto.findAll();
        assertThat(productos.size()).isEqualTo(0);
    }
}