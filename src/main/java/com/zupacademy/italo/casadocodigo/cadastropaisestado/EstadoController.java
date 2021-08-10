package com.zupacademy.italo.casadocodigo.cadastropaisestado;


import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    private PaisRepository paisRepository;
    private ProibeEstadoDuplicadoValidator proibeEstadoDuplicadoValidator;
    private EstadoRepository estadoRepository;

    public EstadoController(PaisRepository paisRepository, ProibeEstadoDuplicadoValidator proibeEstadoDuplicadoValidator, EstadoRepository estadoRepository) {
        this.paisRepository = paisRepository;
        this.proibeEstadoDuplicadoValidator = proibeEstadoDuplicadoValidator;
        this.estadoRepository = estadoRepository;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeEstadoDuplicadoValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarPais(@RequestBody @Valid EstadoRequest request) {
        Estado estado = request.toModel(paisRepository);
        estadoRepository.save(estado);

        return ResponseEntity.ok(estado.toString());
    }
}
