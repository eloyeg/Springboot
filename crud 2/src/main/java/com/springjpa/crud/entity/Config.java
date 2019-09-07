package com.springjpa.crud.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private  String desc;
}
