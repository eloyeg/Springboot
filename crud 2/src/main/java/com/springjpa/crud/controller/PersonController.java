package com.springjpa.crud.controller;

import com.springjpa.crud.entity.Employe;
import com.springjpa.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    /*public PersonController(PersonService personService) {
        this.personService = personService;
    }*/


    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employe>> getPeople() {
        return new ResponseEntity<List<Employe>> (personService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Employe> getPeople(@PathVariable Integer id) {
        return new ResponseEntity<Employe>(personService.personByid(id), HttpStatus.OK);
    }

    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Employe>> savePeople(@RequestBody List<Employe> employes, UriComponentsBuilder builder) {
        boolean flag = personService.personSave(employes);
        if (flag == false) {
            return new ResponseEntity<List<Employe>>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<List<Employe>>(personService.listAll(), HttpStatus.CREATED);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<List<Employe>> updatePeople(@PathVariable Integer id) {
        boolean flag = personService.personDelete(id);
        if (flag == false) {
            return new ResponseEntity<List<Employe>>(personService.listAll(),HttpStatus.CONFLICT);
        }
        return new ResponseEntity<List<Employe>>(personService.listAll(), HttpStatus.OK);
    }
}
