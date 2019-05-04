package com.felipemdmelo.vaccine.models;

public class PostoSaudeEstoque {

    private Vacina vacina;
    private int qtd;

    public PostoSaudeEstoque(Vacina vacina, int qtd) {
        this.setVacina(vacina);
        this.setQtd(qtd);
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
