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

import br.posto.seuposto.model.entity.Socio;
import br.posto.seuposto.repository.SocioRepository;

@RestController
@RequestMapping("/socios")
public class SocioController {
    @Autowired
    private SocioRepository socioRepository;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Socio>> findAll() {
        List<Socio> socios = socioRepository.findAllSocios();
        return ResponseEntity.ok(socios);
    }
    
    @CrossOrigin
    @GetMapping(value = "/{id}")
    public ResponseEntity<Socio> findById(@PathVariable(value = "id")Integer id ) {
        Socio Socio = socioRepository.findSocioById(id);
        return ResponseEntity.ok(Socio);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Socio> deleteById(@PathVariable(value = "id") Integer id) {
        socioRepository.deleteById(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Socio> save(@RequestBody Socio socio) {
        Socio savedSocio = socioRepository.save(socio);
        return new ResponseEntity<>(savedSocio, HttpStatus.CREATED);
    }
}
