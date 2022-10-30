package com.example.Ejercicio;

import com.example.Ejercicio.Model.User;
import com.example.Ejercicio.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EjercicioApplication {
	public static void main(String[] args) {
		SpringApplication.run(EjercicioApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(UserRepository usuarios, PasswordEncoder encoder) {
		return args -> {


			usuarios.save(new User("a", encoder.encode("a"), "ADMIN","11.222.333-4","ottitohot@gmail.com"));

		};
	}

}
