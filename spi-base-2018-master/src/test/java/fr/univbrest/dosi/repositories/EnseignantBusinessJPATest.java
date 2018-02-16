package fr.univbrest.dosi.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;


import fr.univbrest.dosi.beans.Enseignant;
import fr.univbrest.dosi.business.EnseignantBusinessJPA;
import fr.univbrest.dosi.repositories.EnseignantRepository;

public class EnseignantBusinessJPATest {
	EnseignantBusinessJPA business;
  @Test
	public void doitCreerUnEns() {
		EnseignantRepository repos = new  EnseignantRepositoryList();
		 business = new EnseignantBusinessJPA(repos);
		 Enseignant enseignantACreer = new Enseignant(1, "test.com", "ens1");		
		 Enseignant resultat = business.creerEnseignant(enseignantACreer);
		  Long res=  repos.count();
		  assertThat(res).isEqualTo(1);
	}
  @Test
	public void doitSupprimerUnEnseignant() {
	  EnseignantRepository repos = new  EnseignantRepositoryList();
		 business = new EnseignantBusinessJPA(repos);
		 Enseignant enseignantACreer =  new Enseignant(1, "test.com", "ens1");
		 business.creerEnseignant(enseignantACreer);
		 boolean res = business.supprimerEnseignant(enseignantACreer);
			assertThat(res).isEqualTo(true);
	}
  @Test
	public void doitChercherUnEnseignantParNom() {
	  EnseignantRepository repos = new  EnseignantRepositoryList();
		 business = new EnseignantBusinessJPA(repos);
		 Enseignant enseignantACreer = new Enseignant(1, "test.com", "ens1");	
		 business.creerEnseignant(enseignantACreer);
		 List< Enseignant> resultat =  business.findByNom("ens1");
		 assertThat(resultat).hasSize(1);
	}
  @Test
	public void doitChercherUnEnsegnantParEmail() {
	  EnseignantRepository repos = new  EnseignantRepositoryList();
		 business = new EnseignantBusinessJPA(repos);
		 Enseignant enseignantACreer = new Enseignant(1, "testcom", "ens1");	
		 business.creerEnseignant(enseignantACreer);
		 List< Enseignant> resultat =  business.findByEmail("testcom");
		 System.out.println(resultat);
		 assertThat(resultat).hasSize(1);
	}


public class EnseignantRepositoryList implements EnseignantRepository{

	  private List<Enseignant> data;
		
		public EnseignantRepositoryList (){
			data = Lists.newArrayList();
		}
		
	@Override
	public <S extends Enseignant> S save(S entity) {
		data.add(entity);
		return entity;
	}

	@Override
	public <S extends Enseignant> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enseignant findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Enseignant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Enseignant> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		return data.size();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Enseignant entity) {
		data.remove(entity);
		
	}

	@Override
	public void delete(Iterable<? extends Enseignant> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Enseignant> findByNom(String nom) {
		for (int i = 0; i < data.size(); i++) {
			if(data.get(i).getNom() == nom) {
				List<Enseignant> data2 = Lists.newArrayList();
				data2.add(data.get(i));
				return data2;
			}
		}
		
		return null;
	}

	@Override
	public List<Enseignant> findByemailUbo(String emailUbo) {
		
		for (int i = 0; i < data.size(); i++) {
			if(data.get(i).getEmailUbo() == emailUbo) {
				List<Enseignant> data3 = Lists.newArrayList();
				data3.add(data.get(i));
				return data3;
			}
		}
		
		return null;
	}

	
}
}


