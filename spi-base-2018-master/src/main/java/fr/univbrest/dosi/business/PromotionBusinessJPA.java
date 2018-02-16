package fr.univbrest.dosi.business;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.beans.PromotionPK;
import fr.univbrest.dosi.repositories.PromotionRepository;

@Component
public class PromotionBusinessJPA  implements PromotionBusiness{

	private PromotionRepository repos;

	@Autowired
	public PromotionBusinessJPA(PromotionRepository repos) {
		this.repos=repos;
	}
	@Override
	public Promotion creerPromotion(Promotion promotionACreer) {
		
		return repos.save(promotionACreer);
	}
	@Override
	public boolean supprimerPromotion(Promotion promotionASuprimer) {
		
		 repos.delete(promotionASuprimer);
		 return true;
	}
	@Override
	public boolean supprimerPromotionById(PromotionPK pk) {
		
		 repos.delete(pk);
		 return true;
	}
	@Override
	public Promotion findById(PromotionPK pk) {
		return repos.findOne(pk);
	}
	
	@Override
	public List<Promotion> findAll() {
		return  (List<Promotion>) repos.findAll();
	}
	
	@Override
	public List<Promotion> findBySiglePromotion(String sigle) {
		return  (List<Promotion>) repos.findBySiglePromotion(sigle);
	}
	
	@Override
	public List<Promotion> findBydateRentree(Date dateRentree) {
		return  (List<Promotion>) repos.findBydateRentree(dateRentree);
	}

}
