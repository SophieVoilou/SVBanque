package fr.banque.composants;

public class Client {
	// 1.1.1 Création de la classe client
	private String nom;
	private String prenom;
	private  static int numClient;
	
	public Client(String nom, String prenom, int numClient) {
 
		this.nom = nom;
		this.prenom = prenom;
		Client.numClient = numClient;
	}
	 private  static Object key =  new Object() ;

	    public  void numClient() {
	       synchronized(key) {
	         numClient++ ;
	      }
	   }

	    public  static  int getnumClient() {
	       return numClient ;
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
