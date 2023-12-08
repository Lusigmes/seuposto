package br.posto.seuposto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.posto.seuposto.model.entity.Pessoa;
import br.posto.seuposto.model.entity.Proprietario;
import br.posto.seuposto.repository.PessoaRepository;
import br.posto.seuposto.repository.ProprietarioRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    
    //
    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @CrossOrigin
    @GetMapping(value = "/prop")
    public ResponseEntity<List<Proprietario>> findAllProp() {
        List<Proprietario> proprietarios = proprietarioRepository.findAllProprietarios();
        return ResponseEntity.ok(proprietarios);
    }
    //

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return ResponseEntity.ok(pessoas);
    }
    
    @CrossOrigin
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable(value = "id")Integer id ) {
        Pessoa pessoa = pessoaRepository.findPessoaById(id);
        return ResponseEntity.ok(pessoa);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Pessoa> deleteById(@PathVariable(value = "id") Integer id) {
        pessoaRepository.deleteById(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
        Pessoa savedPessoa = pessoaRepository.save(pessoa);
        return new ResponseEntity<>(savedPessoa, HttpStatus.CREATED);
    }
}
