package com.ibm.treinamento.btp.exemplo.service;

import com.ibm.treinamento.btp.exemplo.model.Pessoa;
import com.ibm.treinamento.btp.exemplo.persistence.ExemploPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExemploService {

    private static final String MESSAGE_PESSOA_NULL_EXEPTION = "A Pessoa está nula";
    private static final String MESSAGE_PESSOA_FIELD_NULL_OR_EMPTY = "A pessoa não tem nome ou sobrenome";
    private static final String ID_ERROR_MESAGE = "Id inválido";

    @Autowired
    private ExemploPersistence exemploPersistence;

    public Pessoa save(Pessoa pessoa){
        validadePessoa(pessoa);
        return exemploPersistence.save(pessoa);
    }

    private void validadePessoa(Pessoa pessoa){
        if (pessoa == null){
            throw new RuntimeException(MESSAGE_PESSOA_NULL_EXEPTION);
        }

        validadeNome(pessoa.getNome());

        if (pessoa.getSobrenome() == null || pessoa.getSobrenome().isEmpty()){
            throw new RuntimeException(MESSAGE_PESSOA_FIELD_NULL_OR_EMPTY);
        }
        //ToDo : Validar Endereço
    }

    private void validadeNome(String nome){
        if(nome == null || nome.isEmpty()){
            throw new RuntimeException(MESSAGE_PESSOA_FIELD_NULL_OR_EMPTY);
        }
    }

    public List<Pessoa> find(String nome, Boolean ordered) {
        validadeNome(nome);
        return exemploPersistence.find(nome,ordered);
    }

    public String delete(Long id) {
        if(id < 0){
            throw new RuntimeException(ID_ERROR_MESAGE);
        }
        return exemploPersistence.delete(id);
    }

    public List<Pessoa> findAll() {
        return exemploPersistence.findAll();
    }

    public List<Pessoa> findByCity(String cidade) {
        //ToDo : Validação
        return exemploPersistence.findByCity(cidade);
    }
}