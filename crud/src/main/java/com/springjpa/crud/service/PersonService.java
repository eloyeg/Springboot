package com.springjpa.crud.service;

import com.springjpa.crud.entity.Employe;

import java.util.List;

public interface PersonService {
   List<Employe> listAll();
   Employe personByid(Integer id);
   boolean personSave(List<Employe> employes);
   boolean personDelete(Integer id);
}
