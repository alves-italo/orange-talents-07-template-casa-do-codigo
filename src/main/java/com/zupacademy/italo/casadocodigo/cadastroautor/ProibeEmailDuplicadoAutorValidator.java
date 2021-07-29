package com.zupacademy.italo.casadocodigo.cadastroautor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {
    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        AutorRequest request = (AutorRequest) o;

        if (autorRepository.findByEmail(request.getEmail()).isPresent()) {
            errors.rejectValue("Email", null, "Já existe um(a) autor(a) com o email informado. " + request.getEmail());
        }
    }
}
