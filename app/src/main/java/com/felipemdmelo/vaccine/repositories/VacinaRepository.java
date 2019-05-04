package com.felipemdmelo.vaccine.repositories;

import com.felipemdmelo.vaccine.application.App;
import com.felipemdmelo.vaccine.models.DaoSession;
import com.felipemdmelo.vaccine.models.Vacina;
import com.felipemdmelo.vaccine.models.VacinaDao;

import java.util.List;

public class VacinaRepository {

    private VacinaDao vacinaDao;

    public VacinaRepository(App app) {
        DaoSession daoSession = app.getDaoSession();
        vacinaDao = daoSession.getVacinaDao();
    }

    public void initTable() {
        List<Vacina> vacinaLista = getAll();

        if(vacinaLista == null || (vacinaLista != null && vacinaLista.size() == 0)) {
            vacinaLista = Vacina.seed();
            insert(vacinaLista);
        }
    }

    public List<Vacina> getAll() {
        return vacinaDao
                .queryBuilder()
                .list();
    }

    public Vacina getById(Long id) {
        return vacinaDao
                .queryBuilder()
                .where(VacinaDao.Properties.Id.eq(id))
                .unique();
    }

    public void insert(List<Vacina> vacinaLista) {
        for (Vacina vacina :
                vacinaLista) {
            vacinaDao.insert(vacina);
        }
    }

}
