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
import com.esprit.service.ClientServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="Gestion des clients")
@RequestMapping("/client")
@CrossOrigin(origins="localhost:4200")
public class ClientRestController {
	
	

	@Autowired
	ClientServiceImpl clientService;

	// http://localhost:8089/SpringMVC/client/retrieve-all-clients
	@ApiOperation(value="Récupérer la liste des clients")
	@GetMapping("/retrieve-all-clients")
	@ResponseBody
	public List<Client> getClient() {
	List<Client> listClients = clientService.retrieveAllClients();
	return listClients;
	}
	// http://localhost:8089/SpringMVC/client/add-client
	@ApiOperation(value="Ajouter un client")
	@PostMapping("/add-client")
	@ResponseBody
	Client addClient(@RequestBody Client c)
	{
	Client client = clientService.addClient(c);
	return client;
	}
	// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
	@ApiOperation(value="Suppression d'un client par son id")
	@DeleteMapping("/remove-client/{client-id}")
	@ResponseBody
	public void removeClient(@PathVariable("client-id") Long clientId) {
	clientService.deleteClient(clientId);
	}	
	// http://localhost:8089/SpringMVC/client/modify-client
	@ApiOperation(value="Modifier un client")
	@PutMapping("/modify-client")
	@ResponseBody
	public Client modifyClient(@RequestBody Client client) {
	return clientService.updateClient(client);
	}
}


