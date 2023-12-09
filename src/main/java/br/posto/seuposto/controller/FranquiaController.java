package br.posto.seuposto.controller;

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
import java.util.List;
import br.posto.seuposto.model.entity.Franquia;
import br.posto.seuposto.repository.FranquiaRepository;

@RestController
@RequestMapping("/franquias")
public class FranquiaController {
    @Autowired
    private FranquiaRepository franquiaRepository;

        

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Franquia>> findAll() {
        List<Franquia> franquias = franquiaRepository.findAll();
        return ResponseEntity.ok(franquias);
    }
    
    @CrossOrigin
    @GetMapping(value = "/{id}")
    public ResponseEntity<Franquia> findById(@PathVariable(value = "id")Integer id ) {
        Franquia franquia = franquiaRepository.findFranquiaById(id);
        return ResponseEntity.ok(franquia);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Franquia> deleteById(@PathVariable(value = "id") Integer id) {
        franquiaRepository.deleteById(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Franquia> save(@RequestBody Franquia pessoa) {
        Franquia savedFranquia = franquiaRepository.save(pessoa);
        return new ResponseEntity<>(savedFranquia, HttpStatus.CREATED);
    }
}
