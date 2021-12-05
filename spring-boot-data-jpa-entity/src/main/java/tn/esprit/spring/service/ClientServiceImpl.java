package tn.esprit.spring.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> retrieveAllClients() {
		return (List<Client>) clientRepository.findAll();
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
		
		return clientRepository.findById(id).orElse(null);
	}

	@Override
	public List<Client> getClientWithDate(Date d1 ,Date d2) {
		// TODO Auto-generated method stub
		
		return clientRepository.retrieveClientsByDateNaissance(d1,d2);

	//	return clientRepository.retrieveClientsByDateNaissance( new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1995"),new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1995"));
	}

	@Override
	public List<Client> rechercheClient(String string) {
		// TODO Auto-generated method stub
		List<Client> rechList=clientRepository.rech(string);
		return rechList;
	}
	
	
	
	
	
		
	

}
