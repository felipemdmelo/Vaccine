package com.felipemdmelo.vaccine.models;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MinhaVacina {

    @Id
    private Long id;

    private String numeroCarteira;

    private long vacinaId;
    @ToOne(joinProperty = "vacinaId")
    private Vacina vacina;

    private String dataVacinacao;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1435726991)
    private transient MinhaVacinaDao myDao;

    @Generated(hash = 2136742735)
    private transient Long vacina__resolvedKey;

    public MinhaVacina(String numeroCarteira, long vacinaId, String dataVacinacao) {
        this.setNumeroCarteira(numeroCarteira);
        this.setVacinaId(vacinaId);
        this.setDataVacinacao(dataVacinacao);
    }

    @Generated(hash = 612072974)
    public MinhaVacina(Long id, String numeroCarteira, long vacinaId, String dataVacinacao) {
        this.id = id;
        this.numeroCarteira = numeroCarteira;
        this.vacinaId = vacinaId;
        this.dataVacinacao = dataVacinacao;
    }

    @Generated(hash = 1812662036)
    public MinhaVacina() {
    }

    @Override
    public String toString() {
        String dataVacinacaoStr = "Pendente";
        if(this.getDataVacinacao() != null) {
            dataVacinacaoStr = this.getDataVacinacao();
        }
        return this.getVacina().getNome() + " (" + this.getVacina().getDose() + ") / " + dataVacinacaoStr;
    }

    public static List<MinhaVacina> seed(String numeroCarteira, List<Vacina> vacinaLista) {
        List<MinhaVacina> minhaVacinaLista = new ArrayList<>();

        for (Vacina vacina :
                vacinaLista) {
            MinhaVacina minhaVacina = new MinhaVacina(numeroCarteira, vacina.getId(), null);
            minhaVacinaLista.add(minhaVacina);
        }

        return minhaVacinaLista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCarteira() {
        return numeroCarteira;
    }

    public void setNumeroCarteira(String numeroCarteira) {
        this.numeroCarteira = numeroCarteira;
    }

    public long getVacinaId() {
        return vacinaId;
    }

    public void setVacinaId(long vacinaId) {
        this.vacinaId = vacinaId;
    }

    public String getDataVacinacao() {
        return dataVacinacao;
    }

    public void setDataVacinacao(String dataVacinacao) {
        this.dataVacinacao = dataVacinacao;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 274295916)
    public Vacina getVacina() {
        long __key = this.vacinaId;
        if (vacina__resolvedKey == null || !vacina__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            VacinaDao targetDao = daoSession.getVacinaDao();
            Vacina vacinaNew = targetDao.load(__key);
            synchronized (this) {
                vacina = vacinaNew;
                vacina__resolvedKey = __key;
            }
        }
        return vacina;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1449555058)
    public void setVacina(@NotNull Vacina vacina) {
        if (vacina == null) {
            throw new DaoException(
                    "To-one property 'vacinaId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.vacina = vacina;
            vacinaId = vacina.getId();
            vacina__resolvedKey = vacinaId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 556491348)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMinhaVacinaDao() : null;
    }
}
