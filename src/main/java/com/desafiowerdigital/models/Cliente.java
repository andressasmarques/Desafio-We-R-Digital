package com.desafiowerdigital.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotEmpty(message="campo nome é obrigatório")
    @Size(max = 50, message = "nome inválido: deve der máximo de 50 caracteres")
    private String nome;

    @NotEmpty(message="campo idade é obrigatório")
    @Email(message = "idade inválida")
    private String idade;

    @NotEmpty(message="campo cidade é obrigatório")
    @Size(min = 8, max = 80, message = "cidade deve ter mínimo de 3 caracteres ")
    private String cidade;


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

    public String getIdade() {
        return this.idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
}
