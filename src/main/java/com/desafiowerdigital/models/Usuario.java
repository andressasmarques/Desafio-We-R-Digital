package com.desafiowerdigital.models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotEmpty(message="campo nome é obrigatório")
    @Size(max = 50, message = "nome inválido: deve der máximo de 50 caracteres")
    private String nome;

    @NotEmpty(message="campo email é obrigatório")
    @Email(message = "e-mail inválido")
    private String email;

    @NotEmpty(message="campo senha é obrigatório")
    @Size(min = 8, max = 80, message = "senha deve ter mínimo de 8 caracteres ")
    private String senha;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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
