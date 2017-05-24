package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Client;

@Service("clService")
@Transactional

public class ClientServiceImpl implements IClientService {
	
	@Autowired
	private IClientDao clDAO;

	public IClientDao getClDAO() {
		return clDAO;
	}

	public void setClDAO(IClientDao clDAO) {
		this.clDAO = clDAO;
	}

	@Override
	public Client isExist(Client c) {
		return clDAO.isExist(c);
	}

}
