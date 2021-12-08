package com.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.entities.Fournisseur;
import com.esprit.entities.Produit;
@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {

}
