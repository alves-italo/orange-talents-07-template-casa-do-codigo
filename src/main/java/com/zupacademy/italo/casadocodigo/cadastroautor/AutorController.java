package com.zupacademy.italo.casadocodigo.cadastroautor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorRepository repo;

    @PostMapping
    public ResponseEntity<?> cadastrarAutor(@RequestBody @Valid AutorRequest autorRequest) {
        Autor autor = autorRequest.converter();
        repo.save(autor);

        return ResponseEntity.ok(autor.toString());
    }
}
