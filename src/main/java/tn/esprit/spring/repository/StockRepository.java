package tn.esprit.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

	Stock findByLibelleStock(String s);
	
	@Query("SELECT s FROM Stock s WHERE s.qteMin >= s.qte")
	List<Stock> retrieveStock();
	 @Query("SELECT s FROM Stock s WHERE s.libelleStock like %:string% ")
		public List<Stock> rech(@Param("string") String string);
	 
	 @Query("SELECT s FROM Stock s  ORDER BY s.libelleStock ASC")
		public List<Stock> sortASC();
		
		@Query("SELECT s FROM Stock s  ORDER BY s.libelleStock DESC")
		public List<Stock> sortDESC();

}
