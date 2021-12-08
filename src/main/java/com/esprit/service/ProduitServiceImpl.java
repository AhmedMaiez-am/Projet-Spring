package com.esprit.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.entities.CategorieProduit;
import com.esprit.entities.DetailProduit;
import com.esprit.entities.Produit;
import com.esprit.repository.DetailProdRepository;
import com.esprit.repository.ProduitRepository;
import com.esprit.repository.RayonRepository;
import com.esprit.repository.StockRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ProduitServiceImpl implements ProduitService {
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private RayonRepository rayonRepository;
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	DetailProdRepository detailProdRepository;
	@Override
	public List<Produit> retrieveAllProduits() {
		// TODO Auto-generated method stub
		return (List<Produit>)produitRepository.findAll();
	}


	@Transactional
	public Produit addProduit(Produit p, Long idRayon, Long idStock,CategorieProduit cat) {
		p.setRayon(rayonRepository.findById(idRayon).orElse(null));
		p.setStock(stockRepository.findById(idStock).orElse(null));

		/*
		 * Produit produit1=produitRepository.save(p);
		Date date = new Date(System.currentTimeMillis());
		DetailProduit dProduit= new DetailProduit(produit1.getIdProduit(), date, date, cat, produit1);
		produit1.setDetailProduit(dProduit);
		detailProdRepository.save(dProduit);
		 */
		Date date = new Date(System.currentTimeMillis());
		DetailProduit dProduit = new DetailProduit(date,date,cat);
		detailProdRepository.save(dProduit);
		p.setDetailProduit(dProduit);
		produitRepository.save(p);

		return  p ; 
	}

	@Override
	public Produit retrieveProduit(Long id) {
		// TODO Auto-generated method stub
		return produitRepository.findById(id).get();
	}


	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		if(idStock!=null && idProduit!=null) {
			if(this.produitRepository.findById(idProduit).isPresent() && this.stockRepository.findById(idStock).isPresent()) {
				Produit u = this.produitRepository.findById(idProduit).get();
				u.setStock(this.stockRepository.findById(idStock).get());
				this.produitRepository.save(u);
			}
		}

	}


	@Override
	public void deleteProduit(Long idProduit) {
		produitRepository.deleteById(idProduit);

	}


	@Override
	public Produit updateProduit(Produit prod, Long idRayon, Long idStock ,CategorieProduit cat ) {
		//to retrieve the object u must get it with the findById 
		Produit p = produitRepository.findById(prod.getIdProduit()).get();
		p.setRayon(rayonRepository.findById(idRayon).get());
		p.setStock(stockRepository.findById(idStock).get());
		p.setCode(prod.getCode());
		p.setLibelle(prod.getLibelle());
		p.setPrixUnitaire(prod.getPrixUnitaire());
		//alaaBenFradj

		DetailProduit dProduit = detailProdRepository.findById(p.getDetailProduit().getIdDetailProduit()).get();


		Date date =new Date(System.currentTimeMillis());
		dProduit.setDateDernièreModification(date);
		dProduit.setCategorieProduit(cat);
		detailProdRepository.save(dProduit);

		//this one is for testing 
		dProduit.setProduit(p);

		p.setDetailProduit(dProduit);
		return produitRepository.save(p);

	}
	@Override

	public List<Produit> retrieveProduitsByName(String nom) {

		// TODO Auto-generated method stub

		return produitRepository.ProduitsByName(nom);

	}



	@Override

	public List<Produit> TrierProduitASC() {

		// TODO Auto-generated method stub

		return produitRepository.TrieProduitsASC();

	}



	@Override

	public List<Produit> TrierProduitDESC() {

		// TODO Auto-generated method stub

		return produitRepository.TrieProduitsDESC();


}
}
