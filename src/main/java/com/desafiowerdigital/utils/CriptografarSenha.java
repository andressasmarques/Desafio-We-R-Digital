package com.desafiowerdigital.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class CriptografarSenha {

    public String criptografar(String senha) {

        String salGerado = BCrypt.gensalt();

        String senhaHasheada = BCrypt.hashpw(senha, salGerado);

        return senhaHasheada;
    }

    public boolean validar(String senhaCifrada, String senha) {
        return BCrypt.checkpw(senha,senhaCifrada);
    }

}