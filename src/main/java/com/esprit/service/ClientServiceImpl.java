package com.esprit.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.entities.CategorieClient;
import com.esprit.entities.Client;
import com.esprit.repository.ClientRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientServiceImpl implements ClientSerivce {
@Autowired
private ClientRepository clientRepository;
	@Override
	public List<Client> retrieveAllClients() {
		List<Client> clients =(List<Client>) clientRepository.findAll();
		for(Client client : clients)
		{
			log.info("client:" + client);
		}
		return clients ;
		
	}

	@Override
	public Client addClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public void deleteClient(Long id) {
	clientRepository.deleteById(id);
	}

	@Override
	public Client updateClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public Client retrieveClient(Long id) {
		// TODO Auto-generated method stub
		return clientRepository.findById(id).get();
	}

	@Override
	public List<Client> clientBetweenBirthDate(Date fromDate, Date toDate) {

		return clientRepository.findBetweenDateNaissance(fromDate, toDate);
	}

	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
		
		return 0;
	}
}