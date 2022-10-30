package com.example.Ejercicio.Servicio;

import com.example.Ejercicio.Model.User;
import com.example.Ejercicio.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository dataUser;

    public List<User> listar() {
        return (List<User>) dataUser.findAll();
    }


    public Optional<User> listarId(Long id) {
        return dataUser.findById(id);
    }


    public void guardar(User u) {
        dataUser.save(u);
    }


    public String cifrarClave(String clave) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(clave);
    }

}
