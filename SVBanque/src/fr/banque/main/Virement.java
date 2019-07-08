package fr.banque.main;
import java.io.Serializable;
//1.3.3 Création des classes Virement, Credit, Debit
import java.util.Date;

public class Virement extends Flux implements Serializable{

	private double numComEm;

	public Virement(String commentaire, int identifiant, double montant, double numCompteCible, boolean effectue,
			Date dateFlux, double numComEm) {
		super(commentaire, identifiant, montant, numCompteCible, effectue, dateFlux);
		numComEm = numComEm;
	}

	@Override
	public String toString() {
		return "Virement [Numéro de Compte Emméteur =" + numComEm + ", dateFlux=" + dateFlux 
				+ ", Commentaire()=" + getCommentaire() + ", Identifiant()=" + getIdentifiant()
				+ ", Montant()=" + getMontant() + ", NumCompteCible()=" + getNumCompteCible() + ", Effectue()="
				+ isEffectue() + ", DateFlux()=" + getDateFlux() ;
	}

	public double getNumComEm() {
		return numComEm;
	}

	public void setNumComEm(double numComEm) {
		this.numComEm = numComEm;
	}

	
	

}
