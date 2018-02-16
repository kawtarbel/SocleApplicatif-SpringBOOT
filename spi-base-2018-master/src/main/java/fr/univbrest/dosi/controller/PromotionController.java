package fr.univbrest.dosi.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.beans.PromotionPK;
import fr.univbrest.dosi.business.PromotionBusiness;

@RestController
@RequestMapping("/promotion")
public class PromotionController {

	private PromotionBusiness business;

	@Autowired
	public PromotionController(PromotionBusiness business) {
		this.business = business;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Promotion creerPromotion(@RequestBody Promotion promotionACreer) {
		return business.creerPromotion(promotionACreer);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public boolean supprimerPromotion(Promotion promotionASuprimer) {
		return business.supprimerPromotion(promotionASuprimer);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{codeF}/{annee}")
	public boolean supprimerPromotionById(@PathVariable String codeF, @PathVariable String annee) {
		return business.supprimerPromotionById(new PromotionPK(annee, codeF));
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Promotion> findAll() {
		return business.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{codeF}/{annee}")
	public Promotion findById(@PathVariable String codeF, @PathVariable String annee) {
		return business.findById(new PromotionPK(annee, codeF));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sigle/{sigle}")
	public List<Promotion> findBySigle(@PathVariable String sigle) {
		return business.findBySiglePromotion(sigle);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dateRentree/{dateRentree}")
	public List<Promotion> findBydateRentree(@PathVariable String dateRentree) throws Exception {
		 Date date=new SimpleDateFormat("dd-MM-yyyy").parse(dateRentree);
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//Date date = new Date(sdf.parse(dateRentree).getTime());
		System.out.println(date+"     "+dateRentree);
		return business.findBydateRentree(date);

	}

}
