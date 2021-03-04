package com.ibm.treinamento.btp.exemplo.controller;

import com.ibm.treinamento.btp.exemplo.model.Pessoa;
import com.ibm.treinamento.btp.exemplo.service.ExemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exemplo")
public class ExemploAPI {

    @Autowired
    private ExemploService exemploService;

    @GetMapping
    public String findQueryString(@RequestParam(required = false,name = "name") String nome,
                       @RequestParam(required = false,name = "surname") String sobrenome){
        if((nome == null || nome.isEmpty()) && (sobrenome == null || sobrenome.isEmpty())){
            return "Olá";
        }

        if(nome == null || nome.isEmpty()){
            return "Olá, " + sobrenome + "-san";
        }
        if(sobrenome == null || sobrenome.isEmpty()){
            return "Olá, " + nome;
        }
        return "Olá, " + nome + " " + sobrenome;
    }

    @PostMapping
    public Pessoa save(@RequestBody Pessoa pessoa){
        return exemploService.save(pessoa);
    }

    @GetMapping("/findAll")
    public List<Pessoa> findAll() {
        return exemploService.findAll();
    }

    @GetMapping("/find/nomes")
    public List<Pessoa> findByName(@RequestParam(name = "name") String nome,
                                   @RequestParam(required = false,name = "ordered") Boolean ordered){
        if(ordered == null || !ordered){
            return exemploService.find(nome, false);
        }
        return exemploService.find(nome, true);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id){
        return exemploService.delete(id);
    }

    @GetMapping("/find/cidades")
    public List<Pessoa> findPeopleByCity(@RequestParam(name = "cidade") String cidade){
        return exemploService.findByCity(cidade);
    }

}
