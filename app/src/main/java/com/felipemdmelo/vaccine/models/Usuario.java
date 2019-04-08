package com.felipemdmelo.vaccine.models;

import java.sql.Date;

public class Usuario {

    private String numeroCarteira;
    private String nome;
    private Date dataNascimento;

    public Usuario(String numeroCarteira, String nome, Date dataNascimento) {
        this.numeroCarteira = numeroCarteira;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNumeroCarteira() {
        return numeroCarteira;
    }

    public void setNumeroCarteira(String numeroCarteira) {
        this.numeroCarteira = numeroCarteira;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
