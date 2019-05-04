package com.felipemdmelo.vaccine.repositories;

import com.felipemdmelo.vaccine.models.Usuario;

public class UsuarioRepository {

    public Usuario validaLogin(String login, String senha) {
        if(login.equals("fmdm") && senha.equals("2110")) {
            return new Usuario("111222333", "Felipe Melo", "1988-10-21");
        }
        return null;
    }

    public String adiciona(Usuario usuario) {
        return "Usuário adicionado com sucesso!";
    }
}
