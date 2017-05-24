package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

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

	@RequestMapping(method=RequestMethod.GET)
	public String afficherAccueil(ModelMap model) {
		List<Categorie> listeCategories=catService.getAllCategory();
		model.addAttribute("pCatListe", listeCategories);
		List<Produit> listeProduits=prService.getAllProducts();
		model.addAttribute("pPrListe", listeProduits);
		return "accueil";
	}
	
}
