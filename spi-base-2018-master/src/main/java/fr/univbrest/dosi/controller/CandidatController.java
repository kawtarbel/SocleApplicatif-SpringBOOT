package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.business.CandidatBusiness;

@RestController
@RequestMapping("/candidat")
public class CandidatController {

private CandidatBusiness business;
	
	@Autowired
	public CandidatController(CandidatBusiness business) {
		this.business=business;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Candidat creerCandidat(@RequestBody Candidat candidatACreer) {
		return business.creerCandidat(candidatACreer);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public boolean supprimerCandidat(Candidat candidatASuprimer) {
		return business.supprimerCandidat(candidatASuprimer);
	}
	@RequestMapping(method = RequestMethod.DELETE,value="/{id}")
	public boolean supprimerCandidatById(@PathVariable String id) {
		return business.supprimerCandidatById(id);
	}

	@RequestMapping(method = RequestMethod.GET,value="/nom/{nom}")
	public List<Candidat> findByNom( @PathVariable String nom) {
		return business.findByNom(nom);
	}

	@RequestMapping(method = RequestMethod.GET,value="/univ/{univ}")
	public List<Candidat> findByUniversiteOrigine(@PathVariable String univ) {
		return business.findByUniversiteOrigine(univ);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Candidat> findAll() {
		return business.findAll();
	}
	@RequestMapping(method = RequestMethod.GET,value="/{id}")
	public Candidat findById(String id) {
		return business.findById(id);
	}
	
	
}
