package com.desafiowerdigital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @GetMapping("")
    public String obterUsuario() {
        return "usuario";
    }
}
