package com.servicios.egg.entidades;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class Trabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String descripcion;

    private double presupuesto;

    private boolean alta;

    @ManyToOne
    private Usuario usuario_id;

    @OneToOne
    private Provedor provedor_id;

}
