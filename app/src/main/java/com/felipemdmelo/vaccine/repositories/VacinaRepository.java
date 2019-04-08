package com.felipemdmelo.vaccine.repositories;

import com.felipemdmelo.vaccine.models.Vacina;
import com.felipemdmelo.vaccine.models.VacinaDose;

import java.util.ArrayList;
import java.util.List;

public class VacinaRepository {

    public List<Vacina> getAll() {
        Vacina vacina1 = new Vacina("BCG-ID", VacinaDose.UNICA, "Formas graves de tuberculose", 0);
        Vacina vacina2 = new Vacina("Vacina contra hepatite B1", VacinaDose.UNICA, "Formas graves de tuberculose", 0);
        Vacina vacina3 = new Vacina("Vacina contra hepatite B", VacinaDose.UNICA, "Formas graves de tuberculose", 0);
        Vacina vacina4 = new Vacina("VORH (vacina oral de rotavírus humano)2", VacinaDose.UNICA, "Formas graves de tuberculose", 0);

        List<Vacina> lista = new ArrayList<>();
        lista.add(vacina1);
        lista.add(vacina2);
        lista.add(vacina3);

        return lista;
    }
}
