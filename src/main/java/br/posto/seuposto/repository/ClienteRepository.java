package br.posto.seuposto.repository;

import java.util.List;

// import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.posto.seuposto.model.entity.Cliente;

// @Primary
@RepositoryRestResource(collectionResourceRel = "clientes", path = "clientes")
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{


   @Query("select c from Cliente c join fetch c.pessoa")
    public List<Cliente> findAllClientes();
    
    @Query("select c from Cliente c join fetch c.pessoa where c.id = :id")
    public Cliente findClienteById(@Param("id")int id);

}
