package com.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.entities.Stock;
@Repository
public interface StockRepository  extends CrudRepository<Stock, Long> {
	@Query("SELECT s FROM Stock s WHERE s.qte<=s.qteMin")
	List<Stock> retrieveStockProcheDeRupture();
}
