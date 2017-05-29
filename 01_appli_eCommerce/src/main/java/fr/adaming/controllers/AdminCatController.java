package fr.adaming.controllers;

/**
 * @author INTI-0366
 * 
 * Controller pour gerer l'administrateur qui s'occupe de la gestion des produits, des categories, et des autres admins
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.LigneCommande;
import fr.adaming.entities.Produit;
import fr.adaming.service.IAdminService;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/adminCat")

public class AdminCatController {
	
	/**
	 * Associations :
	 * ICategorieService catService
	 * IProduitService prService
	 * IAdminService admService
	 */
	
	@Autowired
	private ICategorieService catService;
	@Autowired
	private IProduitService prService;
	@Autowired
	private IAdminService admService;
	
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
	 * @return the admService
	 */
	public IAdminService getAdmService() {
		return admService;
	}

	/**
	 * @param admService the admService to set
	 */
	public void setAdmService(IAdminService admService) {
		this.admService = admService;
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
		return "accueilAdminCat";
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
		return "accueilAdminCat";
	}
	
	@RequestMapping(value="/afficherParKeyWord", method=RequestMethod.POST)
	public String afficherAccueilMotCle(ModelMap model, @ModelAttribute("pKeyWord")Produit prod)
	{
		String motCle = prod.getDesignation();
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProductsByKeyWord(motCle));
		model.addAttribute("pKeyWord", new Produit());
		return "accueilAdminCat";
	}
	
	@RequestMapping(value="/afficherFicheProd/{idProduit}", method=RequestMethod.GET)
	public String afficherFicheProduit(ModelMap model, @PathVariable("idProduit")int id)
	{
		Produit p = prService.getProduct(id);
		model.addAttribute("pProduit", p);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pKeyWord", new Produit());
	
		model.addAttribute("mLigneCommande", new LigneCommande());
		return "fiche_produit_adminCat";
	}
	
	@RequestMapping(value="/formulaireAjoutCat", method=RequestMethod.GET)
	public ModelAndView formulaireAjout() {
		ModelAndView mav=new ModelAndView("formulaireAjoutCat", "mCategorie", new Categorie());
		mav.addObject("pKeyWord", new Produit());
		mav.addObject("pCatListe", catService.getAllCategory());
		return mav;
	}
	
	@RequestMapping(value="/ajoutCat", method=RequestMethod.POST)
	public String soumettreFormulaireAjout(ModelMap model, @ModelAttribute("mCategorie") Categorie pCategorie) {
		catService.createCategory(pCategorie);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		model.addAttribute("pKeyWord", new Produit());
		return "accueilAdminCat";
	}
	
	@RequestMapping(value="/supprimerCategorie", method=RequestMethod.GET)
	public ModelAndView supprimerCategorie(ModelMap model, @RequestParam("idCategorie")int id) {
		ModelAndView mav=new ModelAndView("accueilAdminCat");
		catService.deleteCategorie(id);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		model.addAttribute("pKeyWord", new Produit());
		return mav;
	}
	
	@RequestMapping(value="/formulaireModifierCategorie", method=RequestMethod.GET)
	public ModelAndView formulaireModifierCategorie(ModelMap model, @RequestParam("idCategorie")int id) {
		Categorie cat=catService.getCategorieByID(id);
		ModelAndView mav=new ModelAndView("ficheCategorie", "mCategorie2", new Categorie());
		model.addAttribute("pCategorie", cat);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pKeyWord", new Produit());
		return mav;
	}
	
	@RequestMapping(value="/modifierCat", method=RequestMethod.POST)
	public String modifierCategorie(ModelMap model, @ModelAttribute("mCategorie2") Categorie pCategorie) {
		catService.updateCategory(pCategorie);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		model.addAttribute("pKeyWord", new Produit());
		return "accueilAdminCat";
	}
	
	@RequestMapping(value="/formulaireAjoutProduit", method=RequestMethod.GET)
	public ModelAndView formulaireAjoutProduit() {
		ModelAndView mav=new ModelAndView("formulaireAjoutProduit", "mProduit", new Produit());
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
		return "accueilAdminCat";
	}
	
	@RequestMapping(value="/formulaireModifierProduit", method=RequestMethod.GET)
	public ModelAndView formulaireModifierProduit(ModelMap model, @RequestParam("idProduit")int id) {
		Produit p=prService.getProduct(id);
		ModelAndView mav=new ModelAndView("formulaireModifierProduit", "mProduit2", new Produit());
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
		return "accueilAdminCat";
	}
	
	@RequestMapping(value="/supprimerProduit", method=RequestMethod.GET)
	public ModelAndView supprimerProduit(ModelMap model, @RequestParam("idProduit")int id) {
		ModelAndView mav=new ModelAndView("accueilAdminCat");
		prService.deleteProduct(id);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		model.addAttribute("pKeyWord", new Produit());
		return mav;
	}
	
	@RequestMapping(value="/listeAdmin", method=RequestMethod.GET)
	public String listeAdminProd(ModelMap model) {
		List<Admin> listeAdminProds=admService.getAllAdminProd();
		model.addAttribute("pListeAdmin", listeAdminProds);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pKeyWord", new Produit());
		return "listeAdminProds";
	}
	
	@RequestMapping(value="/formulaireAjoutAdmin", method=RequestMethod.GET)
	public ModelAndView formulaireAjoutAdmin() {
		ModelAndView mav=new ModelAndView("formulaireAjoutAdmin", "mAdmin", new Admin());
		mav.addObject("pKeyWord", new Produit());
		mav.addObject("pCatListe", catService.getAllCategory());
		return mav;
	}
	
	@RequestMapping(value="/ajoutAdmin", method=RequestMethod.POST)
	public String soumettreFormulaireAjoutAdmin(ModelMap model, @ModelAttribute("mAdmin") Admin pAdmin) {
		admService.createAdminProd(pAdmin);
		admService.linkAdminRole(pAdmin.getIdAdmin());
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pKeyWord", new Produit());
		List<Admin> listeAdminProds=admService.getAllAdminProd();
		model.addAttribute("pListeAdmin", listeAdminProds);
		return "listeAdminProds";
	}
	
	@RequestMapping(value="/formulaireModifierAdmin", method=RequestMethod.GET)
	public ModelAndView formulaireModifierAdmin(ModelMap model, @RequestParam("idAdmin")long id) {
		Admin ad=admService.getAdminById(id);
		ModelAndView mav=new ModelAndView("formulaireModifierAdmin", "mAdmin2", new Admin());
		model.addAttribute("pAdmin", ad);
		mav.addObject("pKeyWord", new Produit());
		mav.addObject("pCatListe", catService.getAllCategory());
		return mav;
	}
	
	@RequestMapping(value="/modifierAdmin", method=RequestMethod.POST)
	public String modifierAdmin(ModelMap model, @ModelAttribute("mAdmin") Admin pAdmin) {
		admService.updateAdminProd(pAdmin);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		model.addAttribute("pKeyWord", new Produit());
		List<Admin> listeAdminProds=admService.getAllAdminProd();
		model.addAttribute("pListeAdmin", listeAdminProds);
		return "listeAdminProds";
	}
	
	@RequestMapping(value="/supprimerAdmin", method=RequestMethod.GET)
	public ModelAndView supprimerAdmin(ModelMap model, @RequestParam("idAdmin")long id) {
		ModelAndView mav=new ModelAndView("listeAdminProds");
		admService.deleteAdminProd(id);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pKeyWord", new Produit());
		List<Admin> listeAdminProds=admService.getAllAdminProd();
		model.addAttribute("pListeAdmin", listeAdminProds);
		return mav;
	}
	

}