package com.example.demo.models.dtos;

import com.example.demo.models.entities.Person;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDTO {

    private Long id;
    private String prenom;
    private String nom;

    public static PersonDTO of(Person entity){
        if(entity == null)
            return null;

        return PersonDTO.builder()
                .id(entity.getId())
                .prenom(entity.getPrenom())
                .nom(entity.getNom())
                .build();
    }

}
