package fr.univbrest.dosi.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.beans.Candidat;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)

public class CandidatRepositoryTest {

	@Autowired
	CandidatRepository candidatRepository;
	
	@Before
	public void setup() {
		Candidat candidat1 = new Candidat("c1", "belaadel", "kawtar", "FSTG");
		Candidat candidat2 = new Candidat("c2", "zineb", "belaadel", "SUD");
		candidatRepository.save(candidat1);
		candidatRepository.save(candidat2);
	}
	
	@Test
	public void doitCompterLesCandidats() {
		long resultat = candidatRepository.count();
		
		assertThat(resultat).isEqualTo(2);
	}
	
	@Test
	public void doitRechercherParNomCandidat() {
		List<Candidat> resultat = candidatRepository.findByNom("zineb");
		
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getNom()).isEqualTo("zineb");
		assertThat(resultat.get(0).getNoCandidat()).isEqualTo("c2");
	}
	
	@Test
	public void doitRechercherParNomFormation() {
		List<Candidat> resultat = candidatRepository.findByUniversiteOrigine("FSTG");
		
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getUniversiteOrigine()).isEqualTo("FSTG");
		assertThat(resultat.get(0).getNoCandidat()).isEqualTo("c1");
	}
}
