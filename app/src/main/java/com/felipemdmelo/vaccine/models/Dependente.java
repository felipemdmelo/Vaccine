package com.felipemdmelo.vaccine.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

@Entity
public class Dependente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String numeroCarteira;
    private String numeroCarteiraPai;
    private String nome;
    private String dataNascimento;

    @Generated(hash = 616420212)
    public Dependente(Long id, String numeroCarteira, String numeroCarteiraPai,
            String nome, String dataNascimento) {
        this.id = id;
        this.numeroCarteira = numeroCarteira;
        this.numeroCarteiraPai = numeroCarteiraPai;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    @Generated(hash = 2004649988)
    public Dependente() {
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

    public String getNumeroCarteiraPai() {
        return numeroCarteiraPai;
    }

    public void setNumeroCarteiraPai(String numeroCarteiraPai) {
        this.numeroCarteiraPai = numeroCarteiraPai;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
