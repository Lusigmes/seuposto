package br.posto.seuposto.controller;

import java.util.List;

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

import br.posto.seuposto.model.entity.Posto;
import br.posto.seuposto.repository.PostoRepository;

@RestController
@RequestMapping("/postos")
public class PostoController {

    @Autowired
    private PostoRepository postoRepository;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Posto>> findAll() {
        List<Posto> proprietarios = postoRepository.findAllPostos();
        return ResponseEntity.ok(proprietarios);
    }
    
    @CrossOrigin
    @GetMapping(value = "/{id}")
    public ResponseEntity<Posto> findById(@PathVariable(value = "id")Integer id ) {
        Posto posto = postoRepository.findPostoById(id);
        return ResponseEntity.ok(posto);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Posto> deleteById(@PathVariable(value = "id") Integer id) {
        postoRepository.deleteById(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Posto> save(@RequestBody Posto posto) {
        Posto savedProprietario = postoRepository.save(posto);
        return new ResponseEntity<>(savedProprietario, HttpStatus.CREATED);
    }
}
