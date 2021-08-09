package com.zupacademy.italo.casadocodigo.novolivro;


import com.zupacademy.italo.casadocodigo.cadastroautor.Autor;
import com.zupacademy.italo.casadocodigo.novacategoria.Categoria;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Livro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false)
    private String sumario;

    @Column(nullable = false)
    private String resumo;

    @Column(nullable = false)
    private Float preco;

    @Column(nullable = false)
    private Integer numeroPaginas;

    @Column(nullable = false, unique = true)
    private String isbn;

    private LocalDateTime publicacao;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(String titulo, String sumario, String resumo, Float preco, Integer numeroPaginas, String isbn, LocalDateTime publicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.sumario = sumario;
        this.resumo = resumo;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.publicacao = publicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", resumo='" + resumo + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", publicacao=" + publicacao +
                '}';
    }
}
