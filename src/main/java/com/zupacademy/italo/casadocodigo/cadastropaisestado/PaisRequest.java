package com.zupacademy.italo.casadocodigo.cadastropaisestado;


import com.zupacademy.italo.casadocodigo.utilidades.ValorUnico;

import javax.validation.constraints.NotBlank;

public class PaisRequest {
    @NotBlank
    @ValorUnico(target = Pais.class, field = "nome")
    private String nome;

    @Deprecated
    public PaisRequest() {}

    public PaisRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }
}
