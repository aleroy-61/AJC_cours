package test;

import java.util.List;
import java.util.Scanner;

import dao.DAODepartement;
import dao.DAOEmploye;
import dao.DAOOrdinateur;
import metier.Admin;
import metier.Compte;
import metier.Departement;
import metier.Employe;
import metier.Ordinateur;

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

	static DAODepartement daoDept= new DAODepartement();
	static DAOEmploye daoEmp= new DAOEmploye();
	
	static DAOOrdinateur daoOrdi= new DAOOrdinateur();
	
	static Compte compteConnected;

	
	
	public static void main(String[] args) {

		
		
		Ordinateur o = new Ordinateur(1,"HP",16,"White");
		
		daoOrdi.insert(o);
		
		o.setRam(20);
		
		daoOrdi.update(o);
		
		
		System.out.println(daoOrdi.findAll());
		
		
		
		
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
			compteConnected = daoEmp.findById(7788);
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
		System.out.println("5 - Lister les départements");
		System.out.println("6 - Ajouter un département");
		System.out.println("7 - Delete un département");
		System.out.println("8 - Se deconnecter");
		int choix = saisieInt("");
		
		switch(choix) 
		{
		case 1 : showEmployes();break;
		case 2 : addEmploye();break;
		case 3 : updateSal();break;
		case 4 : deleteEmploye();break;
		case 5 : showDepartements();break;
		case 6 : addDepartement();break;
		case 7 : deleteDepartement();break;
		case 8 : menuPrincipal();
		default : System.out.println("Choix impossible !\n");
		}
		
		menuAdmin();
		
	}

	private static void deleteDepartement() {
		
		showDepartements();
		int choix = saisieInt("Saisir le departement");
		
		Departement d = daoDept.findById(choix);
		daoDept.delete(d);
		
	}

	

	private static void addDepartement() {
		int deptno = saisieInt("Saisir département number");
		String dname=saisieString("Saisir dname");
		String loc=saisieString("Saisir loc");
		
		Departement d = new Departement(deptno,dname,loc);
		daoDept.insert(d);
	}

	
	private static void showDepartements() {
		
		List<Departement> depts = daoDept.findAll();
		
		for(Departement d : depts)
		{
			System.out.println(d);
		}
		
	}

	

	
	private static void updateSal() {
		Employe choixEmp = selectEmp();
		
		double newSalaire= saisieDouble("Le salaire actuel est de : "+choixEmp.getSalaire()+". Quel est le nouveau salaire ?");
		choixEmp.setSalaire(newSalaire);
		
		daoEmp.update(choixEmp);
	}

	private static Employe selectEmp() 
	{
		System.out.println("Choisir un employé : ");
		
		List<Employe> entreprise=daoEmp.findAll();
		
		
		
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
			
			
			daoEmp.delete(selectEmp());
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
			
			List<Departement> departements=daoDept.findAll();
			
			for(int i=0;i<departements.size();i++) 
			{
				System.out.println(i+"- "+departements.get(i));
			}
			
			int choix = saisieInt("");
			dept = departements.get(choix);
		}
		
		Employe e=new Employe (empno, ename, job, mgr, hiredate, sal, comm, dept);
		daoEmp.insert(e);
	}

	private static void showEmployes() {
		for(Employe  e : daoEmp.findAll())
		{
			System.out.println(e);
		}		
	}

	

	
}
