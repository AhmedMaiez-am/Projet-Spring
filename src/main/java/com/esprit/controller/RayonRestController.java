package com.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.entities.Rayon;
import com.esprit.entities.Stock;
import com.esprit.service.RayonServiceImpl;
import com.esprit.service.StockServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="Gestion des Rayons")
@RequestMapping("/rayon")
@CrossOrigin(origins="localhost:4200")
public class RayonRestController {
	@Autowired
	RayonServiceImpl rayonService;

	// http://localhost:8089/SpringMVC/rayon/retrieve-all-rayons
	@ApiOperation(value="Récupérer la liste des rayons")
	@GetMapping("/retrieve-all-rayons")
	@ResponseBody
	public List<Rayon> getRayons() {
	List<Rayon> listRayons = rayonService.retrieveAllRayons();
	return listRayons;
	}
	// http://localhost:8089/SpringMVC/rayon/add-rayon
	@ApiOperation(value="Ajouter un rayon")
	@PostMapping("/add-rayon")
	@ResponseBody
	public Rayon addRayon(@RequestBody Rayon r)
	{
	Rayon rayon= rayonService.addRayon(r);
	return rayon;
	}
}
