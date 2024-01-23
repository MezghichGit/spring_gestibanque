package com.sip.ams.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sip.ams.entities.CompteBancaire;

@Controller
@RequestMapping("/comptes")
public class CompteBancaireController {
	
	static List<CompteBancaire> cbs = new ArrayList<>();
	static int nbc=0;
	
	//bloc static s'exécute lors de l'invocation de la classe BanqueController
	static {
		
		nbc++;
		CompteBancaire cb1 = new CompteBancaire(nbc,"Amine MEZGHICH",100000,LocalDate.of(2020,10,2),100);
		nbc++;
		CompteBancaire cb2 = new CompteBancaire(nbc,"Mohamed MEZGHICH",120000,LocalDate.of(2020,12,23),100);
		
		cbs.add(cb1);
		cbs.add(cb2);

	}
	
	
	@RequestMapping("/list")
	public String listeComptes(Model model)
	{
		model.addAttribute("cbs",cbs);
		return "compte/listComptes";
	}
	
	
	@GetMapping("/add")
	public String formCompte()
	{
		return "compte/addCompte";
	}
	
	@PostMapping("/add")
	public String savaCompte(
					@RequestParam("proprietaire")String proprietaire, 
					@RequestParam("solde")double solde,
					@RequestParam("dateCreation")LocalDate dateCreation,
					@RequestParam("numBanque") int numBanque)
	{
		nbc++;
		CompteBancaire cb = new CompteBancaire(nbc,proprietaire,solde,dateCreation,numBanque);
		cbs.add(cb);
		return "redirect:list";
	}

}
