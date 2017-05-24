package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.entities.LigneCommande;

@Service("lcService")
@Transactional

public class LigneCommandeServiceImpl implements ILigneCommandeService {
	
	@Autowired
	private ILigneCommandeDao lcDAO;

	public ILigneCommandeDao getLcDAO() {
		return lcDAO;
	}

	public void setLcDAO(ILigneCommandeDao lcDAO) {
		this.lcDAO = lcDAO;
	}

	@Override
	public List<LigneCommande> getAllCommandLine() {
		return lcDAO.getAllCommandLine();
	}

	@Override
	public LigneCommande getCommandLineById(int id) {
		return lcDAO.getCommandLineById(id);
	}

	@Override
	public LigneCommande createCommandLine(LigneCommande l) {
		return lcDAO.createCommandLine(l);
	}

	@Override
	public LigneCommande updateCommandLine(LigneCommande l) {
		return lcDAO.updateCommandLine(l);
	}

	@Override
	public int deleteCommandLine(int id) {
		lcDAO.deleteCommandLine(id);
		return 0;
	}

}