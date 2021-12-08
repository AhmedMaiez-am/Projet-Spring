package com.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.entities.Fournisseur;
import com.esprit.entities.Produit;
import com.esprit.repository.FournisseurRepository;
import com.esprit.repository.ProduitRepository;
import com.esprit.repository.StockRepository;
@Service
public class FournisseurServiceImpl implements FournisseurService {
@Autowired
private StockRepository stockRepository;
@Autowired
private ProduitRepository produitRepository;
@Autowired
private FournisseurRepository fournisseurRepository;

	@Override
	 public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
        if (fournisseurId != null && produitId != null) {
            if (this.produitRepository.findById(produitId).isPresent()
                    && this.fournisseurRepository.findById(fournisseurId).isPresent()) {
                Produit u = this.produitRepository.findById(produitId).get();
                u.getFournisseurs().add(this.fournisseurRepository.findById(fournisseurId).get());
                this.produitRepository.save(u);
            }
        }
    }

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		
		return fournisseurRepository.save(f);
	}

	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		// TODO Auto-generated method stub
		return (List<Fournisseur>)fournisseurRepository.findAll();
	}

	@Override
	public void deleteFournisseur(Long idFournisseur) {
		fournisseurRepository.deleteById(idFournisseur);
		
	}


	

}
