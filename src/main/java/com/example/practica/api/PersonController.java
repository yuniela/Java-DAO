package com.example.practica.api;

import com.example.practica.model.Person;
import com.example.practica.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }
    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID id) {
         personService.deletePerson(id);
    }
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id,
                            @Valid @NonNull @RequestBody Person person) {
        personService.updatePerson(id, person);
    }
}
