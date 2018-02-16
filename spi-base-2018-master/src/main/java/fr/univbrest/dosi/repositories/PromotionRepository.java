package fr.univbrest.dosi.repositories;



import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.beans.PromotionPK;


public interface PromotionRepository extends CrudRepository<Promotion, PromotionPK> {
	List<Promotion>findBySiglePromotion(String siglePromotion);
	List<Promotion> findBydateRentree(Date dateRentree);
}
