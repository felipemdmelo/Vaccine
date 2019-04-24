package com.felipemdmelo.vaccine.models;

import com.felipemdmelo.vaccine.utils.Utils;

import java.sql.Date;

public class MinhaVacina {

    private Vacina vacina;
    private Date dataVacinacao;

    public MinhaVacina(Vacina vacina, Date dataVacinacao) {
        this.vacina = vacina;
        this.dataVacinacao = dataVacinacao;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public Date getDataVacinacao() {
        return dataVacinacao;
    }

    public void setDataVacinacao(Date dataVacinacao) {
        this.dataVacinacao = dataVacinacao;
    }

    @Override
    public String toString() {
        String dataVacinacaoStr = "Pendente";
        if(this.dataVacinacao != null) {
            dataVacinacaoStr = Utils.getDateStr(this.dataVacinacao);
        }
        return this.vacina.getNome() + " (" + this.vacina.getDose().getNome() + ") / " + dataVacinacaoStr;
    }
}
