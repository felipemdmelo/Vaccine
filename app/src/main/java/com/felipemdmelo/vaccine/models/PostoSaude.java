package com.felipemdmelo.vaccine.models;

import java.util.List;

public class PostoSaude {

    private String nome;
    private String latitude;
    private String longitude;
    private List<PostoSaudeEstoque> postoSaudeEstoque;

    public PostoSaude(String nome, String latitude, String longitude, List<PostoSaudeEstoque> postoSaudeEstoque) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postoSaudeEstoque = postoSaudeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<PostoSaudeEstoque> getPostoSaudeEstoque() {
        return postoSaudeEstoque;
    }

    public void setPostoSaudeEstoque(List<PostoSaudeEstoque> postoSaudeEstoque) {
        this.postoSaudeEstoque = postoSaudeEstoque;
    }
}
