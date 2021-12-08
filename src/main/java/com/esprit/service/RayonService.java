package com.esprit.service;

import java.util.List;

import com.esprit.entities.Rayon;
import com.esprit.entities.Stock;

public interface RayonService {
	List<Rayon> retrieveAllRayons();

	Rayon addRayon(Rayon r);

	Rayon updateRayon(Rayon ra);

	Rayon retrieveRayon(Long id);
	
	void deleteRayon(Long id);
}
