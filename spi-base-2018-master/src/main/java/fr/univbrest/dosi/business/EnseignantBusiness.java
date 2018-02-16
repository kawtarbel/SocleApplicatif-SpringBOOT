package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.beans.Enseignant;

@Service
public interface EnseignantBusiness {
	Enseignant creerEnseignant(Enseignant enseignantACreer);
	boolean supprimerEnseignant(Enseignant enseignantASuprimer);
	List<Enseignant> findByNom(String nom);
	List<Enseignant> findByEmail(String email);
	List<Enseignant> findAll();
	boolean supprimerEnseignantById(long id);
	Enseignant findById(long id);
	
}
