package com.servicios.egg.entidades;

import com.servicios.egg.enums.Estado;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Trabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private double presupuesto;

    private boolean alta;

    private Estado estado;

    private int calificacion;

    private Comentario comentario;

    @ManyToOne
    private Usuario usuario;

    @OneToOne
    private Provedor provedor;

}
