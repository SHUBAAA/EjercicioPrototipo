package com.example.Ejercicio.Repository;


import com.example.Ejercicio.Model.Post;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioPost extends CrudRepository<Post,Long> {
}
