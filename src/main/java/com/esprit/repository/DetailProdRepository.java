package com.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.entities.DetailProduit;
@Repository
public interface DetailProdRepository extends CrudRepository<DetailProduit, Long> {

}
