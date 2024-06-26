package com.servicios.egg.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicios.egg.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
    
}
