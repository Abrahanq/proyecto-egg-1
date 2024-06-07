package com.servicios.egg.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicios.egg.entidades.Provedor;

@Repository
public interface ProvedorRepositorio extends JpaRepository<Provedor,Long> {
    
}
