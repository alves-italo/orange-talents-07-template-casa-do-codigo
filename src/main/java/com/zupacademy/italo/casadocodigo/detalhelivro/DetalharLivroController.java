package com.zupacademy.italo.casadocodigo.detalhelivro;


import com.zupacademy.italo.casadocodigo.novolivro.Livro;
import com.zupacademy.italo.casadocodigo.novolivro.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DetalharLivroController {
    @Autowired
    LivroRepository livroRepository;

    @GetMapping(value = "/livros/{id}")
    public LivroResponse detalharLivro(@PathVariable Long id) {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        LivroResponse livroResponse = new LivroResponse(livro);
        return livroResponse;
    }

}
