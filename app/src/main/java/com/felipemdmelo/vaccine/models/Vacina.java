package com.felipemdmelo.vaccine.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Vacina {

    @Id
    private Long id;
    private String nome;
    private String dose;
    private String doencasEvitadas;
    private int idade;

    public Vacina(String nome, VacinaDose dose, String doencasEvitadas, int idade) {
        this.setNome(nome);
        this.setDose(dose.getNome());
        this.setDoencasEvitadas(doencasEvitadas);
        this.setIdade(idade);
    }

    @Generated(hash = 925378820)
    public Vacina(Long id, String nome, String dose, String doencasEvitadas, int idade) {
        this.id = id;
        this.nome = nome;
        this.dose = dose;
        this.doencasEvitadas = doencasEvitadas;
        this.idade = idade;
    }

    @Generated(hash = 503219029)
    public Vacina() {
    }

    public static List<Vacina> seed() {
        Vacina vacina1 = new Vacina("BCG-ID", VacinaDose.UNICA, "Formas graves de tuberculose", 0);
        Vacina vacina2 = new Vacina("Vacina contra hepatite B1", VacinaDose.PRIMEIRA, "Hepatite B", 0);
        Vacina vacina3 = new Vacina("Vacina contra hepatite B", VacinaDose.SEGUNDA, "Hepatite B", 1);
        Vacina vacina4 = new Vacina("VORH (vacina oral de rotavírus humano)2", VacinaDose.PRIMEIRA, "Diarréia por rotavírus", 2);
        Vacina vacina5 = new Vacina("VOP (vacina oral contra pólio)", VacinaDose.PRIMEIRA, "Poliomielite (paralisia infantil)\n", 2);
        Vacina vacina6 = new Vacina("Vacina tetravalente (DTP + Hib)3", VacinaDose.PRIMEIRA, "Difteria, tétano, coqueluche, meningite e outras infecções causadas pelo Haemophilus infl uenza tipo b", 2);
        Vacina vacina7 = new Vacina("VORH (vacina oral de rotavírus humano)4", VacinaDose.SEGUNDA, "Diarréia por rotavírus", 4);
        Vacina vacina8 = new Vacina("VOP (vacina oral contra pólio)", VacinaDose.SEGUNDA, "Poliomielite (paralisia infantil)", 4);
        Vacina vacina9 = new Vacina("Vacina tetravalente (DTP + Hib)", VacinaDose.SEGUNDA, "Difteria, tétano, coqueluche, meningite e outras infecções causadas pelo Haemophilus infl uenzae tipo b", 4);
        Vacina vacina10 = new Vacina("VOP (vacina oral contra pólio)", VacinaDose.TERCEIRA, "Poliomielite (paralisia infantil)", 6);
        Vacina vacina11 = new Vacina("Vacina tetravalente (DTP + Hib)", VacinaDose.TERCEIRA, "Difteria, tétano, coqueluche, meningite e outras infecções causadas pelo Haemophilus infl uenzae tipo b", 6);
        Vacina vacina12 = new Vacina("Vacina contra hepatite B", VacinaDose.TERCEIRA, "Hepatite B", 6);
        Vacina vacina13 = new Vacina("Vacina contra febre amarela5", VacinaDose.INICIAL, "Febre amarela", 9);
        Vacina vacina14 = new Vacina("SRC (tríplice viral)", VacinaDose.PRIMEIRA, "Sarampo, rubéola e caxumba", 12);
        Vacina vacina15 = new Vacina("VOP (vacina oral contra pólio)", VacinaDose.REFORCO, "Poliomielite (paralisia infantil)", 15);
        Vacina vacina16 = new Vacina("DTP (tríplice bacteriana)", VacinaDose.PRIMEIRA_REFORCO, "Difteria, tétano e coqueluche", 15);
        Vacina vacina17 = new Vacina("DTP (tríplice bacteriana)", VacinaDose.SEGUNDA_REFORCO, "Difteria, tétano e coqueluche", 60);
        Vacina vacina18 = new Vacina("SRC (tríplice viral)", VacinaDose.REFORCO, "Sarampo, rubéola e caxumba", 60);
        Vacina vacina19 = new Vacina("Vacina contra febre amarela", VacinaDose.REFORCO, "Febre amarela", 120);

        List<Vacina> lista = new ArrayList<>();
        lista.add(vacina1);
        lista.add(vacina2);
        lista.add(vacina3);
        lista.add(vacina4);
        lista.add(vacina5);
        lista.add(vacina6);
        lista.add(vacina7);
        lista.add(vacina8);
        lista.add(vacina9);
        lista.add(vacina10);
        lista.add(vacina11);
        lista.add(vacina12);
        lista.add(vacina13);
        lista.add(vacina14);
        lista.add(vacina15);
        lista.add(vacina16);
        lista.add(vacina17);
        lista.add(vacina18);
        lista.add(vacina19);

        return lista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
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
