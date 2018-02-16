package fr.univbrest.dosi.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.beans.Enseignant;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)

public class EnseignantRepositoryTest {

	@Autowired
	EnseignantRepository enseignantRepository;
	
	@Before
	public void setup() {
		Enseignant enseignant1 = new Enseignant(1, "test.fr", "ens1");
		Enseignant enseignant2 = new Enseignant(2, "test.com", "ens2");
		enseignantRepository.save(enseignant1);
		enseignantRepository.save(enseignant2);
	}
	
	@Test
	public void doitCompterLesEnseignants() {
		long resultat = enseignantRepository.count();
		assertThat(resultat).isEqualTo(2);
	}
	
	@Test
	public void doitRechercherParNomEnseignant() {
		List<Enseignant> resultat = enseignantRepository.findByNom("ens1");
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getNom()).isEqualTo("ens1");
	}
	
	@Test
	public void doitRechercherParEmail() {
		List<Enseignant> resultat = enseignantRepository.findByemailUbo("test.com");
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getNom()).isEqualTo("ens2");
	}
}
