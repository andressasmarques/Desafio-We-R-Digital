package com.desafiowerdigital.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


public class Login {


    @NotEmpty(message="campo email é obrigatório")
    @Email(message = "e-mail inválido")
    private String email;

    @NotEmpty(message="campo senha é obrigatório")
    private String senha;


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
