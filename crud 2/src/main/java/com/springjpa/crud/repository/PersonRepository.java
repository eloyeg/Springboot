package com.springjpa.crud.repository;

import com.springjpa.crud.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Employe,Integer> {}
