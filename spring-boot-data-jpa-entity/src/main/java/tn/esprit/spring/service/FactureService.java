package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.enume.CategorieClient;

public interface FactureService {
	List<Facture> retrieveAllFactures();

	void cancelFacture(Long id);
	
	void deleteFacture(Long id);

	Facture retrieveFacture(Long id);
	
	List<Facture> triFacture();

	void retrieveCA();

	List<Facture> getFactureByClient(Long id);
	
	
	List<Facture> searchFac(float f);
	
	Facture addFacture(Facture f, Long idClient);
	
	Facture setFactureInactive(int i);
	
	Facture setFactureActive(int i);
	
	
	float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,
			Date startDate, Date endDate);
	
	List<Facture> rechercheParDate(String d);
	
	
	List<Facture> getActiveFacture();

	List<Facture> getInactiveFacture();

	
}
