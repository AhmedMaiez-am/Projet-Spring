package com.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.entities.Produit;
@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {
	@Query("SELECT p FROM Produit p WHERE p.libelle LIKE %:libelle%")

    List<Produit> ProduitsByName(@Param("libelle") String libelle);

	

	@Query("SELECT p FROM Produit p ORDER BY p.libelle ASC ")

    List<Produit> TrieProduitsASC();

	

	@Query("SELECT p FROM Produit p ORDER BY p.libelle DESC ")

    List<Produit> TrieProduitsDESC();
}
