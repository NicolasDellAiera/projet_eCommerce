package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller

public class LoginController {
	
	//Associations
	@Autowired
	private ICategorieService catService;
	@Autowired
	private IProduitService prService;
	
	//Getters and setters
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
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String afficherPageLogin() {
		return "loginPage";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView  logoutMethode() {
		ModelAndView mav=new ModelAndView("accueil");
		mav.addObject("pCatListe", catService.getAllCategory());
		mav.addObject("pPrListe", prService.getAllProducts());
		mav.addObject("pKeyWord", new Produit());
		return mav;
	}
	
	@RequestMapping(value="/denied", method=RequestMethod.GET)
	public String deniedMethode() {
		return "denied";
	}
	
	@RequestMapping(value="/loginEchec", method=RequestMethod.GET)
	public String deniedMethode(ModelMap model) {
		model.addAttribute("erreur", "true");
		return "loginPage";
	}

}