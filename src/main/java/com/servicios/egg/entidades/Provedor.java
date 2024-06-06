package com.servicios.egg.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Provedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean alta;

    @ManyToOne
    private Usuario usuario_id;

    @ManyToMany @JoinTable(name ="servicios_has_provedores", 
    joinColumns = @JoinColumn(referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Servicio> Servicio;
}
