package br.posto.seuposto.repository;

// import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.posto.seuposto.model.entity.Cliente;

// @Primary
@RepositoryRestResource(collectionResourceRel = "clientes", path = "clientes")
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
