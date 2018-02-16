package fr.univbrest.dosi.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.beans.PromotionPK;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)

public class PromotionRepositoryTest {

	@Autowired
	PromotionRepository promotionRepository;
	
	@Before
	public void setup() {
		Promotion promotion1 = new Promotion(new PromotionPK("2014-2015","M2DOSI"), "DOSI6");
		Promotion promotion2 = new Promotion(new PromotionPK("2015-2016","M2DOSI"), "DOSI7");
		promotionRepository.save(promotion1);
		promotionRepository.save(promotion2);
	}
	
	@Test
	public void doitCompterLesPromotions() {
		long resultat = promotionRepository.count();
		System.out.println(resultat);
		assertThat(resultat).isEqualTo(2);
	}
	
	@Test
	public void doitRechercherParSiglePromotion() {
		List<Promotion> resultat = promotionRepository.findBySiglePromotion("DOSI7");
		System.out.println(resultat.size());
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getId().getAnneeUniversitaire()).isEqualTo("2015-2016");
		assertThat(resultat.get(0).getId().getCodeFormation()).isEqualTo("M2DOSI");
	}
	
}
