package com.desafiowerdigital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiowerdigital.models.Login;
import com.desafiowerdigital.services.LoginService;


@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("") 
    public ResponseEntity<Object> obterUsuarios(@RequestBody Login login) {
        boolean usuarioLogado = loginService.login(login.getEmail(), login.getSenha());
        if(usuarioLogado == true) {
            return new ResponseEntity<>(usuarioLogado, HttpStatus.OK);
        }
        return new ResponseEntity<>("Login inválido", HttpStatus.OK);
    }

}
