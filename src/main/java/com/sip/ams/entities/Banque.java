package com.sip.ams.entities;

public class Banque {
	private String nom;
	private double solde;
	private String adresse;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Banque(String nom, double solde, String adresse) {
		super();
		this.nom = nom;
		this.solde = solde;
		this.adresse = adresse;
	}
	public Banque() {
		
	}
	@Override
	public String toString() {
		return "Banque [nom=" + nom + ", solde=" + solde + ", adresse=" + adresse + "]";
	}

}
