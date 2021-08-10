package com.zupacademy.italo.casadocodigo.cadastropaisestado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEstadoDuplicadoValidator implements Validator {
    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return EstadoRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        EstadoRequest request = (EstadoRequest) o;
        if (!estadoRepository.findByNomeAndPais(request.getNome(), paisRepository.findById(request.getIdPais()).get()).isEmpty()) {
            errors.rejectValue("Nome", null, "Já existe um(a) estado(a) com o nome informado. " + request.getNome());
        }
    }
}