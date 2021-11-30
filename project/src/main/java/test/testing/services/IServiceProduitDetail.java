package test.testing.services;

import java.util.List;

import test.testing.entity.DetailProduit;
import test.testing.entity.Produit;



public interface IServiceProduitDetail {
	DetailProduit addDetailProduit(Produit d);
	DetailProduit updateDetailProduct(DetailProduit u);
	void deletedetailProduct(Long id);
	DetailProduit retrieveDetailProduct(Long id);
	List<DetailProduit> retrieveAllProducts();
}
