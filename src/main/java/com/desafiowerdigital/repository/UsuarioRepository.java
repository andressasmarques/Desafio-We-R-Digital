package com.desafiowerdigital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.desafiowerdigital.models.Usuario;

public interface  UsuarioRepository extends CrudRepository<Usuario, Long> {
    List<Usuario> findByEmail(String email);
}
