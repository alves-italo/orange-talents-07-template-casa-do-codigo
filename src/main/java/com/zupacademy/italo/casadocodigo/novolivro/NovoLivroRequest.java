package com.zupacademy.italo.casadocodigo.novolivro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zupacademy.italo.casadocodigo.cadastroautor.Autor;
import com.zupacademy.italo.casadocodigo.cadastroautor.AutorRepository;
import com.zupacademy.italo.casadocodigo.novacategoria.Categoria;
import com.zupacademy.italo.casadocodigo.novacategoria.CategoriaRepository;
import com.zupacademy.italo.casadocodigo.utilidades.ValorUnico;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class NovoLivroRequest {
    @NotBlank
    @ValorUnico(target = Livro.class, field = "titulo")
    private String titulo;

    @NotBlank
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private Float preco;

    @NotNull
    @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    @ValorUnico(target = Livro.class, field = "isbn")
    private String isbn;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    @Future
    private LocalDateTime publicacao;

    @NotNull
    private Long idCategoria;

    @NotNull
    private Long idAutor;

    public NovoLivroRequest(String titulo, String resumo, String sumario, Float preco, Integer numeroPaginas, String isbn, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public void setPublicacao(LocalDateTime publicacao) {
        this.publicacao = publicacao;
    }

    public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
        Autor autor = autorRepository.findById(this.idAutor).get();
        Categoria categoria = categoriaRepository.findById(this.idCategoria).get();

         return new Livro(this.titulo,
                          this.sumario,
                          this.resumo,
                          this.preco,
                          this.numeroPaginas,
                          this.isbn,
                          this.publicacao,
                          categoria,
                          autor);
    }
}
