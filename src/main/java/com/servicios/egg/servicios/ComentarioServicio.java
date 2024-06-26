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
    public void crearcComentario( String comentario, boolean alta ) {

        Comentario newComentario = new Comentario();
        newComentario.setComentario(comentario);
        newComentario.setAlta(true);

        comentarioRepositorio.save(newComentario);

    }

    @Transactional(readOnly = true)
    public List<Comentario> listarComentario() {
        List<Comentario> comentarios = new ArrayList();
        comentarios = comentarioRepositorio.findAll();
        return comentarios;

    }

    @Transactional
    public void modificarComentario( Long id, String comentario ) { // Comentario que puede modificar el USER que recibe el trabajo

        Optional<Comentario> respuesta = comentarioRepositorio.findById(id);

        if ( respuesta.isPresent() ) {
            Comentario comment = respuesta.get();
            comment.setAlta(true);
            comment.setComentario(comentario);

            comentarioRepositorio.save(comment);
        }

    }

    @Transactional
    public void censurarComentario( Long id ) { // Comentario que solo puede censurar el ADMIN

        Optional<Comentario> respuesta = comentarioRepositorio.findById(id);

        if ( respuesta.isPresent() ) {
            Comentario comment = respuesta.get();
            comment.setAlta(false);

            comentarioRepositorio.save(comment);
        }

    }

}
