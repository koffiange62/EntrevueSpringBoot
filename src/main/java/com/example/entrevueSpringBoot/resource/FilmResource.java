package com.example.entrevueSpringBoot.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class FilmResource {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String titre;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private List<ActeurResource> acteurs;
}
