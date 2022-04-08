package com.example.demo.utils;

import com.example.demo.models.entities.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFiller implements InitializingBean {

    private final PersonRepository repository;

    public DatabaseFiller(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        repository.save(new Person(null, "Konnie", "Madsen"));
        repository.save(new Person(null, "Alex", "Allister"));
        repository.save(new Person(null, "René", "Rouard"));
        repository.save(new Person(null, "Louise", "Xavier"));

    }
}
