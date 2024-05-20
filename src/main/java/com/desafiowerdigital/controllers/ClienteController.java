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

import com.desafiowerdigital.models.Cliente;
import com.desafiowerdigital.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("") 
    public ResponseEntity<Object> obterCliente() {
        return new ResponseEntity<>(clienteService.obterCliente(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> obterCliente(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.obterCliente(id);
        if(cliente != null) return new ResponseEntity<>(cliente, HttpStatus.OK);

        return new ResponseEntity<>("Nenhum cliente foi encontrado", HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<Object> criarCliente(@RequestBody @Valid Cliente cliente) {
        return new ResponseEntity<>(clienteService.criarCliente(cliente), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> atualizarCliente(@PathVariable("id") Long id, @RequestBody @Valid Cliente cliente) {
        Cliente clienteAtualizado = clienteService.atualizarCliente(id, cliente);
        if(clienteAtualizado != null) return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);

        return new ResponseEntity<>("Nenhum cliente foi encontrado", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletarCliente(@PathVariable("id") Long id) {
        boolean foiDeletado = clienteService.deletarCliente(id);
        if(foiDeletado) return new ResponseEntity<>("Removido com sucesso", HttpStatus.OK);

        return new ResponseEntity<>("Nenhum cliente foi encontrado", HttpStatus.OK);
    }


}