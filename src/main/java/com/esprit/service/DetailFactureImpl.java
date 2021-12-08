package com.esprit.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.repository.DetailFactureRepository;
@Service
public class DetailFactureImpl implements DetailFacture {
@Autowired
DetailFactureRepository detailFactureRepository;

	@Override
	public DetailFacture addDetailFacture(DetailFacture detailFacture) {
		
		return null ;//detailFactureRepository.save(detailFacture);
	}

	@Override
	public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
	 	return 0;
	 			/* detailFactureRepository.getRevenuBrutProduit(idProduit, startDate, endDate);*/
	}

}
