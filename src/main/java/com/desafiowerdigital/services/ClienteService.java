package com.desafiowerdigital.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiowerdigital.models.Cliente;
import com.desafiowerdigital.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ArrayList<Cliente> obterCliente() {
        try {
            return (ArrayList<Cliente>) clienteRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cliente obterCliente(Long id) {
        try {
            return clienteRepository.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cliente criarCliente(Cliente cliente) {
        try {
            return clienteRepository.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

   public Cliente atualizarCliente(Long id, Cliente cliente) {
      try {
            cliente.setId(id);
            boolean clienteExiste = clienteRepository.existsById(cliente.getId());
            if(clienteExiste) {
                return clienteRepository.save(cliente);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean  deletarCliente(Long id) {
      try {
            boolean clienteExiste = clienteRepository.existsById(id);
            if(clienteExiste) {
                clienteRepository.deleteById(id);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
