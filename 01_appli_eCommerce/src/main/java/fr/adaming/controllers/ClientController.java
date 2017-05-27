package fr.adaming.controllers;

import java.util.Calendar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.LigneCommande;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.IProduitService;

/**
 * Cette classe est le controleur qui gère l'ensemble des pages web accessibles par un client de l'application.
 * Toutes ces pages ont une URL commençant par /site.
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
//	class CarteBancaire
//	{
//		String numero;
//		
//		public CarteBancaire()
//		{
//		}
//		
//		public CarteBancaire(String numero)
//		{
//			this.numero=numero;
//		}
//
//		public String getNumero() {
//			return numero;
//		}
//		
//		public void setNumero(String numero) {
//			this.numero = numero;
//		}
//	}
	
	//Associations
	@Autowired
	private ICategorieService catService;
	@Autowired
	private IProduitService prService;
	@Autowired
	private IClientService cltService;
	@Autowired
	private ICommandeService commandeService;
	@Autowired
	private JavaMailSender mailSender;
	
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
	public ICommandeService getCommandeService() {
		return commandeService;
	}
	public void setCommandeService(ICommandeService commandeService) {
		this.commandeService = commandeService;
	}		
	public JavaMailSender getMailSender() {
		return mailSender;
	}
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
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
		model.addAttribute("pPrixPanier", this.panier.getMontant());
		return "accueil";
	}
	
	@RequestMapping(value="/afficherParCat/{nomCat}", method=RequestMethod.GET)
	public String afficherAccueilCategorie(ModelMap model, @PathVariable("nomCat")String categorie)
	{
		Categorie cat = catService.getCategorieByName(categorie);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProductsByCategory(cat));
		model.addAttribute("pKeyWord", new Produit());
		model.addAttribute("pPrixPanier", this.panier.getMontant());
		return "accueil";
	}
	
	@RequestMapping(value="/afficherParKeyWord", method=RequestMethod.POST)
	public String afficherAccueilMotCle(ModelMap model, @ModelAttribute("pKeyWord")Produit prod)
	{
		String motCle = prod.getDesignation();
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProductsByKeyWord(motCle));
		model.addAttribute("pKeyWord", new Produit());
		model.addAttribute("pPrixPanier", this.panier.getMontant());
		return "accueil";
	}
	
	@RequestMapping(value="/afficherFormConnexion", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireConnexionClient()
	{
		ModelAndView mav = new ModelAndView("formulaire_connexion_client", "mClient", new Client());
		mav.addObject("pKeyWord", new Produit());
		mav.addObject("pPrixPanier", this.panier.getMontant());
		return mav;
	}
	
	@RequestMapping(value="/soumettreFormConnexion", method=RequestMethod.POST)
	public String soumettreFormulaireConnexionClient(ModelMap model, @ModelAttribute("mClient")Client client)
	{
		Client clientRetour = cltService.isExist(client);
		if(clientRetour!=null)
		{
			this.client=clientRetour;
			model.addAttribute("pCatListe", catService.getAllCategory());
			model.addAttribute("pPrListe", prService.getAllProducts());
			model.addAttribute("pKeyWord", new Produit());
			model.addAttribute("pClient", this.client);
			model.addAttribute("pPrixPanier", this.panier.getMontant());
			return "accueil";
		}
		else
		{
			String message="Identifiant ou mot de passe incorrect. Veuillez réessayer ou vous créer un compte si vous n'en avez pas un.";
			model.addAttribute("pKeyWord", new Produit());
			model.addAttribute("pPrixPanier", this.panier.getMontant());
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
		mav.addObject("pPrixPanier", this.panier.getMontant());
		return mav;
	}
	
	@RequestMapping(value="/soumettreFormEdition", method=RequestMethod.POST)
	public String soumettreFormulaireEditionClient(@ModelAttribute("mCLientEdit")Client clientForm, ModelMap model)
	{
		System.out.println("---------Retour du formulaire d'édition : " + clientForm);
		Client clientBdd = cltService.isExist(clientForm);
		if(clientBdd != null && clientForm.getIdClient() == 0)
		{
			Client clientFormRenvoi = new Client();
			if(this.client != null)
			{
				clientFormRenvoi = this.client;
			}
			String message = "Les données rentrées correspondent déjà à un client.";
			model.addAttribute("mCLientEdit", clientFormRenvoi);
			model.addAttribute("pKeyWord", new Produit());
			model.addAttribute("pPrixPanier", this.panier.getMontant());
			model.addAttribute("msgErreur", message);
			return "formulaire_edit_client";
		}
		else
		{
			this.client = cltService.editClient(clientForm);
			model.addAttribute("pCatListe", catService.getAllCategory());
			model.addAttribute("pPrListe", prService.getAllProducts());
			model.addAttribute("pKeyWord", new Produit());
			model.addAttribute("pPrixPanier", this.panier.getMontant());
			model.addAttribute("pClient", this.client);
			return "accueil";
		}	
	}
	
	@RequestMapping(value="/seDeconnecter", method=RequestMethod.GET)
	public String deconnecterClient(ModelMap model)
	{
		this.client = null;
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		model.addAttribute("pKeyWord", new Produit());
		model.addAttribute("pPrixPanier", this.panier.getMontant());
		return "accueil";
	}
	
	@RequestMapping(value="/afficherFicheProd/{idProduit}", method=RequestMethod.GET)
	public String afficherFicheProduit(ModelMap model, @PathVariable("idProduit")int id)
	{
		Produit p = prService.getProduct(id);
		model.addAttribute("pProduit", p);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pKeyWord", new Produit());
		model.addAttribute("pPrixPanier", this.panier.getMontant());
	
		model.addAttribute("mLigneCommande", new LigneCommande());
		return "fiche_produit";
	}
	
	@RequestMapping(value="/ajouterAuPanier/{idProduit}", method=RequestMethod.POST)
	public String ajouterLigneCommandePanier(@ModelAttribute("mLigneCommande")LigneCommande lc, @PathVariable("idProduit")int id, ModelMap model)
	{
		if(lc.getQuantite() <= prService.getProduct(id).getQuantite())
		{
			//Modification de la bdd --> faite à la validation de la commande
			Produit prod = prService.getProduct(id);
//			prod.setQuantite(prod.getQuantite() - lc.getQuantite());
//			prod = prService.updateProduct(prod);
			
			//Création complète de la ligne de commande
			lc.setProduit(prod);
			double lcPrix = lc.getProduit().getPrix()*lc.getQuantite();
			lc.setPrix((double)Math.round(lcPrix*100)/100);
			
			//Ajout de la ligne de commande au panier
			this.panier.getListeLignesCommande().add(lc);
			this.panier.setMontant(this.panier.getMontant()+lc.getPrix());
			
			//Envoi des infos à la page
			model.addAttribute("mPanier", this.panier);
			model.addAttribute("pCatListe", catService.getAllCategory());
			model.addAttribute("pKeyWord", new Produit());
			model.addAttribute("pPrixPanier", this.panier.getMontant());
			return "panier";
		}
		else
		{
			String message = "Désolé, le stock est insuffisant pour ce produit. Il ne reste plus que " + prService.getProduct(id).getQuantite() + " " + prService.getProduct(id).getDesignation() + ".";
			Produit p = prService.getProduct(id);
			model.addAttribute("pProduit", p);
			model.addAttribute("pCatListe", catService.getAllCategory());
			model.addAttribute("pKeyWord", new Produit());
			model.addAttribute("pPrixPanier", this.panier.getMontant());
		
			model.addAttribute("msgErreur", message);
			model.addAttribute("mLigneCommande", new LigneCommande());
			return "fiche_produit";
		}
	}

	@RequestMapping(value="/afficherPanier", method=RequestMethod.GET)
	public String afficherPanier(ModelMap model)
	{
		model.addAttribute("mPanier", this.panier);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pKeyWord", new Produit());
		model.addAttribute("pPrixPanier", this.panier.getMontant());
		return "panier";
	}
	
	@RequestMapping(value="/retirerDuPanier/{indexLigneCommande}")
	public String retirerLigneCommandePanier(ModelMap model, @PathVariable("indexLigneCommande")int indexLc)
	{
		//Modification de la bdd --> faite à la validation de la commande
//		Produit prod = this.panier.getListeLignesCommande().get(indexLc).getProduit();
//		prod.setQuantite(prod.getQuantite() + this.panier.getListeLignesCommande().get(indexLc).getQuantite());
//		prod = prService.updateProduct(prod);
		
		//Mise à jour du panier
		double montant = this.panier.getMontant()-this.panier.getListeLignesCommande().get(indexLc).getPrix();
		this.panier.setMontant((double)Math.round(montant*100)/100);
		this.panier.getListeLignesCommande().remove(indexLc);
		
		//Envoi des infos à la page
		model.addAttribute("mPanier", this.panier);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pKeyWord", new Produit());
		model.addAttribute("pPrixPanier", this.panier.getMontant());
		return "panier";
	}
	
	@RequestMapping(value="/validerPanier", method=RequestMethod.GET)
	public String validerLePanier(ModelMap model)
	{
		//Vérification de la connexion
		if(this.client != null)
		{
			//Envoi des infos à la page
			Client carte = new Client();
			model.addAttribute("pCatListe", catService.getAllCategory());
			model.addAttribute("pKeyWord", new Produit());
			model.addAttribute("pClient", this.client);
			model.addAttribute("pPrixPanier", this.panier.getMontant());
			model.addAttribute("mCarteBancaire", carte);
			return "formulaire_paiement";
		}
		else
		{
			String message = "Vous devez être connecté pour valider le panier.";
			model.addAttribute("mPanier", this.panier);
			model.addAttribute("pCatListe", catService.getAllCategory());
			model.addAttribute("pKeyWord", new Produit());
			model.addAttribute("pPrixPanier", this.panier.getMontant());
			model.addAttribute("msgErreur", message);
			return "panier";
		}
	}
		
	@RequestMapping(value="/validerCommande", method=RequestMethod.POST)
	public String validerLaCommande(@ModelAttribute("mCarteBancaire")Client carte, ModelMap model)
	{
		System.out.println("----------Numéro de carte : " + carte.getNomClient());
		
		//Modification de la base de données
		Commande com = new Commande();
		for(LigneCommande lc : this.panier.getListeLignesCommande())
		{
			Produit prod = lc.getProduit();
			prod.setQuantite(prod.getQuantite() - lc.getQuantite());
			prod = prService.updateProduct(prod);
			
			lc.setCommande(com);
		}
		
		//Enregistrement de la commande
		com.setClient(client);
		com.setListeLigneCommandes(this.panier.getListeLignesCommande());
		com.setDateCommande(Calendar.getInstance().getTime());
		commandeService.createCommand(com);
		
		//Envoi d'un mail de confirmation
		String sujet = "Confirmation de votre commande";
		String texte = "Nous accusons bonne réception de votre commande pour un montant de " + this.panier.getMontant() +
				"euros. Elle sera traitée dans les meilleurs délais. \nMartin Thomas et Dell'aiera Nicolas";
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("dellaiera.nicolas@gmail.com");
		email.setTo(this.client.getEmail());
		email.setSubject(sujet);
		email.setText(texte);
		mailSender.send(email);
		
		//Réinitialisation du panier
		this.panier.getListeLignesCommande().clear();
		this.panier.setMontant(0);
		
		//Envoi des infos à la page
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		model.addAttribute("pKeyWord", new Produit());
		model.addAttribute("pPrixPanier", this.panier.getMontant());
		model.addAttribute("pClient", this.client);
		return "accueil";
	}
	
}
