package com.ibm.treinamento.btp.exemplo.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Address {


    private String rua;

    private Integer numero;

    private String bairro;

    private String cep;

    private String cidade;

    private String estado;
}
