package br.posto.seuposto.repository;

// import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;
import br.posto.seuposto.model.entity.Franquia;

// @Primary
@RepositoryRestResource(collectionResourceRel = "franquias", path = "franquias")
public interface FranquiaRepository extends JpaRepository<Franquia, Integer>{
    
    @Query("select f from Franquia f left join fetch f.posto")
    public List<Franquia> findAllFranquias();

    @Query("select f from Franquia f left join fetch f.posto where f.id = :id")
    public Franquia findFranquiaById(int id);
}
