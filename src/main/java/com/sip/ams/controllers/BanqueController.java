package com.sip.ams.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Annotation pour rendre la classe comme un controlleur
public class BanqueController { //un controlleur
	
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


}
