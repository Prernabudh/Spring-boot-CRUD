package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    Person insertPerson(UUID id, Person person);

    default Person insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> getPersons();

    Optional<Person> selectPersonById(UUID id);
    int deletePerson(UUID id);

    int updatePerson(UUID id, Person person);
}
