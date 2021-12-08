package com.esprit.service;

import java.util.Date;

public interface DetailFacture {

 DetailFacture addDetailFacture(DetailFacture detailFacture );
	
	float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
}
