package com.felipemdmelo.vaccine.models;

public class Usuario {

    private String numeroCarteira;
    private String nome;
    private String dataNascimento;

    public Usuario(String numeroCarteira, String nome, String dataNascimento) {
        this.setNumeroCarteira(numeroCarteira);
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
