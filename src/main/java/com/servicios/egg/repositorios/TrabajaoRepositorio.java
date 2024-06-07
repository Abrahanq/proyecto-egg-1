package com.servicios.egg.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicios.egg.entidades.Trabajo;

@Repository
public interface TrabajaoRepositorio extends JpaRepository<Trabajo,Long>{
    
}
