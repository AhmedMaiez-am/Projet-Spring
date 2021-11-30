package test.testing.services;

import java.util.Date;

import test.testing.entity.DetailFacture;


public interface IServiceDetailFacture {

	DetailFacture addDetailFacture(DetailFacture detailFacture );
	
	float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
}
