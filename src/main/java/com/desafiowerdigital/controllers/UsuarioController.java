package com.desafiowerdigital.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiowerdigital.models.Usuario;
import com.desafiowerdigital.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("") 
    public ResponseEntity<Object> obterUsuarios() {
        return new ResponseEntity<>(usuarioService.obterUsuarios(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> obterUsuario(@PathVariable("id") Long id) {
        Usuario usr = usuarioService.obterUsuario(id);
        if(usr != null) return new ResponseEntity<>(usr, HttpStatus.OK);

        return new ResponseEntity<>("Nenhum usuário foi encontrado", HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<Object> criarUsuario(@RequestBody @Valid Usuario usuario) {
        return new ResponseEntity<>(usuarioService.criarUsuario(usuario), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> atualizarUsuario(@PathVariable("id") Long id, @RequestBody @Valid Usuario usuario) {

        Usuario usr = usuarioService.atualizarUsuario(id, usuario);
        if(usr != null) return new ResponseEntity<>(usuarioService.atualizarUsuario(id, usuario), HttpStatus.OK);

        return new ResponseEntity<>("Nenhum usuário foi encontrado", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletearUsuario(@PathVariable("id") Long id) {
        boolean foiDeletado = usuarioService.deletarUsuario(id);
        if(foiDeletado) return new ResponseEntity<>(foiDeletado, HttpStatus.OK);

        return new ResponseEntity<>("Nenhum usuário foi encontrado", HttpStatus.OK);
    }


}
