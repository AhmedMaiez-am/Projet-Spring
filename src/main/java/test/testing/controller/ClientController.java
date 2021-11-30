package test.testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import test.testing.entity.Client;
import test.testing.services.ServiceClient;


@Api(tags = "Client Management")
@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	ServiceClient clientService;
	@ApiOperation(value = "Récupérer la liste des clients")
	// http://localhost:8089/SpringMVC/client/retrieve-all-clients
	@GetMapping("/retrieve-all-clients")
	@ResponseBody
	public List<Client> listClient() {
		return clientService.retrieveAllClients();
	}

	// http://localhost:8089/SpringMVC/client/retrieve-client/8
	@GetMapping("/retrieve-client/{client-id}")
	@ApiOperation(value = "Récupérer client par id")
	@ResponseBody
	public Client retrieveClient(@PathVariable("client-id") Long clientId) {
		return clientService.retrieveClient(clientId);
	}

	// http://localhost:8089/SpringMVC/client/add-client
	@PostMapping("/add-client")
	@ApiOperation(value = "ajouter client")
	@ResponseBody
	public Client addClient(@RequestBody Client c) {
		Client client = clientService.addClient(c);
		return client;
	}

	// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
	@DeleteMapping("/remove-client/{client-id}")
	@ApiOperation(value = "supprimer client")
	@ResponseBody
	public void removeClient(@PathVariable("client-id") Long clientId) {
		clientService.deleteClient(clientId);
	}

	// http://localhost:8089/SpringMVC/client/modify-client
	@PutMapping("/modify-client")
	@ApiOperation(value = "modifier client")
	@ResponseBody
	public Client modifyClient(@RequestBody Client client) {
		return clientService.updateClient(client);
	}

}
