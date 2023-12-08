package br.posto.seuposto.repository;

// import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.posto.seuposto.model.entity.Pessoa;

// @Primary
@RepositoryRestResource(collectionResourceRel = "pessoas", path = "pessoas")
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    
    @Query("select p from Pessoa p where p.id = :id")
    public Pessoa findPessoaById(int id);

}
