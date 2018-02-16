package fr.univbrest.dosi.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;

@Component//dire a spring a lui de gerer cette class
public class FormationBusinessJPA implements FormationBusiness {
	
	private FormationRepository formationRepository;
	
	@Autowired
	public FormationBusinessJPA(FormationRepository formationRepository) {
		this.formationRepository=formationRepository;
	}
	
	@Override
	public List<Formation> allFormations() {
		return (List<Formation>) formationRepository.findAll();
	}
	
	@Override
	public Formation creerFormation(Formation formation) {
		formation.setDebutAccreditation(new Date());
		formationRepository.save(formation);
		return formation;
	}
	
	@Override
	public Formation findById(String id) {
		return formationRepository.findOne(id);
	}
	
	@Override
	public boolean supprimerFormation(Formation formationASuprimer) {
		formationRepository.delete(formationASuprimer);
		return true;
	}
	
	@Override
	public List<Formation> findByNomFormation(String nomFormation) {
		
		return formationRepository.findByNomFormation(nomFormation);
	}
	
	@Override
	public boolean supprimerFormationById(String id) {
		
		formationRepository.delete(id);
		 return true;
	}
}
