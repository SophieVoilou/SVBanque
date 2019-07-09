package fr.banque.main;
import java.io.Serializable;
//1.3.3 Création des classes Virement, Credit, Debit
import java.util.Date;

public class Debit extends Flux implements Serializable{

    public Debit() {   
    }
    
	public Debit(String commentaire, int identifiant, double montant, double numCompteCible, boolean effectue,
			Date dateFlux) {
		super(commentaire, identifiant, montant, numCompteCible, effectue, dateFlux);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Debit [dateFlux=" + dateFlux + ", Commentaire()=" + getCommentaire() + ", Identifiant()="
				+ getIdentifiant() + ", Montant()=" + getMontant() + ", NumCompteCible()=" + getNumCompteCible()
				+ ", isEffectue()=" + isEffectue() + ", DateFlux()=" + getDateFlux() + "]";
	}

}
