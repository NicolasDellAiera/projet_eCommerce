package fr.adaming.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.LigneCommande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IProduitService;

/**
 * Cette classe est le controleur du client
 * @author INTI-0366
 *
 */

@Controller
@RequestMapping("/site")
public class ClientController 
{
	//Attributes
	private Client client;
	private Panier panier;
	
	//Associations
	@Autowired
	private ICategorieService catService;
	@Autowired
	private IProduitService prService;
	@Autowired
	private IClientService cltService;
	
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
	public IClientService getCltService() {
		return cltService;
	}
	public void setCltService(IClientService cltService) {
		this.cltService = cltService;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
	//Initialisation
	@PostConstruct
	public void initialiser()
	{
		panier = new Panier();
	}
	
	//Methods
	@RequestMapping(method=RequestMethod.GET)
	public String afficherAccueil(ModelMap model) 
	{
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		model.addAttribute("pKeyWord", new Produit());
		model.addAttribute("pClient", this.client);
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
	
	@RequestMapping(value="/afficherFormConnexion", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireConnexionClient()
	{
		ModelAndView mav = new ModelAndView("formulaire_connexion_client", "mClient", new Client());
		mav.addObject("pKeyWord", new Produit());
		return mav;
	}
	
	@RequestMapping(value="/soumettreFormConnexion", method=RequestMethod.POST)
	public String soumettreFormulaireConnexionClient(ModelMap model, @ModelAttribute("mClient")Client client)
	{
		Client clientRetour = cltService.isExist(client);
		System.out.println("------Retour de la connexion : " + client);
		System.out.println("------Retour de la base données : " + clientRetour);
		if(clientRetour!=null)
		{
			this.client=clientRetour;
			model.addAttribute("pCatListe", catService.getAllCategory());
			model.addAttribute("pPrListe", prService.getAllProducts());
			model.addAttribute("pKeyWord", new Produit());
			model.addAttribute("pClient", this.client);
			return "accueil";
		}
		else
		{
			String message="Identifiant ou mot de passe incorrect. Veuillez réessayer ou vous créer un compte si vous n'en avez pas un.";
			model.addAttribute("pKeyWord", new Produit());
			model.addAttribute("msgErreur", message);
			return "formulaire_connexion_client";
		}
	}
	
	@RequestMapping(value="/afficherFormEdit", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireEditionCLient()
	{
		Client clientForm = new Client();
		System.out.println("---------Client du controleur : "+this.client);
		if(this.client != null)
		{
			clientForm = this.client;
		}
		ModelAndView mav = new ModelAndView("formulaire_edit_client", "mCLientEdit", clientForm);
		mav.addObject("pKeyWord", new Produit());
		return mav;
	}
	
	@RequestMapping(value="/soumettreFormEdition", method=RequestMethod.POST)
	public String soumettreFormulaireEditionClient(@ModelAttribute("mCLientEdit")Client clientForm, ModelMap model)
	{
		System.out.println("---------Retour du formulaire d'édition : " + clientForm);
		this.client = cltService.editClient(clientForm);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		model.addAttribute("pKeyWord", new Produit());
		model.addAttribute("pClient", this.client);
		return "accueil";
	}
	
	@RequestMapping(value="/seDeconnecter", method=RequestMethod.GET)
	public String deconnecterClient(ModelMap model)
	{
		this.client = null;
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		model.addAttribute("pKeyWord", new Produit());
		return "accueil";
	}
	
	@RequestMapping(value="/ajouterAuPanier/{idProduit}", method=RequestMethod.POST)
	public String ajouterLigneCommandePanier(@ModelAttribute("mLigneCommande")LigneCommande lc,  @PathVariable("idProduit")int id)
	{
		lc.setProduit(prService.getProduct(id));
		lc.setPrix(lc.getProduit().getPrix()*lc.getQuantite());
		this.panier.getListeLignesCommande().add(lc);
		System.out.println("-------Ligne commande : " + lc);
		return "panier";
	}
}
