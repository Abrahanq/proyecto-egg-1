package com.servicios.egg.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.servicios.egg.entidades.Comentario;
import com.servicios.egg.servicios.ComentarioServicio;


@Controller
@RequestMapping("/comentario")
public class ComentarioControlador {

    private ComentarioServicio comentarioServicio;

    @GetMapping("/registrar")
    public String registrar() {
        return "index"; // aca deberia ir "comentario_form"
    }

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {
        List<Comentario> comentarios = comentarioServicio.listarComentario();
        modelo.addAttribute("comentarios", comentarios);
        return "index"; // aca deberia ir "comentario_list"
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, ModelMap modelo) {
        
    }
}
