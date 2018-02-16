package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.beans.Formation;
@Service
public interface FormationBusiness {

	Formation creerFormation(Formation formation);
	boolean supprimerFormation(Formation formationASuprimer);
	List<Formation> findByNomFormation(String nomFormation);
	List<Formation> allFormations();
	boolean supprimerFormationById(String id);
	Formation findById(String id);
}
