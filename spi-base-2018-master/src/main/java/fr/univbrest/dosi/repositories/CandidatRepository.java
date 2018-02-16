package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.beans.Candidat;

public interface CandidatRepository extends CrudRepository<Candidat, String> {
	
	List<Candidat> findByNom(String nomCandidat);
	List<Candidat> findByUniversiteOrigine(String universiteOrigine);

}
