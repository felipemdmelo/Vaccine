package com.felipemdmelo.vaccine.models;

public enum VacinaDose {
    UNICA("Única"),
    PRIMEIRA("Primeira Dose"),
    SEGUNDA("Segunda Dose"),
    TERCEIRA("Terceira Dose"),
    INICIAL("Dose Inicial"),
    REFORCO("Reforço"),
    PRIMEIRA_REFORCO("Primeiro Reforço"),
    SEGUNDA_REFORCO("Segundo Reforço");

    VacinaDose(String nome) {
        this.nome = nome;
    }

    private final String nome;

    public String getNome() {
        return this.nome;
    }
}
