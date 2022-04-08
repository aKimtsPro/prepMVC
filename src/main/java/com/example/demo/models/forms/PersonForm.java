package com.example.demo.models.forms;

import com.example.demo.models.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class PersonForm {

    @NotBlank
    @Size(min = 2, max = 50)
    private String prenom;
    @NotBlank
    @Size(min = 2, max = 50)
    private String nom;

    public Person toEntity(){
        return new Person(null, prenom, nom);
    }

}
