package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.StockRepository;

@Service
@Slf4j
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;

	@Autowired
	ProduitRepository  produitRepository;
	
	@Override
	public List<Stock> retrieveAllStocks() {
		return (List<Stock>) stockRepository.findAll();
	}

	@Override
	public Stock addStock(Stock s) {

		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock u) {
		return stockRepository.save(u);
	}

	@Override
	public Stock retrieveStock(Long id) {
		return stockRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteStock(Long id) {
		stockRepository.deleteById(id);

	}

	@Override
	@Scheduled(cron = "*/60 * * * * *")
	public void StockStatut() {
		List<Stock> stockList;
		stockList = (List<Stock>) stockRepository.retrieveStock();
		for (Stock item : stockList) {
			log.info(item.getLibelleStock() + " en rupture la quantité min est "+item.getQteMin()+" la quant actuelle est "+item.getQte());
		}
	}
	
	@Override
	public List<Stock> rechercheAvanceee(String string) {
		List<Stock> rech = stockRepository.rech(string);
		return rech;
	}

	@Transactional
	public void StockCal(Long idStock) {
		Stock s = retrieveStock(idStock);
		s.setQte(produitRepository.calculStock(idStock));
		updateStock(s);
	}
		
	
	@Override
	public List<Stock> retrieveAllStocksASC() {
		List<Stock> allStocks = stockRepository.sortASC();
		return allStocks;
	}

	@Override
	public List<Stock> retrieveAllStocksDESC() {
		List<Stock> allStocks = stockRepository.sortDESC();
		return allStocks;
	}
	
	
	
	


}
