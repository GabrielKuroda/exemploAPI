package com.ibm.treinamento.btp.exemplo.parse;

import com.ibm.treinamento.btp.exemplo.entity.PessoaEntity;
import com.ibm.treinamento.btp.exemplo.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaParser {

    @Autowired
    private AddressParser addressParser;

    public PessoaEntity parse(Pessoa pessoa){
        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setNome(pessoa.getNome());
        pessoaEntity.setSobrenome(pessoa.getSobrenome());
        pessoaEntity.setAddress(addressParser.parse(pessoa.getAddress()));
        return pessoaEntity;
    }

    public Pessoa parse(PessoaEntity pessoaEntity){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaEntity.getId());
        pessoa.setNome(pessoaEntity.getNome());
        pessoa.setSobrenome(pessoaEntity.getSobrenome());
        pessoa.setAddress(addressParser.parse(pessoaEntity.getAddress()));
        return pessoa;
    }
}
