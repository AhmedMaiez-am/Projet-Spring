package com.esprit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.entities.Stock;
import com.esprit.service.StockService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest  {
	@Autowired
	StockService stockService;

	@Test
	public void testAddStock() {
		Stock s = new Stock();
//		s.setLibelleStock("Test" );
//		s.setQte(17);
//		s.setQteMin(65);
		Stock savedStock = stockService.addStock(s);
		assertNotNull(savedStock);
		assertTrue(stockService.retrieveAllStocks().contains(savedStock));
		
	}
	
	
}