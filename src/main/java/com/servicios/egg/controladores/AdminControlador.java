package com.servicios.egg.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.servicios.egg.entidades.Usuario;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

    private UsuarioServicio usuarioServicio;

    @GetMapping("/dashboard")
    public String panelAdministrativo() {
        return "index"; //Aca deberia ir un "inicio.html" o modificar el index
    }

    @GetMapping("/usuarios")
    public String listar(ModelMap modelo) {
        List<Usuario> usuarios = usuarioServicio.listarUsuarios(); 
        //En usuario servicio deberia ir el metodo listar
        modelo.addAttribute("usuarios", usuarios);
        return "index"; // aca deberia ir "usuario_list"
    }

    @GetMapping("/modificarRol/{id}")
    public String cambiarRolUsuario(@PathVariable Long id) {
        usuarioServicio.cambiarRol(id);
        return "redirect:/admin/usuarios";
    }
}
