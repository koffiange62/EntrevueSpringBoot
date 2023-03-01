package com.example.entrevueSpringBoot.service;

import com.example.entrevueSpringBoot.mapper.ActeurMapper;
import com.example.entrevueSpringBoot.mapper.FilmMapper;
import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.model.Film;
import com.example.entrevueSpringBoot.repository.FilmRepository;
import com.example.entrevueSpringBoot.resource.ActeurResource;
import com.example.entrevueSpringBoot.resource.FilmResource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FilmServiceImpl implements FilmService{

    private final ActeurService acteurService;
    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;
    private final ActeurMapper acteurMapper;

    @Override
    public FilmResource creerFilm(FilmResource filmResource) {
        Film film = filmMapper.DeFilmResourceAFilm(filmResource);
        Film nouveauFilm = filmRepository.save(film);

        List<Acteur> acteurs = filmResource.getActeurs().stream().map(acteurMapper::deActeurResourceAActeur).collect(Collectors.toList());
        List<Acteur> acteursDuFilm = acteurService.creerActeurs(acteurs, nouveauFilm);

        return filmMapper.DeFilmEtActeursAFilmResource(nouveauFilm, construireActeurResourcelist(acteursDuFilm));
    }

    private List<ActeurResource> construireActeurResourcelist(List<Acteur> acteursDuFilm){
        return acteursDuFilm.stream().map(acteurMapper::deActeurAActeurResource).collect(Collectors.toList());
    }



    @Override
    public FilmResource trouverFilmParId(Long id) {
        Optional<Film> filmOptional = filmRepository.findById(id);
        if (filmOptional.isPresent()){
            List<Acteur> acteurs = acteurService.retrouverActeursDuFilm(filmOptional.get());
            List<ActeurResource> acteurResourcesList = construireActeurResourcelist(acteurs);
            return filmMapper.DeFilmEtActeursAFilmResource(filmOptional.get(), acteurResourcesList);
        } else {
            String message = "Il n'y pas de film pour l'identifiant : "+id;
            throw new NoSuchElementException(message);
        }
    }
}
