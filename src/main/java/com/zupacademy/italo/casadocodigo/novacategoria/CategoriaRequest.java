package com.zupacademy.italo.casadocodigo.novacategoria;

public class CategoriaRequest {
    private String nome;

    @Deprecated
    public CategoriaRequest() {
    }

    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    public Categoria converter() {
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
