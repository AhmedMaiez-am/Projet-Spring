package test.testing.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import test.testing.services.DetailFactureService;

@RestController
@Api(tags = "Detail facture management")
@RequestMapping("/detail-facture")
public class DetailFactureController {

	@Autowired
	DetailFactureService detailFactureService;
	
	@PostMapping("/get-revenue-brute/{id-produit}/{start-date}/{end-date}")
	@ApiOperation("get revenue brute")
	@ResponseBody
	float getRevenuBrutProduit(@PathVariable("id-produit") Long idProduit,
			@PathVariable("start-date") String  startDate,@PathVariable("end-date") String endDate) throws ParseException {
		return detailFactureService.getRevenuBrutProduit(idProduit, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate));
	}
}
