package com.felipemdmelo.vaccine.repositories;

import com.felipemdmelo.vaccine.models.Usuario;

import java.sql.Date;

public class UsuarioRepository {

    public Usuario validaLogin(String login, String senha) {
        Date dataNascimento = Date.valueOf("1988-10-21");
        return new Usuario("123321123321", "Felipe Melo", dataNascimento);
    }

    public String adiciona(Usuario usuario) {
        return "Usuário adicionado com sucesso!";
    }
}
