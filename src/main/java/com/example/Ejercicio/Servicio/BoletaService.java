package com.example.Ejercicio.Servicio;

import com.example.Ejercicio.Model.Boleta;
import com.example.Ejercicio.Model.Producto;
import com.example.Ejercicio.Repository.RepoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletaService {
    @Autowired
    private RepoProducto dataProducto;



    public List<Producto> listarBoleta() {
        return (List<Producto>) dataProducto.findAll();
    }
}