package com.esprit.service;

import java.util.List;

import com.esprit.entities.DetailProduit;

public interface DetailProdService {
	List<DetailProduit> retrieveAllDetProd();

	DetailProduit addDetProd(DetailProduit det);

	DetailProduit updateDetProd(DetailProduit deta);

	DetailProduit retrieveDetProd(Long id);
	
	void deleteDetProd(Long id);
}
