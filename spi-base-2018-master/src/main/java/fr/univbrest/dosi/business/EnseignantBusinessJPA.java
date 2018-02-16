package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.beans.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;

@Component
public class EnseignantBusinessJPA  implements EnseignantBusiness{

	private EnseignantRepository repos;

	@Autowired
	public EnseignantBusinessJPA(EnseignantRepository repos) {
		this.repos=repos;
	}
	@Override
	public Enseignant creerEnseignant(Enseignant enseignantACreer) {
		
		return repos.save(enseignantACreer);
	}
	@Override
	public boolean supprimerEnseignant(Enseignant enseignantASuprimer) {
		
		 repos.delete(enseignantASuprimer);
		 return true;
	}
	@Override
	public boolean supprimerEnseignantById(long id) {
		
		 repos.delete(id);
		 return true;
	}
	@Override
	public Enseignant findById(long id) {
		return repos.findOne(id);
	}
	@Override
	public List<Enseignant> findByNom(String nom) {
		return  repos.findByNom(nom);
	}
	@Override
	public List<Enseignant> findByEmail(String email) {
		return  repos.findByemailUbo(email);
	}
	@Override
	public List<Enseignant> findAll() {
		return  (List<Enseignant>) repos.findAll();
	}

}
