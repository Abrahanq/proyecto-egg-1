package com.servicios.egg.entidades;

import org.hibernate.annotations.GenericGenerator;

import com.servicios.egg.enums.Rol;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private Rol rol;

    private String password;

    private boolean alta;
}
