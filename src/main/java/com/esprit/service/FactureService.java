package com.esprit.service;
import java.util.*;

import com.esprit.entities.Facture;
public interface FactureService {
	List<Facture> retrieveAllFactures();
	void cancelFacture(Long id);
	Facture retrieveFacture(Long id);
	List<Facture> getFacturesByClient(Long idClient);
	Facture addFacture(Facture f, Long idClient);
}
