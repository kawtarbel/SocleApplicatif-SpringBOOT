package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.beans.Enseignant;

public interface EnseignantRepository extends CrudRepository<Enseignant,Long> {
	
	List<Enseignant> findByNom(String nom);
	List<Enseignant> findByemailUbo(String emailUbo);

}
