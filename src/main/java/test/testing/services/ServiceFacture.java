package test.testing.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import test.testing.entity.Client;
import test.testing.entity.DetailFacture;
import test.testing.entity.Facture;
import test.testing.enume.CategorieClient;
import test.testing.repository.FactureRepository;



@Service
@Slf4j
public class ServiceFacture implements IServiceFacture {

	@Autowired
	FactureRepository factureRepository;
	
	@Autowired
	ServiceClient clientService;
	
	@Autowired
	ServiceProduit produitService;
	
	@Autowired
	IServiceDetailFacture detailFactureService;

	@Override
	public List<Facture> retrieveAllFactures() {

		return (List<Facture>) factureRepository.findAll();
	}

	@Override
	public void cancelFacture(Long id) {
		Facture facture = this.retrieveFacture(id);
		facture.setActive(false);
		this.factureRepository.save(facture);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		return this.factureRepository.findById(id).orElse(null);
	}

	@Override
	@Scheduled(cron = "1 * * 1 JAN *")
	public void retrieveCA() {
		this.factureRepository.retrieveCA();
		List<Float> myList = new ArrayList<>();
		myList.addAll(this.factureRepository.retrieveCA());
		float ca = 0;
		for (float i : myList) {
			ca += i;
		}
		log.info(new Date() +"Chiffre d'affaire : " + ca);

	}

	@Override
	public List<Facture> getFactureByClient(Long idClient) {
		// TODO Auto-generated method stub
		return factureRepository.getFactureByClient(idClient);
	}

	@Override
	public Facture addFacture(Facture f, Long idClient) {
		// TODO Auto-generated method stub
		List<DetailFacture> myList = new ArrayList<DetailFacture>();
		float montantFacture = 0;
		float montantRemiseFacture = 0;
		for (DetailFacture d : f.getDetailFacture()) {
			float p = this.produitService.getPrixUnitaitreById(d.getProduit().getIdProduit());
			d.getProduit().setPrixUnitaire(p);
			float prixUnitaire = d.getProduit().getPrixUnitaire();
			float prixAvantRemise = prixUnitaire * d.getQte();
			if (d.getPourcentageRemise() != 0) {
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
		}
		return fc;
	}

	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return factureRepository.getChiffreAffaireParCategorieClient(categorieClient, startDate, endDate);
	}

}
