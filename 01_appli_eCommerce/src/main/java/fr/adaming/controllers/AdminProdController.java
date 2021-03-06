package fr.adaming.controllers;

/**
 * @author INTI-0366
 * 
 * Controller pour gerer l'administrateur qui s'occupe de la gestion des produits
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.LigneCommande;
import fr.adaming.entities.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/adminProd")

public class AdminProdController {
	
	/**
	 * Associations :
	 * ICategorieService catService
	 * IProduitService prService
	 */
	
	@Autowired
	private ICategorieService catService;
	@Autowired
	private IProduitService prService;
	
	/**
	 * @return the catService
	 */
	public ICategorieService getCatService() {
		return catService;
	}

	/**
	 * @param catService the catService to set
	 */
	public void setCatService(ICategorieService catService) {
		this.catService = catService;
	}

	/**
	 * @return the prService
	 */
	public IProduitService getPrService() {
		return prService;
	}

	/**
	 * @param prService the prService to set
	 */
	public void setPrService(IProduitService prService) {
		this.prService = prService;
	}

	/**
	 * @param model
	 * @return
	 * 
	 * Generation des methodes
	 */
	
	@RequestMapping(method=RequestMethod.GET)
	public String afficherAccueil(ModelMap model) 
	{
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		model.addAttribute("pKeyWord", new Produit());
		return "accueilAdminProd";
	}
	
	@RequestMapping(value="/photoProd", produces=MediaType.ALL_VALUE)
	@ResponseBody
	public byte[] getPhoto(int id) throws IOException {
		Produit prod = prService.getProduct(id);
		return IOUtils.toByteArray(new ByteArrayInputStream(prod.getPhoto()));
	}
	
	@RequestMapping(value="/afficherParCat/{nomCat}", method=RequestMethod.GET)
	public String afficherAccueilCategorie(ModelMap model, @PathVariable("nomCat")String categorie)
	{
		Categorie cat = catService.getCategorieByName(categorie);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProductsByCategory(cat));
		model.addAttribute("pKeyWord", new Produit());
		return "accueilAdminProd";
	}
	
	@RequestMapping(value="/afficherParKeyWord", method=RequestMethod.POST)
	public String afficherAccueilMotCle(ModelMap model, @ModelAttribute("pKeyWord")Produit prod)
	{
		String motCle = prod.getDesignation();
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProductsByKeyWord(motCle));
		model.addAttribute("pKeyWord", new Produit());
		return "accueilAdminProd";
	}
	
	@RequestMapping(value="/afficherFicheProd/{idProduit}", method=RequestMethod.GET)
	public String afficherFicheProduit(ModelMap model, @PathVariable("idProduit")int id)
	{
		Produit p = prService.getProduct(id);
		model.addAttribute("pProduit", p);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pKeyWord", new Produit());
	
		model.addAttribute("mLigneCommande", new LigneCommande());
		return "fiche_produit_adminProd";
	}
	
	@RequestMapping(value="/formulaireAjoutProduit2", method=RequestMethod.GET)
	public ModelAndView formulaireAjoutProduit() {
		ModelAndView mav=new ModelAndView("formulaireAjoutProduit2", "mProduit", new Produit());
		mav.addObject("pKeyWord", new Produit());
		mav.addObject("pCatListe", catService.getAllCategory());
		return mav;
	}
	
	@RequestMapping(value="/ajoutProduit", method=RequestMethod.POST)
	public String ajoutProduit(ModelMap model, @ModelAttribute("mProduit") Produit pProduit, MultipartFile file) throws Exception {
		pProduit.setPhoto(file.getBytes());
		prService.createProduct(pProduit);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		model.addAttribute("pKeyWord", new Produit());
		return "accueilAdminProd";
	}
	
	@RequestMapping(value="/formulaireModifierProduit2", method=RequestMethod.GET)
	public ModelAndView formulaireModifierProduit(ModelMap model, @RequestParam("idProduit")int id) {
		Produit p=prService.getProduct(id);
		ModelAndView mav=new ModelAndView("formulaireModifierProduit2", "mProduit2", new Produit());
		model.addAttribute("pProduit", p);
		mav.addObject("pKeyWord", new Produit());
		mav.addObject("pCatListe", catService.getAllCategory());
		return mav;
	}
	
	@RequestMapping(value="/modifierProduit", method=RequestMethod.POST)
	public String modifierProduit(ModelMap model, @ModelAttribute("mProduit2") Produit pProduit, MultipartFile file) throws Exception {
		pProduit.setPhoto(file.getBytes());
		prService.updateProduct(pProduit);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		model.addAttribute("pKeyWord", new Produit());
		return "accueilAdminProd";
	}
	
	@RequestMapping(value="/supprimerProduit", method=RequestMethod.GET)
	public ModelAndView supprimerProduit(ModelMap model, @RequestParam("idProduit")int id) {
		ModelAndView mav=new ModelAndView("accueilAdminProd");
		prService.deleteProduct(id);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		model.addAttribute("pKeyWord", new Produit());
		return mav;
	}

}