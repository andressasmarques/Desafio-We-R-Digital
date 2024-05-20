package com.desafiowerdigital.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.desafiowerdigital.models.Usuario;
import com.desafiowerdigital.models.dto.UsuarioDTO;
import com.desafiowerdigital.repository.UsuarioRepository;
import com.desafiowerdigital.utils.CriptografarSenha;

@Configuration
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final CriptografarSenha criptografarSenha = new CriptografarSenha();

    @Bean
    ModelMapper modelMapper() {
       return new ModelMapper();
    }


    public List<UsuarioDTO> obterUsuarios() {
        try {
            ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
            return usuarios.stream().map(usuario -> modelMapper().map(usuario, UsuarioDTO.class)).collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UsuarioDTO obterUsuario(Long id) {
        try {
            Usuario usuario = usuarioRepository.findById(id).get();
            return modelMapper().map(usuario, UsuarioDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UsuarioDTO criarUsuario(Usuario usuario) {
        try {
            String senha = criptografarSenha.criptografar(usuario.getSenha());
            usuario.setSenha(senha);
            Usuario usrSalvo = usuarioRepository.save(usuario);
            return modelMapper().map(usrSalvo, UsuarioDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UsuarioDTO atualizarUsuario(Long id, Usuario usuario) {
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
                } 

                Usuario usrSalvo = usuarioRepository.save(usr);
                return modelMapper().map(usrSalvo, UsuarioDTO.class);
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
