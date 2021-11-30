package test.testing.services;

import java.util.List;

import test.testing.entity.Produit;



public interface IServiceProduit {
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p);

	Produit updateProduit(Produit u);

	Produit retrieveProduit(Long id);

	void deleteProduit(Long idProduit);
	
	
	public float getPrixUnitaitreById(Long id);
}
