package fr.banque.main;
import java.io.Serializable;
//1.3.2 Création de la classe Flux
import java.util.Date;

public abstract class Flux  implements Serializable{
    
    protected final String GUI = "\"";
    protected final String TAB = "\t";
    protected final String CRLF = "\r\n";
    
	@Override
	public String toString() {
		return "Flux [Commentaire=" + commentaire + ", Identifiant=" + identifiant + ", Montant=" + montant
				+ ", NumCompteCible=" + numCompteCible + ", Effectue=" + effectue + ", dateFlux=" + dateFlux + "]";
	}

	protected String commentaire;
	protected int identifiant;
	protected double montant;
	protected double numCompteCible;
	protected boolean effectue;
	protected Date dateFlux = new Date(); // import java.util.Date

    public Flux() {    
    }

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
                
        public String toJson(String p_indentation) {
            String jsonObject = "";
            jsonObject += p_indentation + "{";
            // à compléter
            if (this.commentaire != null) { 
                jsonObject += CRLF + p_indentation + TAB + GUI + "commentaire" + GUI + ":" + GUI + this.commentaire + GUI + ",";
            }
            jsonObject += CRLF + p_indentation + "}";
            return jsonObject;
        }

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
                
        public String toXml(String p_indentation) {
            String xmlObject = "";
            xmlObject += p_indentation + "<flux>";
            // à compléter
            if (this.commentaire != null) { 
                xmlObject += CRLF + p_indentation + TAB + "<commentaire>" + this.commentaire + "</commentaire>";
            }
            xmlObject += CRLF + p_indentation + "</flux>";
            return xmlObject;
        }
                
        public void fromXml(String p_xmlObject) {
            String object = p_xmlObject;
            object = object.replaceAll(TAB, "");
            object = object.replaceAll(GUI, "");
            object = object.replaceAll("/", "");
            object = object.replaceAll(">", "<");
            String[] lines = object.split(CRLF);

            for (String line : lines) {
                String[] content = line.split("<");
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
