package com.ibm.treinamento.btp.exemplo.persistence;

import com.ibm.treinamento.btp.exemplo.entity.PessoaEntity;
import com.ibm.treinamento.btp.exemplo.model.Pessoa;
import com.ibm.treinamento.btp.exemplo.parse.PessoaParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ExemploPersistence {

    @Autowired
    private ExemploRepository exemploRepository;

    @Autowired
    private PessoaParser pessoaParser;

    public Pessoa save(Pessoa pessoa){
        PessoaEntity pessoaEntity = pessoaParser.parse(pessoa);
        exemploRepository.save(pessoaEntity);
        return pessoaParser.parse(pessoaEntity);
    }

    public List<Pessoa> find(String nome, Boolean ordered){
        //Operação Ternária
        Optional<List<PessoaEntity>> optionalPessoas =
                ordered ?
                    exemploRepository.findByNomeOrderBySobrenomeDesc(nome) :
                    exemploRepository.findByNome(nome);
        List<Pessoa> pessoas = new ArrayList<>();
        if(optionalPessoas.isPresent()){
            for (PessoaEntity p : optionalPessoas.get()){
                pessoas.add(pessoaParser.parse(p));
            }
            return pessoas;
        }
        return pessoas;
    }

    public String delete(Long id) {
        try{
            exemploRepository.deleteById(id);
        }catch (RuntimeException runtimeException){
            return "Falha";
        }
        return "Sucesso";
    }

    public List<Pessoa> findAll() {
        List<PessoaEntity> pessoaEntities = exemploRepository.findAll();
        List<Pessoa> pessoas = new ArrayList<>();
        for (PessoaEntity p : pessoaEntities) {
            Pessoa pessoa = pessoaParser.parse(p);
            pessoas.add(pessoa);
        }
        return pessoas;
    }

    public List<Pessoa> findByCity(String cidade) {
        Optional<List<PessoaEntity>> pessoaEntities = exemploRepository.findByAddress_Cidade(cidade);
        List<Pessoa> pessoas = new ArrayList<>();
        if (pessoaEntities.isPresent()){
            for (PessoaEntity p : pessoaEntities.get()) {
                Pessoa pessoa = pessoaParser.parse(p);
                pessoas.add(pessoa);
            }
        }
        return pessoas;
    }
}
