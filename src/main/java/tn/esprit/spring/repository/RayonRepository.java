package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Rayon;

@Repository
public interface RayonRepository extends CrudRepository<Rayon, Long> {
	
	@Query("SELECT r FROM Rayon r WHERE r.code like %:string% OR r.libelle like %:string%")
	public List<Rayon> rech(@Param("string") String string);
	
	@Query("SELECT r FROM Rayon r  ORDER BY r.libelle ASC")
	public List<Rayon> sortASC();
	
	@Query("SELECT r FROM Rayon r  ORDER BY r.libelle DESC")
	public List<Rayon> sortDESC();

}
