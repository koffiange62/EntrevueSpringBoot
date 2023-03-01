package com.example.entrevueSpringBoot.service;

import com.example.entrevueSpringBoot.resource.FilmResource;

public interface FilmService {
    FilmResource creerFilm(FilmResource filmResource);
    FilmResource trouverFilmParId(Long id);
}
