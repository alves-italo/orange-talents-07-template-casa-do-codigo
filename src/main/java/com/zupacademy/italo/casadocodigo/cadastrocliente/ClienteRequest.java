package com.zupacademy.italo.casadocodigo.cadastrocliente;

import com.zupacademy.italo.casadocodigo.cadastropaisestado.Estado;
import com.zupacademy.italo.casadocodigo.cadastropaisestado.EstadoRepository;
import com.zupacademy.italo.casadocodigo.cadastropaisestado.Pais;
import com.zupacademy.italo.casadocodigo.cadastropaisestado.PaisRepository;
import com.zupacademy.italo.casadocodigo.utilidades.CPFouCNPJ;
import com.zupacademy.italo.casadocodigo.utilidades.ValorUnico;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {
    @Email
    @NotBlank
    @ValorUnico(target = Cliente.class, field = "email")
    private String email;
    @NotBlank
    private String nome;
    @CPFouCNPJ
    @ValorUnico(target = Cliente.class, field = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    private Long idPais;

    private Long idEstado;
    @NotBlank
    @Length(max = 11, min = 11)
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteRequest(String email, String nome, String documento, String endereco, String complemento, String cidade, Long idPais, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Pais pais = paisRepository.findById(this.idPais).get();

        Cliente cliente = new Cliente(this.email, this.nome, this.documento, this.endereco, this.complemento, this.cidade, pais, this.telefone, this.cep);

        if(this.idEstado != null) {
            Estado estado = estadoRepository.findById(this.idEstado).get();
            cliente.setEstado(estado);
        }

        return cliente;
    }
}
