package tn.esprit.spring.service;


import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Client;

public interface ClientService {

	List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);
	
	List <Client> getClientWithDate(Date d1 ,Date d2);
	
	List<Client> rechercheClient(String string);

	List<Client> getPremium();
	
	List<Client> getNonPremium();
	
	float clientsPremium();
	
	float clientsFidele();
	
	float clientsOrdinaire();
}
