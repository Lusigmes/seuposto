package br.posto.seuposto.repository;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.posto.seuposto.model.entity.Posto;

@Primary
@RepositoryRestResource(collectionResourceRel = "postos", path = "postos")
public interface PostoRepository extends JpaRepository<Posto, Integer>{

     @Query("select p from Posto p left join fetch p.franquias_associadas  where p.id = :id")
    public Posto findPostoById(int id);

    @Query("select p from Posto p left join fetch p.franquias_associadas ")
    public List<Posto> findAllPostos();
}
