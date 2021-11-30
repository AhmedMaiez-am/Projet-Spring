package test.testing.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import test.testing.entity.Facture;
import test.testing.enume.CategorieClient;




@Repository
public interface FactureRepository extends CrudRepository<Facture, Long> {

	@Query("SELECT f.montantFacture FROM Facture f")
	List<Float> retrieveCA();
	
	@Query("SELECT f FROM Facture f WHERE f.client.idClient = :idClient")
	List<Facture> getFactureByClient(@Param("idClient") Long idClient);
	
	@Query(value="SELECT SUM(f.montantFacture) FROM Facture f WHERE (f.client.categorieClient = :cat) AND (f.dateFacture between :start_date and :end_date)")
	float getChiffreAffaireParCategorieClient(@Param("cat") CategorieClient categorie ,@Param("start_date") Date startDate ,@Param("end_date") Date endDate);
}