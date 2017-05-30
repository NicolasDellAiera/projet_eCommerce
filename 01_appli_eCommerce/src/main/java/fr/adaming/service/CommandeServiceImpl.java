package fr.adaming.service;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author INTI-0366
 * 
 * Classe service implémentant l'interface pour les méthodes de les lignes de commandes
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.dao.ICommandeDao;
import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.LigneCommande;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service("csService")
@Transactional

public class CommandeServiceImpl implements ICommandeService {
	
	/**
	 * Insertion de la DAO
	 */
	
	@Autowired
	private ICommandeDao csDAO;
	@Autowired
	private ILigneCommandeDao liDAO;
	@Autowired
	private IClientDao clDAO;

	/**
	 * @return the csDAO
	 */
	public ICommandeDao getCsDAO() {
		return csDAO;
	}

	/**
	 * @param csDAO the csDAO to set
	 */
	public void setCsDAO(ICommandeDao csDAO) {
		this.csDAO = csDAO;
	}
	
	/**
	 * @return the liDAO
	 */
	public ILigneCommandeDao getLiDAO() {
		return liDAO;
	}

	/**
	 * @param liDAO the liDAO to set
	 */
	public void setLiDAO(ILigneCommandeDao liDAO) {
		this.liDAO = liDAO;
	}

	/**
	 * @param model
	 * @return
	 * 
	 * Generation des methodes
	 */

	@Override
	public List<Commande> getAllCommand(Client cl) {
		return csDAO.getAllCommand(cl);
	}

	@Override
	public Commande createCommand(Commande c) {
		return csDAO.createCommand(c);
	}

	@Override
	public void createOnePDF(Commande c) {
		
		Document document=new Document();
		List<LigneCommande> listeDesCommandes=c.getListeLigneCommandes();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\INTI-0368\\Desktop\\facture.pdf"));
			document.open();
			PdfPTable tableTitre = new PdfPTable(1);
			PdfPTable tableInfoClient = new PdfPTable(1);
			PdfPTable tableProduit = new PdfPTable(2);
			PdfPTable tablePrixTot = new PdfPTable(2);
			
			PdfPCell cell1=new PdfPCell(new Phrase("facture ANGULAR COMMERCE"));
			tableTitre.addCell(cell1);
			
			LigneCommande ligne=listeDesCommandes.get(0);
			Client client=ligne.getCommande().getClient();
			tableInfoClient.addCell("Nom : " + client.getNomClient());
			tableInfoClient.addCell("Adresse : " + client.getAdresse());
			tableInfoClient.addCell("Mail : " + client.getEmail());
			tableInfoClient.addCell("Telephone : " + client.getTel());
			
			PdfPCell cell2=new PdfPCell(new Phrase("Produits commandés :"));
			tableProduit.addCell(cell2);
			tableProduit.addCell(" ");
			
			int i=0;
			for (LigneCommande L1:listeDesCommandes) {
				LigneCommande ligneCommande=listeDesCommandes.get(i);
				Image image = Image.getInstance(ligneCommande.getProduit().getPhoto());
				image.scaleAbsolute(image.getScaledHeight()/10, image.getScaledHeight()/10);
				tableProduit.addCell(image);
				PdfPTable table = new PdfPTable(1);
				table.addCell("Produit: " + ligneCommande.getProduit().getDesignation());
				table.addCell("Quantite : " + ligneCommande.getQuantite());
				table.addCell("Prix unitaire : " + ligneCommande.getProduit().getPrix());
				table.addCell("Prix totale : " + ligneCommande.getPrix());
				tableProduit.addCell(table);
				i++;
			}
			
			PdfPCell cell3=new PdfPCell(new Phrase("Prix totale :"));
			tablePrixTot.addCell(cell3);
			tablePrixTot.addCell(" ");
			
			int j=0;
			double total=0.0;
			for (LigneCommande L2:listeDesCommandes) {
				LigneCommande ligneCommande=listeDesCommandes.get(j);
				total=total+ligneCommande.getPrix();
				j++;
			}
			
			tablePrixTot.addCell("Total : ");
			tablePrixTot.addCell(" " + total + " ");
			
			document.add(tableTitre);
			document.add(tableInfoClient);
			document.add(tableProduit);
			document.add(tablePrixTot);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		document.close();
	}

}