package com.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.entities.Rayon;
import com.esprit.entities.Stock;
@Repository
public interface RayonRepository  extends CrudRepository<Rayon, Long>  {

}
