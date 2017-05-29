package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	/**
	 * Attributs
	 */
	
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

	/**
	 * Associations :
	 * ICategorieService catService
	 * IClientService cltService
	 * ICommandeService commandeService
	 * JavaMailSender mailSender
	 */
	
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
	
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the panier
	 */
	public Panier getPanier() {
		return panier;
	}

	/**
	 * @param panier the panier to set
	 */
	public void setPanier(Panier panier) {
		this.panier = panier;
	}

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
	 * @return the cltService
	 */
	public IClientService getCltService() {
		return cltService;
	}

	/**
	 * @param cltService the cltService to set
	 */
	public void setCltService(IClientService cltService) {
		this.cltService = cltService;
	}

	/**
	 * @return the commandeService
	 */
	public ICommandeService getCommandeService() {
		return commandeService;
	}

	/**
	 * @param commandeService the commandeService to set
	 */
	public void setCommandeService(ICommandeService commandeService) {
		this.commandeService = commandeService;
	}

	/**
	 * @return the mailSender
	 */
	public JavaMailSender getMailSender() {
		return mailSender;
	}

	/**
	 * @param mailSender the mailSender to set
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * Initialisation avec postConstruct
	 */
	
	@PostConstruct
	public void initialiser()
	{
		panier = new Panier();
		client = new Client();
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
		model.addAttribute("pClient", this.client);
		model.addAttribute("pPrixPanier", this.panier.getMontant());
		return "accueil";
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
		model.addAttribute("pClient", this.client);
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
		model.addAttribute("pClient", this.client);
		model.addAttribute("pPrixPanier", this.panier.getMontant());
		return "accueil";
	}
	
	@RequestMapping(value="/afficherFormConnexion", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireConnexionClient()
	{
		ModelAndView mav = new ModelAndView("formulaire_connexion_client", "mClient", new Client());
		mav.addObject("pKeyWord", new Produit());
		mav.addObject("pClient", this.client);
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
			model.addAttribute("pClient", this.client);
			model.addAttribute("pPrixPanier", this.panier.getMontant());
			model.addAttribute("msgErreur", message);
			return "formulaire_connexion_client";
		}
	}
	
	@RequestMapping(value="/afficherFormEdit", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireEditionCLient()
	{
		ModelAndView mav = new ModelAndView("formulaire_edit_client", "mCLientEdit", this.client);
		mav.addObject("pKeyWord", new Produit());
		mav.addObject("pClient", this.client);
		mav.addObject("pPrixPanier", this.panier.getMontant());
		return mav;
	}
	
	@RequestMapping(value="/soumettreFormEdition", method=RequestMethod.POST)
	public String soumettreFormulaireEditionClient(ModelMap model, @Valid @ModelAttribute("mCLientEdit")Client clientForm, BindingResult result)
	{
		if(result.hasErrors())
		{
			model.addAttribute("pKeyWord", new Produit());
			model.addAttribute("pClient", this.client);
			model.addAttribute("pPrixPanier", this.panier.getMontant());
			return "formulaire_edit_client";
		}
		else
		{
			Client clientBdd = cltService.isExist(clientForm);
			if(clientBdd != null && clientForm.getIdClient() == 0)
			{
				String message = "Les données rentrées correspondent déjà à un client.";
				model.addAttribute("mCLientEdit", this.client);
				model.addAttribute("pKeyWord", new Produit());
				model.addAttribute("pClient", this.client);
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
	}
	
	@RequestMapping(value="/seDeconnecter", method=RequestMethod.GET)
	public String deconnecterClient(ModelMap model)
	{
		this.client = new Client();
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pPrListe", prService.getAllProducts());
		model.addAttribute("pClient", this.client);
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
		model.addAttribute("pClient", this.client);
		model.addAttribute("pPrixPanier", this.panier.getMontant());
	
		model.addAttribute("mLigneCommande", new LigneCommande());
		return "fiche_produit";
	}
	
	@RequestMapping(value="/ajouterAuPanier/{idProduit}", method=RequestMethod.POST)
	public String ajouterLigneCommandePanier(ModelMap model, @PathVariable("idProduit")int id, @Valid @ModelAttribute("mLigneCommande")LigneCommande lc, BindingResult result)
	{
		if(result.hasErrors())
		{
			Produit p = prService.getProduct(id);
			model.addAttribute("pProduit", p);
			model.addAttribute("pCatListe", catService.getAllCategory());
			model.addAttribute("pKeyWord", new Produit());
			model.addAttribute("pClient", this.client);
			model.addAttribute("pPrixPanier", this.panier.getMontant());
		
			return "fiche_produit";
		}
		else
		{
			if(lc.getQuantite() <= prService.getProduct(id).getQuantite())
			{
				Produit prod = prService.getProduct(id);
				
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
				model.addAttribute("pClient", this.client);
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
				model.addAttribute("pClient", this.client);
				model.addAttribute("pPrixPanier", this.panier.getMontant());
			
				model.addAttribute("msgErreur", message);
				model.addAttribute("mLigneCommande", new LigneCommande());
				return "fiche_produit";
			}
		}	
	}

	@RequestMapping(value="/afficherPanier", method=RequestMethod.GET)
	public String afficherPanier(ModelMap model)
	{
		model.addAttribute("mPanier", this.panier);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pKeyWord", new Produit());
		model.addAttribute("pClient", this.client);
		model.addAttribute("pPrixPanier", this.panier.getMontant());
		return "panier";
	}
	
	@RequestMapping(value="/retirerDuPanier/{indexLigneCommande}")
	public String retirerLigneCommandePanier(ModelMap model, @PathVariable("indexLigneCommande")int indexLc)
	{		
		//Mise à jour du panier
		double montant = this.panier.getMontant()-this.panier.getListeLignesCommande().get(indexLc).getPrix();
		this.panier.setMontant((double)Math.round(montant*100)/100);
		this.panier.getListeLignesCommande().remove(indexLc);
		
		//Envoi des infos à la page
		model.addAttribute("mPanier", this.panier);
		model.addAttribute("pCatListe", catService.getAllCategory());
		model.addAttribute("pKeyWord", new Produit());
		model.addAttribute("pClient", this.client);
		model.addAttribute("pPrixPanier", this.panier.getMontant());
		return "panier";
	}
	
	@RequestMapping(value="/validerPanier", method=RequestMethod.GET)
	public String validerLePanier(ModelMap model)
	{
		//Vérification de la connexion
		if(this.client.getNomClient() != null)
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
			model.addAttribute("pClient", this.client);
			model.addAttribute("pPrixPanier", this.panier.getMontant());
			model.addAttribute("msgErreur", message);
			return "panier";
		}
	}
		
	@RequestMapping(value="/validerCommande", method=RequestMethod.POST)
	public String validerLaCommande(@ModelAttribute("mCarteBancaire")Client carte, ModelMap model)
	{
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