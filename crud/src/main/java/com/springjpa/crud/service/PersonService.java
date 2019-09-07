package com.springjpa.crud.service;

import com.springjpa.crud.entity.Person;

import java.util.List;

public interface PersonService {
   List<Person> listAll();
   Person personByid(Integer id);
   boolean personSave(List<Person> person);
   boolean personDelete(Integer id);
}
