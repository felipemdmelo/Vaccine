package com.felipemdmelo.vaccine.models;

public class Vacina {

    private String nome;
    private VacinaDose dose;
    private String doencasEvitadas;
    private int idade;

    public Vacina(String nome, VacinaDose dose, String doencasEvitadas, int idade) {
        this.nome = nome;
        this.dose = dose;
        this.doencasEvitadas = doencasEvitadas;
        this.idade = idade;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public VacinaDose getDose() {
        return dose;
    }

    public void setDose(VacinaDose dose) {
        this.dose = dose;
    }

    public String getDoencasEvitadas() {
        return doencasEvitadas;
    }

    public void setDoencasEvitadas(String doencasEvitadas) {
        this.doencasEvitadas = doencasEvitadas;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
