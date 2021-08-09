package com.zupacademy.italo.casadocodigo.novolivro;

import com.zupacademy.italo.casadocodigo.cadastroautor.AutorRepository;
import com.zupacademy.italo.casadocodigo.novacategoria.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private AutorRepository autorRepository;
    private CategoriaRepository categoriaRepository;
    private LivroRepository livroRepository;

    public LivroController(AutorRepository autorRepository, CategoriaRepository categoriaRepository, LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarLivro(@RequestBody @Valid NovoLivroRequest request) {
        Livro livro = request.toModel(categoriaRepository, autorRepository);
        livroRepository.save(livro);

        return ResponseEntity.ok(livro.toString());
    }
}
