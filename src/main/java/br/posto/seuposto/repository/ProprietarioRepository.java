package br.posto.seuposto.repository;

import java.util.List;

// import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.posto.seuposto.model.entity.Proprietario;


// @Primary
@RepositoryRestResource(collectionResourceRel = "proprietarios", path = "proprietarios")
public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer> {

    @Query("select p from Proprietario p left join fetch p.pessoa left join fetch p.postos where p.id = :id")
    public Proprietario findProprietarioById(int id);
    
    @Query("select p from Proprietario p left join fetch p.pessoa left join fetch p.postos")
    public List<Proprietario> findAllProprietarios();
}