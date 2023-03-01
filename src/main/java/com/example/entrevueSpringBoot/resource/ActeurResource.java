package com.example.entrevueSpringBoot.resource;

import lombok.Getter;
import lombok.Setter;

public class ActeurResource {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private String prenom;
}
