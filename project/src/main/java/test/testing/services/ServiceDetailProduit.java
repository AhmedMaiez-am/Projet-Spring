package test.testing.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.testing.entity.DetailProduit;
import test.testing.entity.Produit;
import test.testing.repository.DetailProduitRepository;

@Service
public class ServiceDetailProduit implements IServiceProduitDetail {

	
	@Autowired
	DetailProduitRepository dpr;
	@Override
	public DetailProduit addDetailProduit(Produit d) {
		// TODO Auto-generated method stub
		return dpr.save(d.getDetailProduit());
	}

	@Override
	public DetailProduit updateDetailProduct(DetailProduit u) {
		// TODO Auto-generated method stub
		return dpr.save(u);
	}

	@Override
	public void deletedetailProduct(Long id) {
		// TODO Auto-generated method stub
		dpr.deleteById(id);
	}

	@Override
	public DetailProduit retrieveDetailProduct(Long id) {
		// TODO Auto-generated method stub
		DetailProduit dp = dpr.findById(id).orElse(null);
		return dp;
	}

	@Override
	public List<DetailProduit> retrieveAllProducts() {
		// TODO Auto-generated method stub
		return (List<DetailProduit>) dpr.findAll();
	}

}
