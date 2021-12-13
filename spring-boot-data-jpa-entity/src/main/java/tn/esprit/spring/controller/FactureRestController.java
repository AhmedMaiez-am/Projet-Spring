package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.pdf.FacturePDFexporter;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.enume.CategorieClient;
import tn.esprit.spring.service.DetailFactureService;
import tn.esprit.spring.service.FactureService;
import tn.esprit.spring.service.ProduitService;

@RestController
@Api(tags = "invoice management")
@RequestMapping("/facture")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
public class FactureRestController {

	@Autowired
	FactureService factureService;

	@Autowired
	ProduitService produitService;

	@Autowired
	DetailFactureService detailFactureService;

	@GetMapping("/retrieve-all-invocies")
	@ApiOperation(value = "Récupérer la liste des factures")
	@ResponseBody
	public List<Facture> listFactures() {
		return factureService.retrieveAllFactures();
	}

	@GetMapping("/cancel-invoice/{invoice-id}")
	@ApiOperation(value = "cancel facture")
	@ResponseBody
	public void cancelInvoice(@PathVariable("invoice-id") Long invoiceId) {
		factureService.cancelFacture(invoiceId);
	}

	@DeleteMapping("/delete-invoice/{invoice-id}")
	@ApiOperation(value = "delete facture")
	@ResponseBody
	public void deleteInvoice(@PathVariable("invoice-id") Long invoiceId) {
		factureService.deleteFacture(invoiceId);
	}

	@GetMapping("/retrive-invoce/{invoice-id}")
	@ApiOperation(value = "get invoice by id")
	@ResponseBody
	public Facture retrieveFacture(@PathVariable("invoice-id") Long invoiceId) {
		return factureService.retrieveFacture(invoiceId);
	}

	@GetMapping("/retrive-invoice-by-client-id/{client-id}")
	@ApiOperation("get invoice by client id")
	@ResponseBody
	public List<Facture> getInvoiceByClientId(@PathVariable("client-id") Long id) {

		return this.factureService.getFactureByClient(id);
	}

	@PostMapping("/add-invoice/{client-id}")
	@ApiOperation("add invoice")
	@ResponseBody
	Facture addFactureRest(@RequestBody Facture f, @PathVariable("client-id") Long idClient) {
		return factureService.addFacture(f, idClient);
	}

	@GetMapping("/get-ca/{cat}/{start-date}/{end-date}")
	@ApiOperation("get ca par categorie client")
	@ResponseBody
	float getChiffreAffaireParCategorieClient(@PathVariable("cat") CategorieClient categorieClient,
			@PathVariable("start-date") String  startDate,@PathVariable("end-date") String endDate) throws ParseException {
		return factureService.getChiffreAffaireParCategorieClient(categorieClient, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate));
	}


	// http://localhost:8089/SpringMVC/facture/set-inactive
	@GetMapping("/set-inactive/{etat}")
	@ApiOperation(value = "set inactive")
	@ResponseBody
	public Facture setFacInactive(@PathVariable ("etat") int i) {
		return factureService.setFactureInactive(i);
	}

	// http://localhost:8089/SpringMVC/facture/set-active
	@GetMapping("/set-active/{etat}")
	@ApiOperation(value = "set active")
	@ResponseBody
	public Facture setFacActive(@PathVariable ("etat") int i) {
		return factureService.setFactureActive(i);
	}
	
	@GetMapping("/get-active")
	@ApiOperation(value = "Récupérer la liste des factures trié par montant ascendant")
	@ResponseBody
	public List<Facture> getActiveFac() {
		return factureService.getActiveFacture();
	}
	
	@GetMapping("/get-inactive")
	@ApiOperation(value = "Récupérer la liste des factures trié par montant ascendant")
	@ResponseBody
	public List<Facture> getInactiveFac() {
		return factureService.getInactiveFacture();
	}
	
	@GetMapping("/searchByDate/{date}")
	@ApiOperation(value = "search by date")
	@ResponseBody
	public List<Facture> rechercheParDate(@PathVariable ("date") String d) {
		return factureService.rechercheParDate(d);
	}
	
	@GetMapping("/searchBymontant/{montant}")
	@ApiOperation(value = "search by date")
	@ResponseBody
	public List<Facture> rechercheParMontant(@PathVariable ("montant") float d) {
		return factureService.searchFac(d);
	}
	
	@GetMapping("/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Facture> listUsers = factureService.retrieveAllFactures();
         
        FacturePDFexporter exporter = new FacturePDFexporter(listUsers);
        exporter.export(response);
         
    }


}
