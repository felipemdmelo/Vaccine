package com.felipemdmelo.vaccine.repositories;

import com.felipemdmelo.vaccine.application.App;
import com.felipemdmelo.vaccine.models.DaoSession;
import com.felipemdmelo.vaccine.models.Dependente;
import com.felipemdmelo.vaccine.models.DependenteDao;

import java.util.List;

public class DependenteRepository {

    private DependenteDao dependenteDao;
    private MinhaVacinaRepository minhaVacinaRepository;

    public DependenteRepository(App app) {
        DaoSession daoSession = app.getDaoSession();
        dependenteDao = daoSession.getDependenteDao();
        minhaVacinaRepository = new MinhaVacinaRepository(app);
    }

    public List<Dependente> getAll(String numeroCarteira) {
        return dependenteDao
                .queryBuilder()
                .where(DependenteDao.Properties.NumeroCarteiraPai.eq(numeroCarteira))
                .list();
    }

    public String insert(Dependente dependente) {
        dependenteDao.insert(dependente);
        this.minhaVacinaRepository.initTable(dependente.getNumeroCarteira());

        return "Dependente adicionado com sucesso!";
    }
}
