package com.example.entrevueSpringBoot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Acteur {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private String prenom;

    @Getter
    @Setter
    @ManyToOne
    private Film film;

}
