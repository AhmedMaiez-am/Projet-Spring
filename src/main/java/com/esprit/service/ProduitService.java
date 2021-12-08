package com.esprit.service;
import java.util.*;

import com.esprit.entities.CategorieProduit;
import com.esprit.entities.DetailProduit;
import com.esprit.entities.Produit;
public interface ProduitService {
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p, Long idRayon, Long idStock,CategorieProduit cat);

	Produit retrieveProduit(Long id);
	void assignProduitToStock(Long idProduit, Long idStock);
	void deleteProduit(Long idProduit);
	public Produit updateProduit(Produit prod, Long idRayon, Long idStock ,CategorieProduit cat );
	List<Produit>retrieveProduitsByName(String nom);
	List<Produit>TrierProduitASC();
	List<Produit>TrierProduitDESC();

	
	
	
	
}
