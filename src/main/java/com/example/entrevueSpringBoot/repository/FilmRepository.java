package com.example.entrevueSpringBoot.repository;

import com.example.entrevueSpringBoot.model.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FilmRepository extends CrudRepository<Film, Long> {
    Optional<Film> findById(Long id);
}
