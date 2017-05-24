package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Categorie;
import fr.adaming.service.ICategorieService;

@Controller
//@RequestMapping("/XXX")

public class CategorieController {
	
	@Autowired
	private ICategorieService catService;

	public ICategorieService getCatService() {
		return catService;
	}

	public void setCatService(ICategorieService catService) {
		this.catService = catService;
	}
	
//	@RequestMapping(value="/XXX", method=RequestMethod.GET)
//	public String afficherCategories(ModelMap model) {
//		List<Categorie> listeCategories=catService.getAllCategory();
//		model.addAttribute("catListe", listeCategories);
//		return "XXX";
//	}

}