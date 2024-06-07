package com.servicios.egg.entidades;



import com.servicios.egg.enums.Rol;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.*;




@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Rol rol;

    private String password;

    private boolean alta;

}
