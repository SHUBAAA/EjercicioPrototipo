package com.example.Ejercicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjercicioApplication {
	public static void main(String[] args) {
		SpringApplication.run(EjercicioApplication.class, args);
	}

<<<<<<< Updated upstream
=======

	@Bean
	CommandLineRunner commandLineRunner(UserRepository usuarios, PasswordEncoder encoder) {
		return args -> {


			usuarios.save(new User("a", encoder.encode("a"), "ADMIN","11.222.333-4","ottito@gmail.com"));

		};
	}

>>>>>>> Stashed changes
}
