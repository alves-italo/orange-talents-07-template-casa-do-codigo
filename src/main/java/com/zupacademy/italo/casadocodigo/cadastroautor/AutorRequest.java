package com.zupacademy.italo.casadocodigo.cadastroautor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class AutorRequest {
    @NotBlank
    private final String nome;

    @NotBlank
    @Email
    private final String email;

    @NotBlank
    @Max(400)
    private final String descricao;

    public AutorRequest(@NotBlank  String nome, @NotBlank  String email, @NotBlank @Max(400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converter() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
