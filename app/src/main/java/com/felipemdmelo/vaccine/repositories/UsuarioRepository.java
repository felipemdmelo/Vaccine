package com.felipemdmelo.vaccine.repositories;

import com.felipemdmelo.vaccine.models.Usuario;

import java.sql.Date;

public class UsuarioRepository {

    public Usuario validaLogin(String login, String senha) {
        if(login.equals("fmdm") && senha.equals("2110")) {
            Date dataNascimento = Date.valueOf("1988-10-21");
            return new Usuario("111222333", "Felipe Melo", dataNascimento);
        }
        return null;
    }

    public String adiciona(Usuario usuario) {
        return "Usuário adicionado com sucesso!";
    }
}
