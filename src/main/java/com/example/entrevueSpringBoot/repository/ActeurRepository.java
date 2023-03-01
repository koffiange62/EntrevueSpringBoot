package com.example.entrevueSpringBoot.repository;

import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.model.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActeurRepository extends CrudRepository<Acteur, Long> {
    List<Acteur> findByFilm(Film film);
}
