package test.testing.services;

import java.util.Date;
import java.util.List;

import test.testing.entity.Facture;
import test.testing.enume.CategorieClient;



public interface IServiceFacture {
	List<Facture> retrieveAllFactures();
	void cancelFacture(Long id);
	Facture retrieveFacture(Long id);
	void retrieveCA();
	List<Facture> getFactureByClient(Long idClient);
	Facture addFacture(Facture f, Long idClient);
	float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,
			Date startDate, Date endDate);

}
