package test.testing.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.testing.entity.DetailFacture;
import test.testing.repository.DetailFactureRepository;

@Service
public class DetailFactureService implements IServiceDetailFacture {

	@Autowired
	DetailFactureRepository detailFactureRepository;

	@Override
	public DetailFacture addDetailFacture(DetailFacture detailFacture) {
		// TODO Auto-generated method stub
		return detailFactureRepository.save(detailFacture);
	}

	@Override
	public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return detailFactureRepository.getRevenuBrutProduit(idProduit, startDate, endDate);
	}

}
