package com.felipemdmelo.vaccine.repositories;

import com.felipemdmelo.vaccine.application.App;
import com.felipemdmelo.vaccine.models.DaoSession;
import com.felipemdmelo.vaccine.models.MinhaVacina;
import com.felipemdmelo.vaccine.models.MinhaVacinaDao;

import java.util.List;

public class MinhaVacinaRepository {

    private MinhaVacinaDao minhaVacinaDao;
    private VacinaRepository vacinaRepository;

    public MinhaVacinaRepository(App app) {
        DaoSession daoSession = app.getDaoSession();
        minhaVacinaDao = daoSession.getMinhaVacinaDao();
        vacinaRepository = new VacinaRepository(app);
    }

    public void initTable(String numeroCarteira) {
        List<MinhaVacina> minhaVacinaLista = getAll(numeroCarteira);

        if(minhaVacinaLista == null || (minhaVacinaLista != null && minhaVacinaLista.size() == 0)) {
            minhaVacinaLista = MinhaVacina.seed(numeroCarteira, vacinaRepository.getAll());
            insert(minhaVacinaLista);
        }
    }

    public List<MinhaVacina> getAll(String numeroCarteira) {
        return minhaVacinaDao
                .queryBuilder()
                .where(MinhaVacinaDao.Properties.NumeroCarteira.eq(numeroCarteira))
                .list();
    }

    public void insert(List<MinhaVacina> minhaVacinaLista) {
        for (MinhaVacina minhaVacina :
                minhaVacinaLista) {
            minhaVacinaDao.insert(minhaVacina);
        }
    }

}
