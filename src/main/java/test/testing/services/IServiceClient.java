package test.testing.services;

import java.util.Date;
import java.util.List;


import test.testing.entity.Client;



public interface IServiceClient {
	List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);
	List <Client> getClientWithDate(Date d1 ,Date d2);

}
