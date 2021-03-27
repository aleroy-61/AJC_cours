package test;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dao.DAOCompte;
import dao.DAOPatient;
import dao.DAOVisite;
import metier.Compte;
import metier.Medecin;
import metier.Patient;
import metier.Visite;

public class Test {


	public static String saisieString(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextLine();
	}

	public static double saisieDouble(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextDouble();
	}

	public static int saisieInt(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextInt();
	}
	static DAOCompte daoCompte= new DAOCompte();
	static DAOPatient daoPatient= new DAOPatient();
	static DAOVisite daoVisite= new DAOVisite();
	static LinkedList<Patient> fileAttente = new LinkedList();
	static Compte compteConnected;

	private static void menuPrincipal() {

		compteConnected = null;
		System.out.println("Welcome, merci de faire un choix :");
		System.out.println("1 - Se connecter en tant que médecin");
		System.out.println("2 - Se connecter en tant que secrétaire");
		System.out.println("3 - Fermer l'appli");
		int choix = saisieInt("");

		switch(choix) 
		{
		case 1 : seConnecterMedecin();break;
		case 2 : seConnecterSecretaire();break;
		case 3 : System.exit(0);break;
		default : System.out.println("Choix impossible !\n");
		}

		menuPrincipal();

	}

	private static void seConnecterSecretaire() {

		System.out.println("Menu secretaire, merci de faire un choix :");
		System.out.println("1 - Ajouter un patient à la file d'attente");
		System.out.println("2 - Afficher l'état de la file d'attente");
		System.out.println("3 - Partir en pause");
		System.out.println("4 - Se deconnecter");
		int choix = saisieInt("");

		switch(choix) 
		{
		case 1 : ajoutPatient();break;
		case 2 : listePatient();break;
		case 3 : pause();break;
		case 4 : menuPrincipal();
		default : System.out.println("Choix impossible !\n");
		}

		menuPrincipal();

	}


	private static void pause() {


	}

	private static void listePatient() {


		for(Patient p : fileAttente)
		{
			System.out.println(fileAttente);

		}

	}

	private static void ajoutPatient() {

		int id = saisieInt("Saisir id patient");
		Patient p = daoPatient.findById(id);
		if (p==null) {


			String nom=saisieString("Saisir nom patient");
			String prenom=saisieString("Saisir prenom patient");

			p = new Patient(id,nom,prenom);
			daoPatient.insert(p);
		}
		fileAttente.add(p);
	}

	private static void seConnecterMedecin() {

		compteConnected = new Medecin(1, "", "");
		System.out.println("Menu medecin, merci de faire un choix :"); // ajouter compteconnected salle
		System.out.println("1 - Visualiser le liste d'attente et le prochain patient");
		System.out.println("2 - Appel du patient suivant");
		System.out.println("3 - Sauvegarder la liste de mes visites");
		System.out.println("4 - Se deconnecter");
		int choix = saisieInt("");

		switch(choix) 
		{
		case 1 : listePatient();break;
		case 2 : appelPatient();break;
		case 3 : sauvegardeVisites();break;
		case 4 : menuPrincipal();
		default : System.out.println("Choix impossible !\n");
		}

		menuPrincipal();

	}

	private static void sauvegardeVisites() {

		for (Visite v : ((Medecin)compteConnected).getVisites()) {
			daoVisite.insert(v);
		} ((Medecin) compteConnected).getVisites().clear();

	}

	private static void  appelPatient() {
		System.out.println("Fin de la consultation");
		System.out.println("Patient suivant");


		Patient p =fileAttente.poll(); //pollFirst pareil
		Visite visite= new Visite (0, p, (Medecin) compteConnected, 20, ((Medecin) compteConnected).getSalle());

	 // ajouter compteConnected.GetVisite.add(visite)
		// Si taille ==10 lancer la sauvegardeVisite() 
		



	}
}
