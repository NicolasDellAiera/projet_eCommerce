package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICommandeDao;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;

@Service("csService")
@Transactional

public class CommandeServiceImpl implements ICommandeService {
	
	@Autowired
	private ICommandeDao csDAO;

	public ICommandeDao getCsDAO() {
		return csDAO;
	}

	public void setCsDAO(ICommandeDao csDAO) {
		this.csDAO = csDAO;
	}

	@Override
	public List<Commande> getAllCommand(Client cl) {
		return csDAO.getAllCommand(cl);
	}

	@Override
	public Commande createCommand(Commande c) {
		return csDAO.createCommand(c);
	}

}