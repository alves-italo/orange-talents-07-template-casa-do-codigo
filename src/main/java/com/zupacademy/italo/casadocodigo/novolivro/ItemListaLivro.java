package com.zupacademy.italo.casadocodigo.novolivro;

public class ItemListaLivro {
    private Long id;
    private String nome;

    public ItemListaLivro(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
