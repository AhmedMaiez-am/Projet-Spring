package com.esprit.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.entities.Client;
import com.esprit.entities.CategorieClient;
@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{

	
	@Query("SELECT c FROM Client c WHERE c.dateNaissance BETWEEN :d1 AND :d2 ")
	List<Client> findBetweenDateNaissance(@Param("d1") Date fromdate, @Param("d2") Date todate);
	
	/* @Query("SELECT SUM(f.montantFacture-f.montantRemise) FROM Client c,Facture f " +
	            "where c.categorieClient=?1 and f.dateFacture >=?2 " +
	            "and  f.dateFacture<= ?3 and c.idClient=f.Client.idClient")
	    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,
	                                                     Date startDate, Date endDate) ;*/
	

}