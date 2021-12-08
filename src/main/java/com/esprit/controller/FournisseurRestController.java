package com.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.entities.CategorieProduit;
import com.esprit.entities.Fournisseur;
import com.esprit.entities.Produit;
import com.esprit.service.FournisseurService;

import io.swagger.annotations.Api;

@RestController
@Api(tags="Gestion des Fournisseurs")
@RequestMapping("/fournisseur")
@CrossOrigin(origins="*")
public class FournisseurRestController {

@Autowired
FournisseurService fournisseurService;

@GetMapping("/retrieve-all-fournisseurs")
@ResponseBody
public List<Fournisseur> getFournisseurs() {
List<Fournisseur> listFournisseurs = fournisseurService.retrieveAllFournisseurs();
return listFournisseurs;
}

@PostMapping("/add-fournisseur")
@ResponseBody
public Fournisseur addFournisseur(@RequestBody Fournisseur f)
{
Fournisseur fournisseur = fournisseurService.addFournisseur(f);
return fournisseur;
}

@PutMapping("/assign-FtoP")
@ResponseBody
public void assignFournisseurToProduit(@PathVariable Long fournisseurId,@PathVariable Long produitId) {
	 fournisseurService.assignFournisseurToProduit(fournisseurId, produitId);
}
@DeleteMapping("/delete-fournisseur/{id}")
@ResponseBody
public void DeleteFournisseur(@PathVariable("id") Long fournisseurId) {
	 fournisseurService.deleteFournisseur(fournisseurId);
}
}
