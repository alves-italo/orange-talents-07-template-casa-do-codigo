package com.zupacademy.italo.casadocodigo.novacategoria;

import com.zupacademy.italo.casadocodigo.cadastroautor.ProibeEmailDuplicadoAutorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
    @Autowired
    private CategoriaRepository repo;

    @Autowired
    private ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoria;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeNomeDuplicadoCategoria);
    }


    @PostMapping
    public ResponseEntity<?> cadastrarCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.converter();
        repo.save(categoria);

        return ResponseEntity.ok(categoria.toString());
    }
}
