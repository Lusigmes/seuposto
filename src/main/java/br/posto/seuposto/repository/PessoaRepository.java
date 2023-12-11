package br.posto.seuposto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.posto.seuposto.model.entity.Pessoa;

@RepositoryRestResource(collectionResourceRel = "pessoas", path = "pessoas")
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    
    @Query("select p from Pessoa p "+
    "left join fetch p.proprietario left join fetch p.socio left join fetch p.cliente where p.id = :id")
    public Pessoa findPessoaById(int id);

    @Query("select p from Pessoa p "+
    "left join fetch p.proprietario left join fetch p.socio left join fetch p.cliente")
    public List<Pessoa> findAllPessoas();

}
