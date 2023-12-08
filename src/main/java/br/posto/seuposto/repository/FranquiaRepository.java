package br.posto.seuposto.repository;

// import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.posto.seuposto.model.entity.Franquia;

// @Primary
@RepositoryRestResource(collectionResourceRel = "franquias", path = "franquias")
public interface FranquiaRepository extends JpaRepository<Franquia, Integer>{
    
}
