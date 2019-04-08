package com.felipemdmelo.vaccine.repositories;

import com.felipemdmelo.vaccine.models.PostoSaude;

import java.util.ArrayList;
import java.util.List;

public class PostoSaudeRepository {

    public List<PostoSaude> getAll() {
        PostoSaude postoSaude1 = new PostoSaude("Posto 1", "-15.823986", "-48.067256");
        PostoSaude postoSaude2 = new PostoSaude("Posto 2", "-15.823037", "-48.067622");
        PostoSaude postoSaude3 = new PostoSaude("Posto 3", "-15.823243", "-48.065954");

        List<PostoSaude> lista = new ArrayList<>();
        lista.add(postoSaude1);
        lista.add(postoSaude2);
        lista.add(postoSaude3);

        return lista;
    }

}
