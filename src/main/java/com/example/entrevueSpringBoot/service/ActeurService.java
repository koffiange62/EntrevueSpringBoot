package com.example.entrevueSpringBoot.service;

import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.model.Film;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ActeurService {

    List<Acteur> creerActeurs(List<Acteur> acteurs, Film film);

    List<Acteur> retrouverActeursDuFilm(Film film);
}
