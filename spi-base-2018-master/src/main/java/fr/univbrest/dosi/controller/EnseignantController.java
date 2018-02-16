package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.beans.Enseignant;
import fr.univbrest.dosi.business.EnseignantBusiness;

@RestController
@RequestMapping("/enseignant")
public class EnseignantController {

private EnseignantBusiness business;
	
	@Autowired
	public EnseignantController(EnseignantBusiness business) {
		this.business=business;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Enseignant creerEnseignant(@RequestBody Enseignant enseignantACreer) {
		return business.creerEnseignant(enseignantACreer);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public boolean supprimerEnseignant(Enseignant enseignantASuprimer) {
		return business.supprimerEnseignant(enseignantASuprimer);
	}
	@RequestMapping(method = RequestMethod.DELETE,value="/{id}")
	public boolean supprimerEnseignantById(@PathVariable long id) {
		return business.supprimerEnseignantById(id);
	}

	@RequestMapping(method = RequestMethod.GET,value="/nom/{nom}")
	public List<Enseignant> findByNom( @PathVariable String nom) {
		return business.findByNom(nom);
	}

	@RequestMapping(method = RequestMethod.GET,value="/email/{email:.+}")
	public List<Enseignant> findByUniversiteOrigine(@PathVariable String email) {
		return business.findByEmail(email);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Enseignant> findAll() {
		return business.findAll();
	}
	@RequestMapping(method = RequestMethod.GET,value="/{id}")
	public Enseignant findById(@PathVariable long id) {
		return business.findById(id);
	}
	
	
}
