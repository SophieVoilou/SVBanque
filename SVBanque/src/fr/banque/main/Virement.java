package fr.banque.main;
import java.io.Serializable;
//1.3.3 Création des classes Virement, Credit, Debit
import java.util.Date;

public class Virement extends Flux implements Serializable{

	private double numComEm;

    public Virement() {
    }
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

        @Override
	public void fromJson(String p_jsonObject) {
            String object = p_jsonObject;
            object = object.replaceAll(TAB, "");
            object = object.replaceAll(GUI, "");
            object = object.replaceAll(",", "");
            String[] lines = object.split(CRLF);

            for (String line : lines) {
                if ("{".equals(line)) {

                } else if ("}".equals(line)) {

                } else {
                    String[] content = line.split(":");
                    switch (content[0]) {
                        case "commentaire":
                            this.commentaire = content[1];
                            break;
                        case "identifiant":
                            this.identifiant = Integer.valueOf(content[1]);
                            break;
                        case "montant":
                            this.montant = Double.valueOf(content[1]);
                            break;
                        case "numCompteCible":
                            this.numCompteCible = Double.valueOf(content[1]);
                            break;
                        case "numComEm":
                            this.numComEm = Double.valueOf(content[1]);
                            break;
                        case "effectue":
                            this.effectue = Boolean.valueOf(content[1]);
                            break;
                        case "dateFlux":
                            this.dateFlux = new Date(content[1]); //Need work
                            break;
                        default:
                            break;
                    }
                }
            }
        }

}
