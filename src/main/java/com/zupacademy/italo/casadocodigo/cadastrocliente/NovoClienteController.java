package com.zupacademy.italo.casadocodigo.cadastrocliente;


import com.zupacademy.italo.casadocodigo.cadastropaisestado.EstadoRepository;
import com.zupacademy.italo.casadocodigo.cadastropaisestado.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class NovoClienteController {
    private PaisRepository paisRepository;
    private EstadoRepository estadoRepository;
    private ClienteRepository clienteRepository;
    private ProibeEstadoNullPaisComEstadoValidator proibeEstadoNullPaisComEstadoValidator;

    public NovoClienteController(PaisRepository paisRepository, EstadoRepository estadoRepository, ClienteRepository clienteRepository, ProibeEstadoNullPaisComEstadoValidator proibeEstadoNullPaisComEstadoValidator) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
        this.clienteRepository = clienteRepository;
        this.proibeEstadoNullPaisComEstadoValidator = proibeEstadoNullPaisComEstadoValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeEstadoNullPaisComEstadoValidator);
    }


    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@RequestBody @Valid ClienteRequest request) {
        Cliente cliente = request.toModel(paisRepository, estadoRepository);

        clienteRepository.save(cliente);

        return ResponseEntity.ok(cliente.getId());
    }

}
