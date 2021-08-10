package com.zupacademy.italo.casadocodigo.cadastropaisestado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {
    @NotBlank
    private String nome;
    @NotNull
    private Long idPais;

    public EstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado toModel(PaisRepository paisRepository) {
        return new Estado(this.nome, paisRepository.findById(this.idPais).get());
    }

    public String getNome() {
        return this.nome;
    }

    public Long getIdPais() {
        return this.idPais;
    }
}
