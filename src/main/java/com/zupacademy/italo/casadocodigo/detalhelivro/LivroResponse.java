package com.zupacademy.italo.casadocodigo.detalhelivro;

import com.zupacademy.italo.casadocodigo.novolivro.Livro;

import java.time.format.DateTimeFormatter;

public class LivroResponse {
    private String titulo;
    private String resumo;
    private String sumario;
    private Float preco;
    private String publicacao;
    private String isbn;
    private int numeroPaginas;

    private AutorResponse autor;

    public LivroResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.publicacao = livro.getPublicacao()
                               .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.autor = new AutorResponse(livro.getAutor());
        this.isbn = livro.getIsbn();
        this.numeroPaginas = livro.getNumeroPaginas();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Float getPreco() {
        return preco;
    }

    public String getPublicacao() {
        return publicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public AutorResponse getAutor() {
        return autor;
    }
}
