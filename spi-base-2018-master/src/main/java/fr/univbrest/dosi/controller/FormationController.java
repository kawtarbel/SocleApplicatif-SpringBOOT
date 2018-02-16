package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.business.FormationBusiness;



@RestController
@RequestMapping("/formation")
public class FormationController {

	private FormationBusiness business;
	
	@Autowired
	public FormationController(FormationBusiness business) {
		this.business=business;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Formation creerFormation(@RequestBody Formation formation) {
		return business.creerFormation(formation);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public boolean supprimerFormation(Formation formationASuprimer) {
		return business.supprimerFormation(formationASuprimer);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/nom/{nom}")
	public List<Formation> findByNomFormation(@PathVariable String nom) {
		return business.findByNomFormation(nom);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/{id}")
	public boolean supprimerFormationById(@PathVariable String id) {
		return business.supprimerFormationById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Formation> allFormations() {
		return business.allFormations();
	}
	@RequestMapping(method = RequestMethod.GET,value="/{id}")
	public Formation findById(String id) {
		return business.findById(id);
	}
	
	
	
}
