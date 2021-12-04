package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;

public interface RayonService {

	Rayon addRayon(Rayon r);

	List <Rayon> retriveAll();
	
	Rayon updateRayon(Rayon r);

	
	void deleteRayon(Long id);

	Rayon retrieveRayon(Long id);
	
	List<Rayon> rechercheAvancee(String string);
	
    List<Rayon> retrieveAllRayonsASC();
	
	List<Rayon> retrieveAllRayonsDESC();

}
