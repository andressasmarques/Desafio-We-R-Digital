package com.desafiowerdigital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.desafiowerdigital.models.Usuario;
import com.desafiowerdigital.repository.UsuarioRepository;
import com.desafiowerdigital.utils.CriptografarSenha;


public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final CriptografarSenha criptografarSenha = new CriptografarSenha();

    public boolean login(String email, String senha) {
      List<Usuario> usuario = usuarioRepository.findByEmail(email);
      
      if(usuario != null && usuario.size() == 1) {

        Usuario usr = usuario.get(0);

        if(criptografarSenha.validar(usr.getSenha(), senha) == true) {
           return true;
        }
      }

      return false;
    }
}