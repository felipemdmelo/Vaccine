package com.felipemdmelo.vaccine.repositories;

import com.felipemdmelo.vaccine.models.PostoSaude;
import com.felipemdmelo.vaccine.models.PostoSaudeEstoque;
import com.felipemdmelo.vaccine.models.Vacina;
import com.felipemdmelo.vaccine.utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PostoSaudeRepository {

    private final VacinaRepository vacinaRepository;

    public PostoSaudeRepository() {
        this.vacinaRepository = new VacinaRepository();
    }

    public List<PostoSaude> getAll() {
        List<PostoSaudeEstoque> postoSaudeEstoque1 = getPostoSaudeEstoque();
        List<PostoSaudeEstoque> postoSaudeEstoque2 = getPostoSaudeEstoque();
        List<PostoSaudeEstoque> postoSaudeEstoque3 = getPostoSaudeEstoque();

        PostoSaude postoSaude1 = new PostoSaude("Posto 1", "-15.823986", "-48.067256", postoSaudeEstoque1);
        PostoSaude postoSaude2 = new PostoSaude("Posto 2", "-15.823037", "-48.067622", postoSaudeEstoque2);
        PostoSaude postoSaude3 = new PostoSaude("Posto 3", "-15.823243", "-48.065954", postoSaudeEstoque3);

        List<PostoSaude> lista = new ArrayList<>();
        lista.add(postoSaude1);
        lista.add(postoSaude2);
        lista.add(postoSaude3);

        return lista;
    }

    private List<PostoSaudeEstoque> getPostoSaudeEstoque() {
        List<PostoSaudeEstoque> rtn = new LinkedList<>();

        List<Vacina> vacinas = this.vacinaRepository.getAll();

        for (Vacina vacina :
                vacinas) {
            rtn.add(new PostoSaudeEstoque(vacina, Utils.getIntRandom()));
        }

        return rtn;
    }

}
