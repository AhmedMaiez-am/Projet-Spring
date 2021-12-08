package com.esprit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.esprit.entities.Facture;
import com.esprit.entities.Produit;
import com.esprit.entities.Stock;
import com.esprit.entities.detailFacture;
import com.esprit.repository.ClientRepository;
import com.esprit.repository.DetailFactureRepository;
import com.esprit.repository.FactureRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class FactureServiceImpl implements FactureService {
@Autowired
private FactureRepository factureRepository;
@Autowired
ClientRepository clientRepository;
@Autowired
DetailFactureRepository detailFactureRepository;
@Autowired
ProduitService produitService;
@Autowired
DetailFacture detailFactureService;
@Autowired
ClientSerivce clientService;

@Scheduled(cron = "* * * */1 JAN *")
public List<Facture> CalculSommeFactures() {
 
	log.info("SOMME CHIFFRE FACTURES");
	List<Facture> somme = factureRepository.CalculChiffreAffaire();
	return somme;
   

}

	@Override
	public List<Facture> retrieveAllFactures() {
		// TODO Auto-generated method stub
		return (List<Facture>) factureRepository.findAll() ;
	}

	@Override
	public void cancelFacture(Long id) {
		// TODO Auto-generated method stub
		factureRepository.deleteById(id);
					
	}

	@Override
	public Facture retrieveFacture(Long id) {
		// TODO Auto-generated method stub
		return factureRepository.findById(id).orElse(null);
	}

	@Override
	public List<Facture> getFacturesByClient(Long idClient) {
		return factureRepository.getFactureByClient(idClient);
	}

	@Override
	public Facture addFacture(Facture f, Long idClient) {
		/*List<DetailFacture> myList = new ArrayList<DetailFacture>();
		float montantFacture = 0;
		float montantRemiseFacture = 0;
		for (DetailFacture d : f.getDetailFactureList()) {
			float p = this.produitService.getPrixUnitaitreById(d.getProduit().getIdProduit());
			d.getProduit().setPrixUnitaire(p);
			float prixUnitaire = d.getProduit().getPrixUnitaire();
			float prixAvantRemise = prixUnitaire * d.getQte();
			if (d.get 0) {
				d.setMontantRemise(d.getPourcentageRemise() * prixAvantRemise / 100);
				d.setPrixTotal(prixAvantRemise - d.getMontantRemise());
			} else {
				d.setPrixTotal(prixAvantRemise);
			}
			montantFacture=montantFacture+d.getPrixTotal();
			montantRemiseFacture=montantRemiseFacture+d.getMontantRemise();
			myList.add(d);
		}
		f.setDateFacture(new Date());
		f.setMontantFacture(montantFacture);
		f.setMontantRemise(montantRemiseFacture);
		Client c =clientService.retrieveClient(idClient);
		f.setClient(c);
		Facture fc=factureRepository.save(f);
		for(DetailFacture dF:myList) {
			dF.setFacture(f);
			detailFactureService.addDetailFacture(dF);
		}*/
		return null;
			
		
} 


}
