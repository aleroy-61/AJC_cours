package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import metier.Departement;
import metier.Employe;

public class TestSerial {

	public static void lireFichierTexte() 
	{
		File f1 = new File("test.txt");

		FileReader fr;
		try {
			fr = new FileReader(f1);
			int c;

			while((c=fr.read())!=-1) 
			{
				System.out.print((char)c);
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}



	}

	public static void ecrireFichierText() 
	{
		File f1 = new File("test.txt");
		FileWriter fw;

		try {
			fw=new FileWriter(f1);

			//Pour concat dans le fichier
			//fw=new FileWriter(f1,true);

			fw.write("Suite du message");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void ecrireFichierObjet() 
	{
		Departement d1 = new Departement (10, "ACCOUNTING", "NEW YORK");
		Departement d2 = new Departement (20, "RESEARCH", "DALLAS");
		Departement d3 = new Departement (30, "SALES", "CHICAGO");
		Departement d4 = new Departement (40, "OPERATIONS", "BOSTON");

		Employe e9=new Employe (7839, "KING", "PRESIDENT", null, "2016-05-01", 5000, null, null);


		File f1 = new File("listeDepartements.txt");
		List<Departement> maListe = new ArrayList();
		maListe.add(d1);
		maListe.add(d2);
		maListe.add(d3);
		maListe.add(d4);
		try {
			FileOutputStream fos = new FileOutputStream(f1);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(maListe);	
			oos.writeObject(e9);	

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public static List<Departement> lireFichierObjet() 
	{
		List<Departement> maListe = new ArrayList();
		Employe e = null;
		File f1 = new File("listeDepartement.txt");

		if(f1.exists()) {
			try {
				FileInputStream fis = new FileInputStream(f1);
				ObjectInputStream ois = new ObjectInputStream(fis);

				maListe=(List<Departement>) ois.readObject();
				e=(Employe) ois.readObject();
				System.out.println(e);

			} catch (IOException | ClassNotFoundException exc) {
				exc.printStackTrace();
			}

		}

		return maListe;

	}


	public static void main(String[] args) {

		ecrireFichierObjet();
		List<Departement> listeDuFichier = lireFichierObjet();

		System.out.println(listeDuFichier);


	}

}
