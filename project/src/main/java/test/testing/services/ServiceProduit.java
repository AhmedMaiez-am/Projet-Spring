package test.testing.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.testing.entity.Produit;
import test.testing.repository.ProduitRepository;

@Service
public class ServiceProduit implements IServiceProduit{

	@Autowired
	ProduitRepository pr;

	@Override
	public List<Produit> retrieveAllProduits() {
		// TODO Auto-generated method stub
		return (List<Produit>) pr.findAll();
	}

	@Override
	public Produit addProduit(Produit p) {
		// TODO Auto-generated method stub
		return pr.save(p);
	}

	@Override
	public Produit updateProduit(Produit u) {
		// TODO Auto-generated method stub
		return pr.save(u);
	}

	@Override
	public Produit retrieveProduit(Long id) {
		// TODO Auto-generated method stub
		Produit produit = pr.findById(id).orElse(null);
		return produit;
	}

	@Override
	public void deleteProduit(Long idProduit) {
		// TODO Auto-generated method stub
		pr.deleteById(idProduit);
	}

	@Override
	public float getPrixUnitaitreById(Long id) {
		// TODO Auto-generated method stub
		return this.pr.retrievePrixUnitaitreById(id);
	}

}
