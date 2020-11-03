package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("Dao")
public class PersonDataAccessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public Person insertPerson(UUID id, Person person) {
        person.setId(id);
        DB.add(person);
        return person;
    }

    @Override
    public List<Person> getPersons(){
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePerson(UUID id) {
        DB.removeIf(person -> person.getId().equals(id));
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        return selectPersonById(id).map(person1 -> {
            person1.setName(person.getName());
            person1.setEmail(person.getEmail());
            return 1;
        }).orElse(0);
    }
}
