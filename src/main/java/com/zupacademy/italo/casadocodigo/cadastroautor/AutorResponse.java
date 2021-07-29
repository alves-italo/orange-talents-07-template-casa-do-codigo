package com.zupacademy.italo.casadocodigo.cadastroautor;

public class AutorResponse {
    private String nome;
    private String descricao;

    public AutorResponse(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
