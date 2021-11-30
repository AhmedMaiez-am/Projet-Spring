package test.testing.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import test.testing.entity.Produit;



@Repository
public interface ProduitRepository  extends CrudRepository<Produit, Long> {

	@Query("SELECT  p.prixUnitaire FROM Produit p WHERE p.idProduit = :idP")
	float retrievePrixUnitaitreById(@Param("idP") Long id);

}
