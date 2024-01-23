package com.sip.ams.entities;

import java.time.LocalDate;

public class CompteBancaire {
	private int numCompte;
	private String proprietaire;
	private double solde;
	private LocalDate dateCreation;
	private int idBanque;

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public double getSolde() {
		return solde;
	}

	
	
	public void setSolde(double solde) {
		this.solde = solde;
		
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public int getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(int idBanque) {
		this.idBanque = idBanque;
	}

	@Override
	public String toString() {
		return "CompteBanquaire [numCompte=" + numCompte + ", proprietaire=" + proprietaire.toUpperCase() + ", solde="
				+ solde + ", dateCreation=" + dateCreation + ", idBanque=" + idBanque + "]";
	}

	public CompteBancaire() {

		
		
	}

	public CompteBancaire(int numCompte, String proprietaire, double solde, LocalDate dateCreation, int idBanque) {

		this.numCompte = numCompte;
		this.proprietaire = proprietaire;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.idBanque = idBanque;

		

	}

	

}
