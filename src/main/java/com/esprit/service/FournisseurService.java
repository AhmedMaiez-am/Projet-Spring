package com.esprit.service;

import java.util.List;

import com.esprit.entities.Fournisseur;
import com.esprit.entities.Rayon;

public interface FournisseurService {
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;
	Fournisseur addFournisseur(Fournisseur f);
    public List<Fournisseur> retrieveAllFournisseurs();
    void deleteFournisseur(Long idFournisseur);
}
