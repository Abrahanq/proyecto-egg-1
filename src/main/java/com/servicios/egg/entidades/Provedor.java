package com.servicios.egg.entidades;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Provedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean alta;

    @ManyToOne
    private Usuario usuario_id;

    @ManyToMany @JoinTable(name ="servicios_has_provedores",
    joinColumns = @JoinColumn(referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Servicio> Servicio;
}
