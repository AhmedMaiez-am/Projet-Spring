package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

	void findByDateNaissanceGreaterThan(Date dateN);
	
	
//	Faites une requête permettant de sélectionner tous les clients nés entre
//	01/01/1995 et 31/12/1995 en SQL.
	
	@Query("SELECT c FROM Client c WHERE c.dateNaissance BETWEEN :d1 and :d2")
	List<Client> retrieveClientsByDateNaissance(@Param("d1") Date d1 , @Param("d2") Date d2);
	
	@Query("SELECT c FROM Client c WHERE c.nom like %:string% ")
	public List<Client> rech(@Param("string") String string);
	
	@Query(value="SELECT * FROM Client WHERE Client.categorie_Client = 'Premium'",nativeQuery = true)
	List<Client> getPremium();
	
	@Query(value="SELECT * FROM Client WHERE Client.categorie_Client != 'Premium'",nativeQuery = true)
	List<Client> getNonPremium();
	
	@Query(value="SELECT COUNT(*) FROM Client WHERE Client.categorie_Client = 'Premium'",nativeQuery = true)
	float clientsPremium();
	
	@Query(value="SELECT COUNT(*) FROM Client WHERE Client.categorie_Client = 'Fidele'",nativeQuery = true)
	float clientsFidele();
	
	@Query(value="SELECT COUNT(*) FROM Client WHERE Client.categorie_Client = 'Ordinaire'",nativeQuery = true)
	float clientsOrdinaire();
	
	
//	@Query(value = "SELECT c FROM Client c WHERE c.dateNaissance BETWEEN '01/01/1995' and '31/12/1995'" ,
//			nativeQuery = true)
//	List<Client> retrieveClientsByDateNai();

}