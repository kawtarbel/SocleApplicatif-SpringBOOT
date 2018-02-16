package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.beans.Candidat;

@Service
public interface CandidatBusiness {
	Candidat creerCandidat(Candidat candidatACreer);
	boolean supprimerCandidat(Candidat candidatASuprimer);
	List<Candidat> findByNom(String nom);
	List<Candidat> findByUniversiteOrigine(String universiteOrigine);
	List<Candidat> findAll();
	boolean supprimerCandidatById(String id);
	Candidat findById(String id);
	
}
