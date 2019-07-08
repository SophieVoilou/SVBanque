package fr.banque.main;
import java.io.Serializable;
//1.3.2 Création de la classe Flux
import java.util.Date;

public abstract class Flux  implements Serializable{
	@Override
	public String toString() {
		return "Flux [Commentaire=" + commentaire + ", Identifiant=" + identifiant + ", Montant=" + montant
				+ ", NumCompteCible=" + numCompteCible + ", Effectue=" + effectue + ", dateFlux=" + dateFlux + "]";
	}

	private String commentaire;
	private int identifiant;
	private double montant;
	private double numCompteCible;
	private boolean effectue;
	Date dateFlux = new Date(); // import java.util.Date



	public Flux(String commentaire, int identifiant, double montant, double numCompteCible, boolean effectue,
			Date dateFlux) {
		super();
		this.commentaire = commentaire;
		this.identifiant = identifiant;
		this.montant = montant;
		this.numCompteCible = numCompteCible;
		this.effectue = effectue;
		this.dateFlux = dateFlux;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public double getNumCompteCible() {
		return numCompteCible;
	}

	public void setNumCompteCible(double numCompteCible) {
		this.numCompteCible = numCompteCible;
	}

	public boolean isEffectue() {
		return effectue;
	}

	public void setEffectue(boolean effectue) {
		this.effectue = effectue;
	}

	public Date getDateFlux() {
		return dateFlux;
	}

	public void setDateFlux(Date dateFlux) {
		this.dateFlux = dateFlux;
	}

}
