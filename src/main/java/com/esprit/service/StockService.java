package com.esprit.service;
import java.util.*;

import com.esprit.entities.Stock;
public interface StockService {
	
	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	Stock updateStock(Stock u);

	Stock retrieveStock(Long id);
	
	void deleteStock(Long id);
}
