package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.repositories.CandidatRepository;

@Component
public class CandidatBusinessJPA  implements CandidatBusiness{

	private CandidatRepository repos;

	@Autowired
	public CandidatBusinessJPA(CandidatRepository repos) {
		this.repos=repos;
	}
	@Override
	public Candidat creerCandidat(Candidat candidatACreer) {
		
		return repos.save(candidatACreer);
	}
	@Override
	public boolean supprimerCandidat(Candidat candidatASuprimer) {
		
		 repos.delete(candidatASuprimer);
		 return true;
	}
	@Override
	public boolean supprimerCandidatById(String id) {
		
		 repos.delete(id);
		 return true;
	}
	@Override
	public Candidat findById(String id) {
		return repos.findOne(id);
	}
	@Override
	public List<Candidat> findByNom(String nom) {
		return  repos.findByNom(nom);
	}
	@Override
	public List<Candidat> findByUniversiteOrigine(String universiteOrigine) {
		return  repos.findByUniversiteOrigine(universiteOrigine);
	}
	@Override
	public List<Candidat> findAll() {
		return  (List<Candidat>) repos.findAll();
	}

}
