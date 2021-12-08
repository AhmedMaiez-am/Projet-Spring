package com.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.entities.Client;
import com.esprit.entities.DetailProduit;
import com.esprit.service.DetailProdService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="Gestion detail produit")
@RequestMapping("/detailProduit")
@CrossOrigin(origins="localhost:4200")
public class DetailProdRestController {
	@Autowired
	DetailProdService detailProdService;
	
	@ApiOperation(value="Ajouter detail Produit")
	@PostMapping("/add-detail")
	@ResponseBody
	DetailProduit addDetailProduit(@RequestBody DetailProduit det)
	{
	DetailProduit detail = detailProdService.addDetProd(det);
	return detail;
	}
}
