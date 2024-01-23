package com.sip.ams.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Banque;

@Controller // Annotation pour rendre la classe comme un controlleur
@RequestMapping("/banques")
public class BanqueController { //un controlleur
	
	static List<Banque> banques = new ArrayList<>();
	
	//bloc static s'exécute lors de l'invocation de la classe BanqueController
	static {
		Banque b1 = new Banque("Boursorama",100000,"Bordeaux, France");
		Banque b2 = new Banque("Nickel",50000,"Nantes, France");
		Banque b3 = new Banque("BNP",180000,"Paris, France");
		
		banques.add(b1);
		banques.add(b2);
		banques.add(b3);
	}
	
	@RequestMapping("/hello")
	@ResponseBody // => retourner le result entre les "" sur le navigateur
	public String welcome()  // une action
	{
		//return "Welcome GK";
		//System.out.println("Welcome GK sur la console");
		return "<h1>Welcome GK</h1>";
	}
	
	@RequestMapping("/info")
	@ResponseBody
	public String info()
	{
		return "<h2 align=center>Une formation Spring à GK</h2>";
	}
	
	@RequestMapping("/details")  //1
	//@ResponseBody
	public String detailsBanque(Model model)
	{
		
		//return "<h3 align=center>"+banque.toString()+"</h3>";
		String centre = "Global Knowledge";
		model.addAttribute("centreJava", centre);
		
		String formateur = "Mohamed Amine MEZGHICH";
		
		model.addAttribute("formateur", formateur);
		Banque banque = new Banque("Boursorama",100000,"Paris, France");
		model.addAttribute("banque", banque);
		
		return "banque/detailsBanque";  //cette action retourne une View situé sous templates/banque/detailsBanque.html	
	}
	
	@RequestMapping("/stagiaires")
	public String listeStagiaires(Model model)
	{
		String noms[] = {"Fatima","Teddy","Jocelyn","Ahmed","Anne","Afef","Benoît","Pierre","Abdelleh","Ismail","Ibtissem","Rahma","Ayda","Hu","Andrei"}; 
		model.addAttribute("noms", noms);
		return "banque/stagiaires";
	}
	
	@RequestMapping("/list")
	public String listeBanques(Model model)
	{
		model.addAttribute("banques", banques);
		return "banque/banques";
	}
	
	@GetMapping("/add") // pour les balises <a>
	public String formBanque()
	{
		return "banque/formBanque.html";
	}
	
	@PostMapping("/add")  // pour les formulaires en mode post
	//@ResponseBody
	public String saveBanque(
			@RequestParam("nomBanque")String nomB, 
			@RequestParam("capitalBanque")double capB,
			@RequestParam("adresseBanque")String adrB)
	{
		
		Banque banque = new Banque(nomB,capB,adrB);
		banques.add(banque);
		return "redirect:banques"; // ici on met la route de l'action pour faire une redirection
	}

	@GetMapping("/deleteBanque/{nomBanque}")
	//@ResponseBody
	public String deleteBanque(@PathVariable("nomBanque") String nomBanque)
	{
		Banque targetBanque=null;
		for(Banque banque : banques)
		{
			if (banque.getNom().equals(nomBanque))
			{
				targetBanque = banque;
				
			}
		}
		banques.remove(targetBanque);
		return "redirect:../banques";
	}
	
	
	@GetMapping("/updateBanque/{nomBanque}")
	//@ResponseBody
	public String updateBanque(@PathVariable("nomBanque") String nomBanque, Model model)
	{
		Banque targetBanque=null;
		for(Banque banque : banques)
		{
			if (banque.getNom().equals(nomBanque))
			{
				targetBanque = banque;
				
			}
		}
		model.addAttribute("nomBanque", targetBanque.getNom());
		model.addAttribute("soldeBanque", targetBanque.getSolde());
		model.addAttribute("adresseBanque", targetBanque.getAdresse());
		return "banque/editBanque";
	}
	
	@PostMapping("/updateBanque")
	//@ResponseBody
	public String saveBanqueAfterUpdate(
			@RequestParam("nomBanque")String nomB, 
			@RequestParam("capitalBanque")double capB,
			@RequestParam("adresseBanque")String adrB
			)
	{
		Banque targetBanque=null;
		for(Banque banque : banques)
		{
			if (banque.getNom().equals(nomB))
			{
				targetBanque = banque;
				
			}
		}
		targetBanque.setNom(nomB);
		targetBanque.setSolde(capB);
		targetBanque.setAdresse(adrB);
		
		return "redirect:list";
	}



}
