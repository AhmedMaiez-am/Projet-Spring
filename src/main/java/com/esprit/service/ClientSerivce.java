package com.esprit.service;
import java.util.*;
import com.esprit.entities.CategorieClient;

import com.esprit.entities.Client;

public interface ClientSerivce {
	
	List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);
	
	 List<Client> clientBetweenBirthDate(Date fromDate, Date toDate);
	 float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,Date startDate,Date endDate);

}
