package com.example.entrevueSpringBoot.mapper;

import com.example.entrevueSpringBoot.model.Film;
import com.example.entrevueSpringBoot.resource.ActeurResource;
import com.example.entrevueSpringBoot.resource.FilmResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmMapper {
    Film DeFilmResourceAFilm(FilmResource filmResource);

    @Mapping(target = "id", source = "film.id")
    @Mapping(target = "titre", source = "film.titre")
    @Mapping(target = "description", source = "film.description")
    @Mapping(target = "acteurs", source = "acteurs")
    FilmResource DeFilmEtActeursAFilmResource(Film film, List<ActeurResource> acteurs);
}
