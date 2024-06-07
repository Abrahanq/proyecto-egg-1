package com.servicios.egg.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.servicios.egg.entidades.Comentario;
import com.servicios.egg.repositorios.ComentarioRepositorio;



@Service
public class ComentarioServicio {

    @Autowired
    private ComentarioRepositorio comentarioRepositorio;

    
@Transactional
public void crearcomentario(String comentario, int calificacion, boolean alta) {
        
    Comentario comentario1 = new Comentario();
    comentario1.setComentario(comentario);
    comentario1.setCalificacion(calificacion);
    comentario1.setAlta(true);

    comentarioRepositorio.save(comentario1);
    
    
}
@Transactional(readOnly=true)
public List<Comentario> listarComentario(){
    List<Comentario> comentarios = new ArrayList();
    comentarios = comentarioRepositorio.findAll();
    return comentarios;
    
}
@Transactional
public void modificar(Long id){

    Optional<Comentario> respuesta = comentarioRepositorio.findById(id);

    if (respuesta.isPresent()) {
        Comentario comentario1 = respuesta.get();
        comentario1.setAlta(false);
        comentarioRepositorio.save(comentario1);
    }

}


}
