package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Value;

import fr.adaming.entities.Categorie;
import fr.adaming.service.ICategorieService;

//@Controller
//@RequestMapping("/XXX")

public class CategorieController {
	
//	@RequestMapping(value="/XXX", method=RequestMethod.GET)
//	public ModelAndView recupererCategorie() {
//		return new ModelAndView("XXX", "categorie", new Categorie());
//	}
//	
//	@RequestMapping(value="/XXX", method=RequestMethod.POST)
//	public String afficherProduitsParCategorie(ModelMap model, @ModelAttribute("categorie") Categorie categorie) {
//		
//	}

}