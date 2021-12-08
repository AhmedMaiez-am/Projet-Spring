package com.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.entities.Client;
import com.esprit.entities.Facture;
import com.esprit.service.FactureService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="Gestion des factures")
@RequestMapping("/facture")
@CrossOrigin(origins="localhost:4200")
public class FactureRestController {
	
	@Autowired
	FactureService factureService;
	
		@ApiOperation(value="Récupérer la liste des factures")
		@GetMapping("/retrieve-all-factures")
		@ResponseBody
		public List<Facture> getFacture() {
		List<Facture> listFactures = factureService.retrieveAllFactures();
		return listFactures;
		}
		
		@ApiOperation(value="Ajouter une facture")
		@PostMapping("/add-facture/{client-id}")
		@ResponseBody
		 Facture addFacture(@RequestBody Facture f,@PathVariable("client-id") Long idClient)
		{
		Facture facture = factureService.addFacture(f, idClient);
		return facture;
		}
}
