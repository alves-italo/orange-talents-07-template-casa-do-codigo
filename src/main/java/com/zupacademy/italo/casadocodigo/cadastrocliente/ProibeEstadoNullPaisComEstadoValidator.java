package com.zupacademy.italo.casadocodigo.cadastrocliente;

import com.zupacademy.italo.casadocodigo.cadastropaisestado.EstadoRepository;
import com.zupacademy.italo.casadocodigo.cadastropaisestado.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEstadoNullPaisComEstadoValidator implements Validator {
    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return ClienteRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        ClienteRequest request = (ClienteRequest) o;

        if (!estadoRepository.findByPais(paisRepository.findById(request.getIdPais()).get()).isEmpty() && request.getIdEstado() == null) {
            errors.rejectValue("idEstado", null, "Para o país informado o estado não pode ser nulo." + request.getIdEstado());
        }
    }
}