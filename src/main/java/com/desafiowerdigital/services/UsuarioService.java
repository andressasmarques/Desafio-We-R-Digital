package com.desafiowerdigital.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiowerdigital.models.Usuario;
import com.desafiowerdigital.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public ArrayList<Usuario> obterUsuarios() {
        try {
            return (ArrayList<Usuario>) usuarioRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario obterUsuario(Long id) {
        try {
            return usuarioRepository.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario criarUsuario(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario) {
      try {
            usuario.setId(id);
            Usuario usr = usuarioRepository.findById(usuario.getId()).get();
            if(usr != null) {
                if(usuario.getNome() != null) {
                    usr.setNome(usuario.getNome());
                } 

                if (usuario.getEmail() != null) {
                    usr.setEmail(usuario.getEmail());
                } 

                if (usuario.getSenha() != null) {
                    usr.setSenha(usuario.getSenha());
                } 

                return usuarioRepository.save(usr);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean  deletarUsuario(Long id) {
      try {
            boolean usuarioExiste = usuarioRepository.existsById(id);
            if(usuarioExiste) {
                usuarioRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
