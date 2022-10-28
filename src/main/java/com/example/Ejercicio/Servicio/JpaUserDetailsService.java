package com.example.Ejercicio.Servicio;



import com.example.Ejercicio.Model.UserSecurity;
import com.example.Ejercicio.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository usuarioRepository;

    // Busca si el usuario está registrado
    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        return usuarioRepository
                .findByNombre(nombre)
                .map(UserSecurity::new)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + nombre));
    }
}