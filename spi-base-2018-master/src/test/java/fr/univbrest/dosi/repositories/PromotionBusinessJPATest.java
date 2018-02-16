package fr.univbrest.dosi.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;

import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.beans.PromotionPK;
import fr.univbrest.dosi.business.PromotionBusinessJPA;
import fr.univbrest.dosi.repositories.PromotionRepository;

public class PromotionBusinessJPATest {
  PromotionBusinessJPA business;
  @Test
	public void doitCreerUneFomation() {
		 PromotionRepository repos = new  PromotionRepositoryList();
		 business = new PromotionBusinessJPA(repos);
		 Promotion promotionACreer = new Promotion(new PromotionPK("2014-2015","M2DOSI"), "DOSI6");		
		 Promotion resultat = business.creerPromotion(promotionACreer);
		  Long res=  repos.count();
		  assertThat(res).isEqualTo(1);
	}
  @Test
	public void doitSupprimerUnPromotion() {
	  PromotionRepository repos = new  PromotionRepositoryList();
		 business = new PromotionBusinessJPA(repos);
		 Promotion promotionACreer =  new Promotion(new PromotionPK("2014-2015","M2DOSI"), "DOSI6");
		 business.creerPromotion(promotionACreer);
		 boolean res = business.supprimerPromotion(promotionACreer);
			assertThat(res).isEqualTo(true);
	}
  @Test
	public void doitChercherUnPromotionParSigle() {
	  PromotionRepository repos = new  PromotionRepositoryList();
		 business = new PromotionBusinessJPA(repos);
		 Promotion promotionACreer = new Promotion(new PromotionPK("2014-2015","M2DOSI"), "DOSI6");		
		 business.creerPromotion( promotionACreer);
		 List< Promotion> resultat =  business.findBySiglePromotion("DOSI6");
			assertThat(resultat).hasSize(1);
			assertThat(resultat.get(0).getId().getAnneeUniversitaire()).isEqualTo("2014-2015");
			assertThat(resultat.get(0).getId().getCodeFormation()).isEqualTo("M2DOSI");
	}
  @Test
	public void doitChercherUnPromotionPardDate() {
	  PromotionRepository repos = new  PromotionRepositoryList();
		 business = new PromotionBusinessJPA(repos);
		 Date date =new Date();
		 Promotion promotionACreer = new Promotion(new PromotionPK("2014-2015","M2DOSI"), date);	
		 business.creerPromotion( promotionACreer);
		 System.out.println("1"+promotionACreer);
		 List< Promotion> resultat =  business.findBydateRentree(date);
		 System.out.println("2"+resultat);
			assertThat(resultat).hasSize(1);
	}
  
}
class PromotionRepositoryList implements PromotionRepository{


	private List<Promotion> data;
	
	public PromotionRepositoryList (){
		data = Lists.newArrayList();
	}
	
	@Override
	public <S extends Promotion> S save(S entity) {
		data.add(entity);
		return entity;
	}

	@Override
	public <S extends Promotion> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Promotion findOne(PromotionPK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(PromotionPK id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Promotion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Promotion> findAll(Iterable<PromotionPK> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		return data.size();
	}

	@Override
	public void delete(PromotionPK id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Promotion entity) {
		data.remove(entity);
		
	}

	@Override
	public void delete(Iterable<? extends Promotion> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Promotion> findBySiglePromotion(String siglePromotion) {
		List<Promotion> data2=Lists.newArrayList();
		for (int i = 0; i < data.size(); i++) {
			if(data.get(i).getSiglePromotion().equals(siglePromotion)) {
				data2.add(data.get(i));
				return data2;
			}
		}
		return null;
	}

	
	@Override
	public List<Promotion> findBydateRentree(Date dateRentree) {
		List<Promotion> data2=Lists.newArrayList();
		for (int i = 0; i < data.size(); i++) {
			if(data.get(i).getDateRentree()==dateRentree) {
				data2.add(data.get(i));
				return data2;
			}
		}
		return null;
	}
	
	
}
