package com.zupacademy.italo.casadocodigo.detalhelivro;

import com.zupacademy.italo.casadocodigo.cadastroautor.Autor;

public class AutorResponse {
    private String nome;
    private String descricao;

    public AutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
