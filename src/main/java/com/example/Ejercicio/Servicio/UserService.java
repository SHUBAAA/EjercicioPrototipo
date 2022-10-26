package com.example.Ejercicio.Servicio;

import java.util.Arrays;
import java.util.HashSet;

import com.example.Ejercicio.Model.Role;
import com.example.Ejercicio.Model.User;
import com.example.Ejercicio.Repository.RoleRepository;
import com.example.Ejercicio.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;


    public void saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatus("VERIFIED");
        Role userRole = roleRepository.findByRole("SITE_USER");
        userRepository.save(user);
    }


    public boolean isUserAlreadyPresent(User user) {
        // Try to implement this method, as assignment.
        return false;
    }

}
