package test.testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import test.testing.entity.Facture;
import test.testing.services.ServiceFacture;


@RestController
@Api(tags = "Facture Management")
@RequestMapping("/facture")
public class FactureController {
	
	@Autowired
	ServiceFacture factureService;
	
	@GetMapping("/retrieve-factures")
	@ApiOperation(value = "Récupérer la liste des factures")
	@ResponseBody
	public List<Facture> listFactures() {
		return factureService.retrieveAllFactures();
	}

	@GetMapping("/cancel-facture/{facture-id}")
	@ApiOperation(value = "Cancel facture")
	@ResponseBody
	public void cancelInvoice(@PathVariable("facture-id") Long factureId) {
		factureService.cancelFacture(factureId);
	}

	@GetMapping("/retrive-facture/{facture-id}")
	@ApiOperation(value = "Récupérer facture par id")
	@ResponseBody
	public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
		return factureService.retrieveFacture(factureId);
	}

}
