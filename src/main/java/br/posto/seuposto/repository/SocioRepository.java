package br.posto.seuposto.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import br.posto.seuposto.model.entity.Socio;

//consultas desnecessarias

@RepositoryRestResource(collectionResourceRel = "socios", path = "socios")
public interface SocioRepository extends JpaRepository<Socio, Integer> {

   @Query("select s from Socio s " + 
   "left join fetch s.franquias left join fetch s.pessoa " +
   "p left join fetch p.cliente left join fetch p.proprietario where s.id = :id")
    public Socio findSocioById(int id);
    
    /* @Query("select s from Socio s " + 
   "left join fetch s.franquias left join fetch s.pessoa p " +
   "left join fetch p.cliente left join fetch p.proprietario")
    public List<Socio> findAllSocios(); */
    @Query("select s from Socio s " + 
    "left join fetch s.pessoa p " +
    "left join fetch p.cliente c " +
    "left join fetch p.proprietario pr left join fetch pr.postos")
    public List<Socio> findAllSocios();
    
}
