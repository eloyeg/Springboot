package com.springjpa.crud.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nickname", nullable = true)
    private String nickName;

    @Column(name = "age", nullable = false)
    private Integer age;

    @OneToMany
    @JoinTable(name="employe_rol"
            ,joinColumns = @JoinColumn(name="employe_id")
            ,inverseJoinColumns = @JoinColumn(name="rol_id")
    )
    private Set<Rol> roles;

    @JoinColumn(name="config_id",unique = true,updatable = true)
    @OneToOne(cascade = CascadeType.ALL)
    private Config config;
}
