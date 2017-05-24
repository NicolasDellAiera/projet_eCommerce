package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/site")
public class ClientController 
{
	//
	
	@RequestMapping(method=RequestMethod.GET)
	public String afficherAccueil(ModelMap model)
	{
		
		return "accueil";
	}
}
