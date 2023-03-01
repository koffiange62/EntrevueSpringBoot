package com.example.entrevueSpringBoot.controller;

import com.example.entrevueSpringBoot.resource.FilmResource;
import com.example.entrevueSpringBoot.service.FilmService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("film")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping
    public FilmResource creerFilm(@RequestBody FilmResource filmResource){
        return filmService.creerFilm(filmResource);
    }

    @GetMapping("{id}")
    public FilmResource trouverFilmParId(@PathVariable(name = "id")  Long id){
        return filmService.trouverFilmParId(id);
    }
}
