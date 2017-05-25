package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.LigneCommande;
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
		model.addAttribute("pKeyWord", new Produit());
		return "accueil";
	}
	
	@RequestMapping(value="/afficherParCat/{nomCat}", method=RequestMethod.GET)
	public String afficherAccueilCategorie(ModelMap model, @PathVariable("nomCat")String categorie)
	{
		Categorie cat = catService.getCategorieByName(categorie);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProductsByCategory(cat));
		model.addAttribute("pKeyWord", new Produit());
		return "accueil";
	}
	
	@RequestMapping(value="/afficherParKeyWord", method=RequestMethod.POST)
	public String afficherAccueilMotCle(ModelMap model, @ModelAttribute("pKeyWord")Produit prod)
	{
		String motCle = prod.getDesignation();
		System.out.println("--------Mot Clé " + motCle);
		System.out.println("--------liste total : " + prService.getAllProductsByKeyWord(motCle));
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProductsByKeyWord(motCle));
		model.addAttribute("pKeyWord", new Produit());
		return "accueil";
	}
	
	@RequestMapping(value="/afficherFicheProd/{idProduit}", method=RequestMethod.GET)
	public String afficherFicheProduit(ModelMap model, @PathVariable("idProduit")int id)
	{
		Produit p = prService.getProduct(id);
		model.addAttribute("pProduit", p);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pKeyWord", new Produit());
	
		model.addAttribute("mLigneCommande", new LigneCommande());
		return "fiche_produit";
	}
	
	@RequestMapping(value="/ajouterAuPanier", method=RequestMethod.POST)
	public String ajouterLigneCommandePanier(@ModelAttribute("mLigneCommande")LigneCommande lc)
	{
		return "panier";
	}
}
