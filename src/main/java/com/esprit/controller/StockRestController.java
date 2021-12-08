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

import com.esprit.entities.Client;
import com.esprit.entities.Stock;
import com.esprit.service.ClientServiceImpl;
import com.esprit.service.StockServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="Gestion des stocks")
@RequestMapping("/stock")
@CrossOrigin(origins="localhost:4200")
public class StockRestController {
	@Autowired
	StockServiceImpl stockService;

	// http://localhost:8089/SpringMVC/stock/retrieve-all-stocks
	@ApiOperation(value="Récupérer la liste des stocks")
	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	public List<Stock> getStocks() {
	List<Stock> listStocks = stockService.retrieveAllStocks();
	return listStocks;
	}
	// http://localhost:8089/SpringMVC/stock/add-stock
	@ApiOperation(value="Ajouter un stock")
	@PostMapping("/add-stock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock s)
	{
	Stock stock = stockService.addStock(s);
	return stock;
	}
	// http://localhost:8089/SpringMVC/stock/remove-stock/{stock-id}
	@ApiOperation(value="Suppression d'un stock par son id")
	@DeleteMapping("/remove-stock/{stock-id}")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long stockId) {
	stockService.deleteStock(stockId);
	}	
	// http://localhost:8089/SpringMVC/stock/modify-stock
	@ApiOperation(value="Modifier un stock")
	@PutMapping("/modify-stock")
	@ResponseBody
	public Stock modifyStock(@RequestBody Stock stock) {
	return stockService.updateStock(stock);
	}
}
