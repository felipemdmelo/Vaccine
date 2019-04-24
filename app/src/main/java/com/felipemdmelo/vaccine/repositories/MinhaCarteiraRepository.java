package com.felipemdmelo.vaccine.repositories;

import com.felipemdmelo.vaccine.models.MinhaVacina;
import com.felipemdmelo.vaccine.models.Vacina;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class MinhaCarteiraRepository {

    private final VacinaRepository vacinaRepository;

    public MinhaCarteiraRepository() {
        this.vacinaRepository = new VacinaRepository();
    }

    public List<MinhaVacina> getMinhaCarteira() {
        List<MinhaVacina> rtn = new LinkedList<>();

        List<MinhaVacina> minhasVacinas = getMinhasVacinas();
        List<Vacina> vacinas = vacinaRepository.getAll();
        for (Vacina vacina :
                vacinas) {

            boolean encontrouMinhaVacina = false;
            for (MinhaVacina minhaVacina :
                    minhasVacinas) {
                if(vacina.getId() == minhaVacina.getVacina().getId()) {
                    rtn.add(minhaVacina);
                    encontrouMinhaVacina = true;
                    break;
                }
            }

            if(!encontrouMinhaVacina) {
                rtn.add(new MinhaVacina(vacina, null));
            }
        }

        return rtn;
    }

    public List<MinhaVacina> getMinhasVacinas() {
        List<MinhaVacina> rtn = new LinkedList<>();

        Vacina vacina1 = vacinaRepository.getById(5);
        Date dataVacinacao1 = Date.valueOf("2019-01-21");
        MinhaVacina minhaVacina1 = new MinhaVacina(vacina1, dataVacinacao1);
        rtn.add(minhaVacina1);

        Vacina vacina2 = vacinaRepository.getById(7);
        Date dataVacinacao2 = Date.valueOf("2019-03-14");
        MinhaVacina minhaVacina2 = new MinhaVacina(vacina2, dataVacinacao2);
        rtn.add(minhaVacina2);

        return rtn;
    }

}
