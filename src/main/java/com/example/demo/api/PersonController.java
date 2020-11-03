package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/users")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person addPerson(@Valid @NotNull @RequestBody Person person){
        return personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @GetMapping(path="{id}")
    public Person selectPersonById(@PathVariable("id") UUID id){
        return personService.selectPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path="{id}")
    public int deletePerson(@PathVariable("id") UUID id){
        return personService.deletePerson(id);
    }

    @PatchMapping(path = "{id}")
    public int updatePerson(@PathVariable("id") UUID id,@Valid @NotNull @RequestBody Person person){
        return personService.updatePerson(id, person);
    }
}
