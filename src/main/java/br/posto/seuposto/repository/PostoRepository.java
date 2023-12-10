package br.posto.seuposto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.posto.seuposto.model.entity.Posto;

@RepositoryRestResource(collectionResourceRel = "postos", path = "postos")
public interface PostoRepository extends JpaRepository<Posto, Integer>{

     @Query("select p from Posto p left join fetch p.franquias_associadas f "+
     "left join fetch p.proprietario left join fetch f.socio where p.id = :id")
    public Posto findPostoById(int id);

    @Query("select p from Posto p left join fetch p.franquias_associadas f " + 
            "left join fetch p.proprietario po left join fetch f.socio so left join fetch so.pessoa")
    public List<Posto> findAllPostos();
}
