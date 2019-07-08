package fr.banque.composants;

public class Client {
	// 1.1.1 Création de la classe client
	private String nom;
	private String prenom;
	private int numClient;
	private static int ID = 1;

	public Client(String nom, String prenom) {

		this.nom = nom;
		this.prenom = prenom;
		this.numClient = ID;
		ID++;
	}

	public int getnumClient() {
		return numClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", numClient=" + numClient + "]";
	}

}
