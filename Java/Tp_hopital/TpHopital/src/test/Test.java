package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dao.DAOCompte;
import dao.DAOPatient;
import dao.DAOVisite;
import metier.Compte;
import metier.Medecin;
import metier.Patient;
import metier.Secretaire;
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
	static Compte compteConnected;
	static LinkedList<Patient> fileAttente=new LinkedList();

	private static void menuPrincipal() {

		compteConnected = null;
		System.out.println("Welcome, merci de faire un choix :");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Fermer l'appli");
		int choix = saisieInt("");

		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : System.exit(0);break;
		default : System.out.println("Choix impossible !\n");
		}

		menuPrincipal();

	}

	
	private static void seConnecter() {
		String login=saisieString("Saisir login ");
		String password=saisieString("Saisir password ");
		
		DAOCompte daoCompte=new DAOCompte();
		compteConnected=daoCompte.checkConnect(login, password);
		
		if(compteConnected instanceof Medecin) {
			int salle=saisieInt("Saisir une salle, (1 ou 2) : ");
			((Medecin) compteConnected).setSalle(salle);
			seConnecterMedecin();
			
		}
		else if(compteConnected instanceof Secretaire)
		{ rechargerListe();
		
			seConnecterSecretaire();
		}
		else { System.out.println("Identifiant invalide");
			menuPrincipal();
		}
		
	}

	private static void rechargerListe() {
		File f1 = new File("fileAttente.txt");

		if(f1.exists()) {
			try {
				FileInputStream fis = new FileInputStream(f1);
				ObjectInputStream ois = new ObjectInputStream(fis);

				fileAttente=(LinkedList<Patient>) ois.readObject();
				ois.close();
				fis.close();
				
				FileOutputStream fos = new FileOutputStream(f1);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(new LinkedList<Patient>());	
				
			} catch (IOException | ClassNotFoundException exc) {
				exc.printStackTrace();
			}
			  
		}
		
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

		seConnecterSecretaire();

	}


	private static void pause() {
		
		File f1 = new File("fileAttente.txt");
	
		try {
			FileOutputStream fos = new FileOutputStream(f1);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(fileAttente);	
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		compteConnected=null;
		fileAttente.clear();
		
		menuPrincipal();
		
	}

	private static void listePatient() {
		
		
		for(Patient p : fileAttente)
		{
			System.out.println(p);
		}

	}

	private static void ajoutPatient() {

		int id = saisieInt("Saisir id patient");
		Patient p=daoPatient.findById(id);
		if(p==null) {
		
		String nom=saisieString("Saisir nom patient");
		String prenom=saisieString("Saisir prenom patient");

		p = new Patient(id,nom,prenom);
		daoPatient.insert(p);}
		
		fileAttente.add(p);
		

	}

	private static void seConnecterMedecin() {
		System.out.println("Menu medecin, merci de faire un choix :");
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

		seConnecterMedecin();

	}

	private static void sauvegardeVisites() {
		
		for(Visite v:((Medecin) compteConnected).getVisites()) {
		daoVisite.insert(v);

		}
		
		((Medecin) compteConnected).getVisites().clear();
	}

	private static void appelPatient() {
		System.out.println("Fin de la consultation");
		System.out.println("Patient suivant");
	
		Patient p=fileAttente.poll();		
		Visite visite =new Visite(0, p, (Medecin) compteConnected, 20, ((Medecin) compteConnected).getSalle());
		
		((Medecin) compteConnected).getVisites().add(visite);
		List <Visite> visites=((Medecin) compteConnected).getVisites();
		
		if(visites.size()==2) { 
			sauvegardeVisites();
			}
				
		
}
	
	public static void main(String[] args) {
		menuPrincipal();
	}
}
