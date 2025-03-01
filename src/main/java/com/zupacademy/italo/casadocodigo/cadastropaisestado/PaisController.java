package com.zupacademy.italo.casadocodigo.cadastropaisestado;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {
    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarPais(@RequestBody @Valid PaisRequest request) {
        Pais pais = request.toModel();

        paisRepository.save(pais);

        return ResponseEntity.ok(pais.toString());
    }
}
