package com.springjpa.crud.controller;

import com.springjpa.crud.entity.Person;
import com.springjpa.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    /*public PersonController(PersonService personService) {
        this.personService = personService;
    }*/


    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> getPeople() {
        return new ResponseEntity<List<Person>> (personService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Person> getPeople(@PathVariable Integer id) {
        return new ResponseEntity<Person>(personService.personByid(id), HttpStatus.OK);
    }

    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Person>> savePeople(@RequestBody List<Person> person, UriComponentsBuilder builder) {
        boolean flag = personService.personSave(person);
        if (flag == false) {
            return new ResponseEntity<List<Person>>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<List<Person>>(personService.listAll(), HttpStatus.CREATED);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<List<Person>> updatePeople(@PathVariable Integer id) {
        boolean flag = personService.personDelete(id);
        if (flag == false) {
            return new ResponseEntity<List<Person>>(personService.listAll(),HttpStatus.CONFLICT);
        }
        return new ResponseEntity<List<Person>>(personService.listAll(), HttpStatus.OK);
    }
}
