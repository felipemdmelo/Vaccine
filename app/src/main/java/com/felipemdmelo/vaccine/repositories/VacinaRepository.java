package com.felipemdmelo.vaccine.repositories;

import com.felipemdmelo.vaccine.models.Vacina;
import com.felipemdmelo.vaccine.models.VacinaDose;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VacinaRepository {

    public List<Vacina> getAll() {
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

    public List<Vacina> getAllByIdade(int idade) {
        List<Vacina> rtn = new LinkedList<>();
        for (Vacina vacina :
                getAll()) {
            if(vacina.getIdade() == idade) {
                rtn.add(vacina);
            }
        }

        return rtn;
    }
}
