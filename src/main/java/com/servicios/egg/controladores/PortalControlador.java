package com.servicios.egg.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    UsuarioServicio usuarioServicio;
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Harian falta los registrar/registrar, login, inicio con los roles
    // pero para despues.
}
