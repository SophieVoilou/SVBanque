package fr.banque.composants;
//1.2.2 Création des classes CompteCourant et CompteEpargne

public class CompteEpargne   extends Compte{

	public CompteEpargne(String libelle, double solde, int numCompte, Client client) {
		super(libelle, solde, numCompte, client);

	}

}
