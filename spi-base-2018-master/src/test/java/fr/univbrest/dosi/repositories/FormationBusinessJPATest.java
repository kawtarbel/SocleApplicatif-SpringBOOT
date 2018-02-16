package fr.univbrest.dosi.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.business.FormationBusinessJPA;
import fr.univbrest.dosi.repositories.FormationRepository;

public class FormationBusinessJPATest {

	FormationBusinessJPA businessJPA;
	
	@Test
	public void doitCreerFormation() {
		FormationRepository formationRepository = new FormationRepositoryList();
		businessJPA = new FormationBusinessJPA(formationRepository);
		Formation formationACreer = new Formation("33","M2","O",BigDecimal.valueOf(2.0), "DOSI");
		Formation resFormation = businessJPA.creerFormation(formationACreer);
		assertThat(resFormation.getDebutAccreditation()).isCloseTo(new Date(), 500);
		assertThat(formationRepository.count()).isEqualTo(1);
	}
	
	@Test
	public void doitSupprimerUneFomation() {
		FormationRepository repos = new  FormationRepositoryList();
		businessJPA = new FormationBusinessJPA(repos);
		 Formation formationACreer = new Formation("33", null, "M2", "O", new Date(), BigDecimal.valueOf(2.0), "DOSI");
		 businessJPA.creerFormation(formationACreer);
		 boolean res = businessJPA.supprimerFormation(formationACreer);
		 
			assertThat(res).isEqualTo(true);
	}
	@Test
	public void doitChercherUneFomationParNom() {
		 Formation formationACreer = new Formation("33", null, "M2", "O", new Date(), BigDecimal.valueOf(2.0), "DOSI");
		FormationRepository repos = new  FormationRepositoryList(formationACreer);
		businessJPA = new FormationBusinessJPA(repos);
		// businessJPA.creerFormation(formationACreer);
		 List<Formation> resultat =  businessJPA.findByNomFormation("DOSI");
		 System.out.println(resultat.get(0).getNomFormation());
		 assertThat(resultat).hasSize(1);
		 //assertThat(resultat.get(0).getNomFormation()).isEqualTo("DOSI");
	}
	
	class FormationRepositoryList implements FormationRepository{
		
		private List<Formation> data;
		
		public FormationRepositoryList() {
			data = Lists.newArrayList();
		}
		
		public FormationRepositoryList(Formation...formations) {
			data = Lists.newArrayList(formations);
		}
		
		@Override
		public long count() {
			return data.size();
		}

		@Override
		public void delete(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Formation entity) {
			data.remove(entity);
			
		}

		@Override
		public void delete(Iterable<? extends Formation> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean exists(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Formation> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Formation> findAll(Iterable<String> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Formation findOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Formation> S save(S entity) {
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Formation> Iterable<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Formation> findByNomFormation(String nomFormation) {
			for (int i = 0; i < data.size(); i++) {
				if(data.get(i).getNomFormation() == nomFormation) {
					List<Formation> data2 = Lists.newArrayList();
					data2.add(data.get(i));
					return data2;
				}
			}
			
			return null;
		}
		
	}
}
