package com.zupacademy.italo.casadocodigo.novacategoria;

import com.zupacademy.italo.casadocodigo.cadastroautor.Autor;
import com.zupacademy.italo.casadocodigo.utilidades.ValorUnico;

public class CategoriaRequest {
    @ValorUnico(target = Categoria.class, field = "nome")
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
