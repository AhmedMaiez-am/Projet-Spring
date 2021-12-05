package tn.esprit.spring.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.enume.CategorieClient;


@Repository
public interface FactureRepository extends CrudRepository<Facture, Long> {
	
	@Query("SELECT SUM(f.montantFacture) FROM Facture f")
	Float retrieveCA();
	
	@Query(value="SELECT * FROM Facture f WHERE f.client_id = :idClient" ,nativeQuery = true)
	List<Facture> getFactureByClient(@Param("idClient") Long id );
	
	
	@Query(value="SELECT SUM(f.montantFacture) FROM Facture f WHERE (f.client.categorieClient = :cat) AND (f.dateFacture between :start_date and :end_date)")
	float getChiffreAffaireParCategorieClient(@Param("cat") CategorieClient categorie ,@Param("start_date") Date startDate ,@Param("end_date") Date endDate);

	@Query(value="SELECT * FROM Facture WHERE (Facture.active = 1) AND (Facture.id_facture = :int)",nativeQuery = true)
	Facture setFacInactive(@Param("int") int i  );
	
	
	@Query(value="SELECT * FROM Facture WHERE (Facture.active = 0) AND (Facture.id_facture = :int)",nativeQuery = true)
	Facture setFacActive(@Param("int") int i  );
	
	
	@Query(value="SELECT * FROM Facture WHERE FACTURE.montant_facture = :float", nativeQuery = true)
	List<Facture> searchFacture(@Param("float") float f);
	
	
	@Query(value="SELECT * FROM Facture ORDER BY date_facture ASC",nativeQuery = true)
	List<Facture> triFacture();
	
}
