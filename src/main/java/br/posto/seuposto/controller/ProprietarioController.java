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

import br.posto.seuposto.model.entity.Proprietario;
import br.posto.seuposto.repository.ProprietarioRepository;


@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Proprietario>> findAll() {
        List<Proprietario> proprietarios = proprietarioRepository.findAllProprietarios();
        return ResponseEntity.ok(proprietarios);
    }
    
    @CrossOrigin
    @GetMapping(value = "/{id}")
    public ResponseEntity<Proprietario> findById(@PathVariable(value = "id")Integer id ) {
        Proprietario proprietario = proprietarioRepository.findProprietarioById(id);
        return ResponseEntity.ok(proprietario);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Proprietario> deleteById(@PathVariable(value = "id") Integer id) {
        proprietarioRepository.deleteById(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Proprietario> save(@RequestBody Proprietario proprietario) {
        Proprietario savedProprietario = proprietarioRepository.save(proprietario);
        return new ResponseEntity<>(savedProprietario, HttpStatus.CREATED);
    }
}
