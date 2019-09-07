package com.springjpa.crud.service;

import com.springjpa.crud.repository.PersonRepository;
import com.springjpa.crud.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;


    @Override
    public List<Person> listAll() {
        return repository.findAll();
    }

    @Override
    public Person personByid(Integer id){
        try {
            return repository.findById(id).get();
        }catch (NoSuchElementException e){
            return null;
        }

    }

    @Override
    public boolean personSave(List<Person> person){

        if (person == null) {
            return false;
        } else {
            repository.saveAll(person);
            return true;
        }
    }

    @Override
    public boolean personDelete(Integer id){

        if (id == null) {
            return false;
        } else {
           repository.deleteById(id);
            return true;
        }
    }

}
