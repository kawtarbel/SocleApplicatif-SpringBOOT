package fr.univbrest.dosi.business;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.beans.PromotionPK;

@Service
public interface PromotionBusiness {

	Promotion creerPromotion(Promotion promotionACreer);

	boolean supprimerPromotion(Promotion s);

	boolean supprimerPromotionById(PromotionPK pk);

	Promotion findById(PromotionPK pk);

	List<Promotion> findAll();

	List<Promotion> findBySiglePromotion(String sigle);

	List<Promotion> findBydateRentree(Date dateRentree);
	
}
