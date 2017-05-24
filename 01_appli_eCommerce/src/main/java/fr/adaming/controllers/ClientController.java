package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

/**
 * Cette classe est le controleur du client
 * @author INTI-0366
 *
 */

@Controller
@RequestMapping("/site")

public class ClientController {

	
	@Autowired
	private ICategorieService catService;
	
	@Autowired
	private IProduitService prService;

	public ICategorieService getCatService() {
		return catService;
	}

	public void setCatService(ICategorieService catService) {
		this.catService = catService;
	}
	
	public IProduitService getPrService() {
		return prService;
	}

	public void setPrService(IProduitService prService) {
		this.prService = prService;
	}
	
	
	//Methods
	@RequestMapping(method=RequestMethod.GET)
	public String afficherAccueil(ModelMap model) 
	{
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		return "accueil";
	}
	
	@RequestMapping(value="/afficherParCat/{nomCat}")
	public String afficherAccueilCategorie(ModelMap model, @PathVariable("nomCat")String categorie)
	{
		Categorie cat = catService.getCategorieByName(categorie);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProductsByCategory(cat));
		return "accueil";
	}
}
