package com.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.esprit.entities.Stock;
import com.esprit.repository.StockRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class StockServiceImpl implements StockService {
@Autowired
private StockRepository stockRepository;


@Scheduled(cron = "*/20 * * * * *")
public void scheduleTaskUsingCronExpression() {
 
	log.info("stock check");
	List<Stock> currentStock = stockRepository.retrieveStockProcheDeRupture();
	for(Stock s:currentStock) {
			log.info(s.getLibelleStock()+"needs more");
	}
   

}
	@Override
	public List<Stock> retrieveAllStocks() {
		// TODO Auto-generated method stub
		return (List<Stock>) stockRepository.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		// TODO Auto-generated method stub
		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock u) {
		// TODO Auto-generated method stub
		return stockRepository.save(u);
	}

	@Override
	public Stock retrieveStock(Long id) {
		// TODO Auto-generated method stub
		return stockRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteStock(Long id) {
		// TODO Auto-generated method stub
		stockRepository.deleteById(id);
	}

}
