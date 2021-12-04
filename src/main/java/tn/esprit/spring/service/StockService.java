package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;

public interface StockService {

	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	Stock updateStock(Stock u);

	Stock retrieveStock(Long id);

	void deleteStock(Long id);

	void StockStatut();
	
	List<Stock> rechercheAvanceee(String string);
	
    void StockCal(Long idStock);

    List<Stock> retrieveAllStocksASC();
	
	List<Stock> retrieveAllStocksDESC();
	


}
