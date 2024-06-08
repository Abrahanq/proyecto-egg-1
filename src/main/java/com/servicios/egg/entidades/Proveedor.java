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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Proveedor{
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
