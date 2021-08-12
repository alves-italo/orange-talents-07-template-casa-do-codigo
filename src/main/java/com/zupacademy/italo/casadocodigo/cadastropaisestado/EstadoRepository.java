package com.zupacademy.italo.casadocodigo.cadastropaisestado;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    List<Estado> findByNomeAndPais(String nome, Pais pais);

    List<Estado> findByPais(Pais pais);
}
