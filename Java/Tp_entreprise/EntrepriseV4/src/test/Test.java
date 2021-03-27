package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import metier.Admin;
import metier.Compte;
import metier.Departement;
import metier.Employe;

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

	static List<Employe> entreprise=new ArrayList();
	static List<Departement> departements=new ArrayList();
	static Compte compteConnected;
	
	public static void initEmp() 
	{
		Departement d1 = new Departement (10, "ACCOUNTING", "NEW YORK");
		Departement d2 = new Departement (20, "RESEARCH", "DALLAS");
		Departement d3 = new Departement (30, "SALES", "CHICAGO");
		Departement d4 = new Departement (40, "OPERATIONS", "BOSTON");
		departements.add(d1);
		departements.add(d2);
		departements.add(d3);
		departements.add(d4);
		
		Employe e9=new Employe (7839, "KING", "PRESIDENT", null, "2016-05-01", 5000, null, d1);
		Employe e6=new Employe (7698, "BLAKE", "MANAGER", e9, "2017-09-20", 2850, null, d3);
		
		
		Employe e4=new Employe (7566, "JONES", "MANAGER", e9, "2017-09-07", 2975, null, d2);
		Employe e5=new Employe (7654, "MARTIN", "SALESMAN", e6, "2018-07-18", 1250, 1400.0, d3);
		
		
		Employe e2=new Employe (7499, "ALLEN", "SALESMAN", e6, "2018-06-13", 1600, 300.0, d3);
		Employe e3=new Employe (7521, "WARD", "SALESMAN", e6, "2018-07-18", 1250, 500.0, d3);
		
		
		Employe e7=new Employe (7782, "CLARK", "MANAGER", e9, "2017-10-30", 2450, null, d1);
		Employe e8=new Employe (7788, "SCOTT", "ANALYST", e4, "2018-06-05", 3000, null, d2);
		
		Employe e10=new Employe (7844, "TURNER", "SALESMAN", e6, "2018-06-23", 1500.0, 0.0, d3);
		Employe e11=new Employe (7876, "ADAMS", "CLERK", e8, "2018-05-04", 1100, null, d2);
		Employe e12=new Employe (7900, "JAMES", "CLERK", e6, "2018-08-17", 950, null, d3);
		Employe e13=new Employe (7902, "FORD", "ANALYST", e4, "2018-06-05", 3000, null, d2);
		Employe e14=new Employe (7934, "MILLER", "CLERK", e7, "2018-04-20", 1300, null, d1);
		Employe e15=new Employe (7935, "WILKIN", "CLERK", e7, "2018-04-22", 1280, null, null);

		Employe e1=new Employe (7369, "SMITH", "CLERK", e13, "2018-02-09", 800, null, d2);
		

		
		entreprise.add(e1);
		entreprise.add(e2);
		entreprise.add(e3);
		entreprise.add(e4);
		entreprise.add(e5);
		entreprise.add(e6);
		entreprise.add(e7);
		entreprise.add(e8);
		entreprise.add(e9);
		entreprise.add(e10);
		entreprise.add(e11);
		entreprise.add(e12);
		entreprise.add(e13);
		entreprise.add(e14);
		entreprise.add(e15);

		List<Employe> liste2 = new ArrayList();
		
		liste2.addAll(entreprise);
	
	}
	
	
	
	public static void main(String[] args) {

		initEmp();
		menuPrincipal();
		
		
	}


	private static void menuPrincipal() {
	
		compteConnected=null;
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
		
		String login=saisieString("Saisir votre login");
		String password=saisieString("Saisir votre password");
		
		if(login.equals("Jordan") && password.equals("ajc")) 
		{
			compteConnected= new Admin(login,password);
			menuAdmin();
		}
		else if (login.equals("Scott") && password.equals("1234")) 
		{
			compteConnected = entreprise.get(7);
			menuEmp();
		}
		else 
		{
			System.out.println("Compte invalide");
		}
	
	}

	private static void menuEmp() {
		System.out.println("Menu emp, merci de faire un choix :");
		System.out.println("1 - Afficher mes informations");
		System.out.println("2 - Se deconnecter");
		int choix = saisieInt("");
		
		switch(choix) 
		{
		case 1 : showInfoPerso();break;
		case 2 : menuPrincipal();
		default : System.out.println("Choix impossible !\n");
		}
		
		menuEmp();
		
	}

	private static void showInfoPerso() {
		System.out.println(compteConnected);	
	}
	
	
	
	

	private static void menuAdmin() {
		System.out.println("Menu Admin, merci de faire un choix :");
		System.out.println("1 - Lister les employes");
		System.out.println("2 - Ajouter un employe");
		System.out.println("3 - Modifier le salaire d'un employe");
		System.out.println("4 - Delete un employe");
		System.out.println("5 - Se deconnecter");
		int choix = saisieInt("");
		
		switch(choix) 
		{
		case 1 : showEmployes();break;
		case 2 : addEmploye();break;
		case 3 : updateSal();break;
		case 4 : deleteEmploye();break;
		case 5 : menuPrincipal();
		default : System.out.println("Choix impossible !\n");
		}
		
		menuAdmin();
		
	}

	private static void updateSal() {
		Employe choixEmp = selectEmp();
		
		double newSalaire= saisieDouble("Le salaire actuel est de : "+choixEmp.getSalaire()+". Quel est le nouveau salaire ?");
		choixEmp.setSalaire(newSalaire);
	}

	private static Employe selectEmp() 
	{
		System.out.println("Choisir un employé : ");
		for(int i=0;i<entreprise.size();i++) 
		{
			Employe e = entreprise.get(i);
			System.out.println(i+"- "+e.getNom()+"("+e.getId()+")");
		}
		
		int choix = saisieInt("");
		Employe e = entreprise.get(choix);
		return e;
	}
	
	
	private static void deleteEmploye() {
			
			
			entreprise.remove(selectEmp());
	}

	private static void addEmploye() {
		
		int empno=saisieInt("Saisir empno");
		String ename=saisieString("Saisir ename");
		String job=saisieString("Saisir job");
		
		
		String isMgr=saisieString("Affecter un manager ? (y/n)");
		Employe mgr=null;
		if(isMgr.equals("y")) 
		{
		 mgr = selectEmp();
		}
	
			
			
			
		String hiredate=saisieString("Saisir hiredate (yyyy-mm-dd)");
		
		double sal=saisieDouble("Saisir sal");
		
		String isComm=saisieString("Affecter une comm ? (y/n)");
		Double comm=null;
		if(isComm.equals("y")) 
		{
			comm=saisieDouble("Saisir la comm");
		}
		
		Departement dept=null;
		String isDept = saisieString("Affecter un departement ? (y/n)");
		if(isDept.equals("y")) 
		{
			System.out.println("Choisir un departement : ");
			for(int i=0;i<departements.size();i++) 
			{
				System.out.println(i+"- "+departements.get(i));
			}
			
			int choix = saisieInt("");
			dept = departements.get(choix);
		}
		
		Employe e=new Employe (empno, ename, job, mgr, hiredate, sal, comm, dept);
		entreprise.add(e);
	}

	private static void showEmployes() {
		for(Employe  e : entreprise)
		{
			System.out.println(e);
		}		
	}

}
