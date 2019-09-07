package com.springjpa.crud.service;

import com.springjpa.crud.repository.PersonRepository;
import com.springjpa.crud.entity.Employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;


    @Override
    public List<Employe> listAll() {
        return repository.findAll();
    }

    @Override
    public Employe personByid(Integer id){
        try {
            return repository.findById(id).get();
        }catch (NoSuchElementException e){
            return null;
        }

    }

    @Override
    public boolean personSave(List<Employe> employes){

        if (employes == null) {
            return false;
        } else {
            repository.saveAll(employes);
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
