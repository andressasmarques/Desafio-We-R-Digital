package com.desafiowerdigital.repository;

import org.springframework.data.repository.CrudRepository;

import com.desafiowerdigital.models.Cliente;
public interface  ClienteRepository extends CrudRepository<Cliente, Long> {

}
