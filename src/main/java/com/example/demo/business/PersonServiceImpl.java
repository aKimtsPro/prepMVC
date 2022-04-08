package com.example.demo.business;

import com.example.demo.models.dtos.PersonDTO;
import com.example.demo.models.entities.Person;
import com.example.demo.models.forms.PersonForm;
import com.example.demo.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonDTO getOne(Long id) {
        return repository.findById(id)
                .map(PersonDTO::of)
                .orElseThrow();
    }

    @Override
    public List<PersonDTO> getAll() {
        return repository.findAll().stream()
                .map(PersonDTO::of)
                .toList();
    }

    @Override
    public PersonDTO insert(PersonForm form) {
        return PersonDTO.of( repository.save(form.toEntity()) );
    }

    @Override
    public PersonDTO update(Long id, PersonForm form) {
        Person person = repository.findById(id)
                .orElseThrow();

        person.setPrenom(form.getPrenom());
        person.setNom(form.getNom());

        person = repository.save(person);
        return PersonDTO.of( person );
    }
}
