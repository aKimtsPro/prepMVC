package com.example.demo.business;

import com.example.demo.models.dtos.PersonDTO;
import com.example.demo.models.forms.PersonForm;

import java.util.List;

public interface PersonService {

    PersonDTO getOne(Long id);
    List<PersonDTO> getAll();

    PersonDTO insert(PersonForm form);

    PersonDTO update(Long id, PersonForm form);

}
