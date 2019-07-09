package fr.banque.main;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import fr.banque.composants.Client;
import fr.banque.composants.Compte;
import fr.banque.composants.CompteCourant;
import fr.banque.composants.CompteEpargne;

public class Main {
	// 1.1.2 Création d’un classe main pour les tests
	public static void main(String[] args) {
		ArrayList<Client> collectionClient = new ArrayList<>();
		ArrayList<Compte> collectionCompte = new ArrayList<>();
		Hashtable tableID = new Hashtable();
		ArrayList<Flux> tableFlux = new ArrayList<>();

		ajouterClient(3, collectionClient);
		afficherClient(collectionClient);
		ajouterCompte(collectionCompte, collectionClient);
		afficherCompte(collectionCompte);
		ajouterID(collectionCompte, tableID);
		afficherTableID(tableID);
		ajouterFlux(tableFlux);
		afficherFlux(tableFlux);
		

		mouvementFlux(tableFlux, collectionCompte);
		exportJson(tableFlux);
	}

	public static void ajouterClient(int x, ArrayList<Client> collectionClient) {
		for (int i = 0; i < x; i++) {
			String nomClient = "nom" + String.valueOf(i + 1);
			String prenomClient = "prenom" + String.valueOf(i + 1);
			Client client = new Client(nomClient, prenomClient);
			collectionClient.add(client);
		}
	}

	public static void afficherClient(ArrayList<Client> collectionClient) {
		String str;
		for (Client client : collectionClient) {

			str = client.toString();
			System.out.println(" Affichage des Clients");
			System.out.println("                                                   ");
			System.out.println(str);
			System.out.println("                                                   ");
		}
	}

	// 1.2.3 Création du tableau des comptes
	public static void ajouterCompte(ArrayList<Compte> collectionCompte, ArrayList<Client> collectionClient) {

		// Boucle sur les clients

		for (Client client : collectionClient) {

			CompteCourant compteCourant = new CompteCourant("compte Courant", 0, 0, client);// les info dont solde = 0et
																							// client = client)

			CompteEpargne compteEpargne = new CompteEpargne("compte Epargne", 0, 0, client);// les info dont solde = 0et
																							// client = client)

			collectionCompte.add(compteCourant);

			collectionCompte.add(compteEpargne);

		}

	}

	public static void afficherCompte(ArrayList<Compte> collectionCompte) {
		String str;
		for (Compte compte : collectionCompte) {

			str = compte.toString();
			System.out.println("                                                   ");
			System.out.println(" Affichage des comptes ");
			System.out.println(str);
			System.out.println("                                                   ");
		}
	}

	// 1.3.1 Adaptation du tableau des comptes
	@SuppressWarnings("null")
	public static void ajouterID(ArrayList<Compte> collectionCompte, Hashtable<Integer, Compte> tableID) {
		// Boucle sur les clients

		for (Compte compte : collectionCompte) {

			tableID.put(compte.getNumCompte(), compte);

		}

	}

	public static void afficherTableID(Hashtable tableID) {
		Enumeration e = tableID.elements();
		Enumeration k = tableID.keys();
		while (e.hasMoreElements())
			System.out.println("Affichage de la table des identifiants");
			System.out.println("                                                   ");
			System.out.println("Identifiant Compte" + k.nextElement() + ":" + e.nextElement());
		System.out.println("                                                   ");

	}

	// 1.3.4 Création du tableau des flux
	public static ArrayList<Flux> ajouterFlux(ArrayList<Flux> tableFlux) {

		Debit debit = new Debit(null, 1, 50, 1, false, null);
		Credit credit1 = new Credit(null, 1, 100.50, 1, false, null);
		Credit credit2 = new Credit(null, 3, 100.50, 3, false, null);
		Credit credit3 = new Credit(null, 5, 100.50, 5, false, null);
		Credit credit4 = new Credit(null, 2, 1500, 2, false, null);
		Credit credit5 = new Credit(null, 4, 1500, 4, false, null);
		Credit credit6 = new Credit(null, 6, 1500, 6, false, null);
		Virement virement = new Virement(null, 1, 50, 1, false, null, 2);

		tableFlux.add(debit);
		tableFlux.add(credit1);
		tableFlux.add(credit2);
		tableFlux.add(credit3);
		tableFlux.add(credit4);
		tableFlux.add(credit5);
		tableFlux.add(credit6);
		tableFlux.add(virement);


		return tableFlux;

	}

	public static void afficherFlux(ArrayList<Flux> tableFlux) {
		String str = null;
		for (Flux flux : tableFlux) {

			str = flux.toString();
			System.out.println("Affichage des Flux ");
			System.out.println("                                                   ");
			System.out.println(str);
			System.out.println("                                                   ");
		}

	}

	public static void mouvementFlux(ArrayList<Flux> tableFlux, ArrayList<Compte> collectionCompte) {
		for (Flux flux : tableFlux) {
			if (flux instanceof Debit) {
				for (Compte compte : collectionCompte) {

					if (flux.getNumCompteCible() == compte.getNumCompte()) {
						compte.setSolde(-1 * flux.getMontant());
					}
				}
			}

			else if (flux instanceof Credit) {
				for (Compte compte : collectionCompte) {
					if (flux.getNumCompteCible() == compte.getNumCompte()) {
						compte.setSolde(flux.getMontant());
					}
				}
			}

			else if (flux instanceof Virement) {
				Virement virement = (Virement) flux;
				for (Compte compte : collectionCompte) {
					if (virement.getNumComEm() == compte.getNumCompte()) {
						compte.setSolde(-1 * virement.getMontant());
					}
					if (virement.getNumCompteCible() == compte.getNumCompte()) {
						compte.setSolde(virement.getMontant());
					}

				}

			}
		}
	}


	public  static void exportJson (ArrayList<Flux> tableFlux) {
		JSONObject obj = new JSONObject();
		obj.put("name", "Max");
	    JSONArray list = new JSONArray(); 
	    list.add("oo");
	    JSONArray tFlux = new JSONArray();
	    for (Flux flux : tableFlux)
	    {
	    	tFlux.add(flux.getCommentaire().toString());
	    }
	    
	    obj.put("list", list);
	    obj.put("Table de flux", tFlux);
	   try (FileWriter file = new FileWriter("flux.json")){
		   file.write(obj.toString());
		   file.flush();
	   }
	   catch (IOException e) {
		   e.printStackTrace();
	   }
	   System.out.println("Fichier en .JSON");
	   System.out.println(obj);
	 
	       
	       
	}
}
