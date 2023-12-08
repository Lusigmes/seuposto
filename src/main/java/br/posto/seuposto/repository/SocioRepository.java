package br.posto.seuposto.repository;

// import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.posto.seuposto.model.entity.Socio;

// @Primary
@RepositoryRestResource(collectionResourceRel = "socios", path = "socios")
public interface SocioRepository extends JpaRepository<Socio, Integer> {
    
}
