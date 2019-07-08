package fr.banque.composants;

import java.util.ArrayList;

import fr.banque.main.Credit;
import fr.banque.main.Debit;
import fr.banque.main.Flux;
import fr.banque.main.Virement;

//1.2.1 Création de la classe Compte
public abstract class Compte {
	protected String libelle;
	protected double solde;
	protected int numCompte;
	protected Client client;
	protected static int iD = 1;

	public Compte(String libelle, double solde, int numCompte, Client client) {
		super();
		this.libelle = libelle;
		this.solde = solde;
		numCompte = iD;
		iD++;
		this.client = client;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double montant) {

		this.solde += montant;

		}

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static int getID() {
		return iD;
	}

	public static void setID(int iD) {
		iD = iD;
	}

	@Override
	public String toString() {
		return "Compte [Libelle=" + libelle + ", Solde=" + solde + ", NumCompte=" + numCompte + ", client=" + client
				+ "]";
	}

}
