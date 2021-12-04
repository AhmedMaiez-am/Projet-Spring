package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.repository.RayonRepository;
@Service
public class RayonServiceImpl implements RayonService {

	
	@Autowired
	RayonRepository rayonRepository;
	
	
	@Override
	public Rayon addRayon(Rayon r) {
		return rayonRepository.save(r);
	}
	
	@Override
	public Rayon updateRayon(Rayon r) {
		return rayonRepository.save(r);
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		return rayonRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteRayon(Long id) {
		rayonRepository.deleteById(id);
		
	}

	@Override
	public List<Rayon> retriveAll() {
	return (List<Rayon>) rayonRepository.findAll();
		
	}
	
	@Override
	public List<Rayon> rechercheAvancee(String string){
		List<Rayon> rechList = rayonRepository.rech(string);
		return rechList;
	}
	
	@Override
	public List<Rayon> retrieveAllRayonsASC() {
		List<Rayon> allRayons = rayonRepository.sortASC();
		return allRayons;
	}

	@Override
	public List<Rayon> retrieveAllRayonsDESC() {
		List<Rayon> allRayons = rayonRepository.sortDESC();
		return allRayons;
	}

	

}
