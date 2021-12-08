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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.entities.CategorieProduit;
import com.esprit.entities.Client;
import com.esprit.entities.DetailProduit;
import com.esprit.entities.Produit;
import com.esprit.service.ClientServiceImpl;
import com.esprit.service.ProduitServiceImpl;

import io.swagger.annotations.Api;

@RestController
@Api(tags="Gestion des produits")
@RequestMapping("/product")
@CrossOrigin(origins="http://localhost:4200")
public class ProduitRestController {
	@Autowired
	ProduitServiceImpl produitService;

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/retrieve-all-products")
	@ResponseBody
	public List<Produit> getProduits() {
	List<Produit> listProduits = produitService.retrieveAllProduits();
	return listProduits;
	}
	
	    @CrossOrigin(origins="http://localhost:4200")
	    @PostMapping("/add-produit/{idRayon}/{idStock}/{cat}")
		@ResponseBody
		public Produit addProduit(@RequestBody Produit p,@PathVariable("idRayon") Long idRayon,@PathVariable ("idStock") Long idStock,@PathVariable ("cat") CategorieProduit cat)
		{
		Produit produit = produitService.addProduit(p, idRayon, idStock,cat);
		return produit;
		}
	    
	    @CrossOrigin(origins="http://localhost:4200")
	    @DeleteMapping("/delete-produit/{id}")
		@ResponseBody
		public void deleteProduit(@PathVariable("id")Long id) {
	    	produitService.deleteProduit(id);
	    }
	    
	    @CrossOrigin(origins="http://localhost:4200")	    
	    @PutMapping("/update/{idRayon}/{idStock}/{cat}")
		@ResponseBody
		public Produit updateProduit(@RequestBody Produit produit,@PathVariable("idRayon") Long idRayon,@PathVariable("idStock") Long idStock,@PathVariable("cat")CategorieProduit cat){
			return  produitService.updateProduit(produit, idRayon, idStock,cat);
		}
	    
	    @CrossOrigin(origins="http://localhost:4200")
		@GetMapping("/retrieve-produitByLibelle/{produit-libelle}")
		@ResponseBody
		public List <Produit> retrieveProduitByLibelle(@PathVariable("produit-libelle") String name) {

			return produitService.retrieveProduitsByName(name);

		}



	    @CrossOrigin(origins="http://localhost:4200")
		@GetMapping("/retrieve-produitASC")
		@ResponseBody
		public List <Produit> retrieveProduitASC() {

			return produitService.TrierProduitASC();

		}

	    @CrossOrigin(origins="http://localhost:4200")
		@GetMapping("/retrieve-produitDESC")
		@ResponseBody
		public List <Produit> retrieveProduitDESC() {

			return produitService.TrierProduitDESC();

}
}
