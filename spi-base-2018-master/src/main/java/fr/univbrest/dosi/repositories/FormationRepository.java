package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.beans.Formation;

public interface FormationRepository extends CrudRepository<Formation, String> {

	List<Formation> findByNomFormation(String nomFormation);
}