package com.example.entrevueSpringBoot.service;

import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.model.Film;
import com.example.entrevueSpringBoot.repository.ActeurRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActeurServiceImpl implements ActeurService{
    private final ActeurRepository acteurRepository;

    public ActeurServiceImpl(ActeurRepository acteurRepository) {
        this.acteurRepository = acteurRepository;
    }

    public List<Acteur> creerActeurs(List<Acteur> acteurs, Film film){
        List<Acteur> acteursDuFilm = acteurs.stream().peek(acteur -> acteur.setFilm(film)).collect(Collectors.toList());
        return (List<Acteur>) acteurRepository.saveAll(acteursDuFilm);
    }

    public List<Acteur> retrouverActeursDuFilm(Film film){
        return acteurRepository.findByFilm(film);
    }
}
