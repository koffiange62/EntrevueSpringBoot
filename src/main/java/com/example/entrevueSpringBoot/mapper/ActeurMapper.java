package com.example.entrevueSpringBoot.mapper;

import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.resource.ActeurResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActeurMapper {
    Acteur deActeurResourceAActeur(ActeurResource acteurResource);

    ActeurResource deActeurAActeurResource(Acteur acteur);
}
