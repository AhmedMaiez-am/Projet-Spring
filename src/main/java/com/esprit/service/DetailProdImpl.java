package com.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.entities.DetailProduit;
import com.esprit.entities.Produit;
import com.esprit.entities.Rayon;
import com.esprit.repository.DetailProdRepository;
import com.esprit.repository.ProduitRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DetailProdImpl implements DetailProdService
{
	@Autowired
	private DetailProdRepository DetproduitRepository;	
	@Override
	public List<DetailProduit> retrieveAllDetProd() {
		// TODO Auto-generated method stub
		return (List<DetailProduit>)DetproduitRepository.findAll();
	}

	@Override
	public  DetailProduit addDetProd(DetailProduit det) {
		// TODO Auto-generated method stub
		return DetproduitRepository.save(det);
	}

	@Override
	public DetailProduit updateDetProd(DetailProduit deta) {
		// TODO Auto-generated method stub
		return DetproduitRepository.save(deta);
	}

	@Override
	public DetailProduit retrieveDetProd(Long id) {
		// TODO Auto-generated method stub
		return DetproduitRepository.findById(id).get();
	}

	@Override
	public void deleteDetProd(Long id) {
		// TODO Auto-generated method stub
		DetproduitRepository.deleteById(id);
		
	}

}
