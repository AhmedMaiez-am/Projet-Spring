package com.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.entities.Rayon;
import com.esprit.entities.Stock;
import com.esprit.repository.RayonRepository;
import com.esprit.repository.StockRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class RayonServiceImpl implements RayonService {
	@Autowired
	private RayonRepository rayonRepository;
	@Override
	public  List<Rayon> retrieveAllRayons() {
		// TODO Auto-generated method stub
		return (List<Rayon>) rayonRepository.findAll();
	}

	@Override
	public Rayon addRayon(Rayon r) {
		// TODO Auto-generated method stub
		return rayonRepository.save(r);
	}

	@Override
	public Rayon updateRayon(Rayon ra) {
		// TODO Auto-generated method stub
		return rayonRepository.save(ra);
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		// TODO Auto-generated method stub
		return rayonRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteRayon(Long id) {
		// TODO Auto-generated method stub
		rayonRepository.deleteById(id);
	}

}
