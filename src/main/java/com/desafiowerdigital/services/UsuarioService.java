package com.desafiowerdigital.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiowerdigital.models.Usuario;
import com.desafiowerdigital.repository.UsuarioRepository;
import com.desafiowerdigital.utils.CriptografarSenha;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final CriptografarSenha criptografarSenha = new CriptografarSenha();


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
            String senha = criptografarSenha.criptografar(usuario.getSenha());
            usuario.setSenha(senha);
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
                    String senha = criptografarSenha.criptografar(usuario.getSenha());
                    usr.setSenha(senha);
                    System.out.println(senha);
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
