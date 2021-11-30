package test.testing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import test.testing.entity.DetailProduit;


@Repository
public interface DetailProduitRepository  extends CrudRepository<DetailProduit, Long>{

}

