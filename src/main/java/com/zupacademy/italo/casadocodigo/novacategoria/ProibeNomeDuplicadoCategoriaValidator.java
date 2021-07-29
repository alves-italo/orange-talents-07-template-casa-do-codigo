package com.zupacademy.italo.casadocodigo.novacategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {
    @Autowired
    private CategoriaRepository repo;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CategoriaRequest request = (CategoriaRequest) o;

        if (repo.findByNome(request.getNome()).isPresent()) {
            errors.rejectValue("Nome", null, "Já existe uma categoria(a) com o nome informado. " + request.getNome());
        }
    }
}
