package com.zupacademy.italo.casadocodigo.cadastroautor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorRepository repo;

    @PostMapping
    public ResponseEntity<?> cadastrarAutor(@RequestBody @Valid AutorRequest autorRequest) {
        if (repo.findByEmail(autorRequest.getEmail()).isPresent()) return ResponseEntity.badRequest().build();

        Autor autor = autorRequest.converter();
        repo.save(autor);

        return ResponseEntity.ok(autor);
    }
}
