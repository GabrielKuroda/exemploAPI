package com.ibm.treinamento.btp.exemplo.persistence;

import com.ibm.treinamento.btp.exemplo.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExemploRepository extends JpaRepository<PessoaEntity, Long> {
    Optional<PessoaEntity> findById(long id);
    Optional<List<PessoaEntity>> findByNome(String nome);
    Optional<List<PessoaEntity>> findByNomeOrderBySobrenomeDesc(String nome);
    Optional<List<PessoaEntity>> findByAddress_Cidade(String cidade);
}
