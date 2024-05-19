package com.desafiowerdigital.repository;

import org.springframework.data.repository.CrudRepository;

import com.desafiowerdigital.models.Usuario;

public interface  UsuarioRepository extends CrudRepository<Usuario, Long> {
    
}
