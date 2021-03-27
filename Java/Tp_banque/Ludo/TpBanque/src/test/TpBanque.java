package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import metier.Simple;
import metier.Carte;
import metier.Compte;
import metier.Payant;
import metier.Premium;

public class TpBanque {
	
	public static String saisieString(String message)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(message);
		return sc.nextLine();
	}
	
	public static double saisieDouble(String message)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(message);
		return sc.nextDouble();
	}
	
	public static int saisieInt(String message)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(message);
		return sc.nextInt();
	}
	
	public static void main(String[] args) {
		
		Simple c1= new Simple(130.0,Carte.MasterCard);
		
		Payant c2= new Payant(350.0,Carte.Visa,100);
		
		Premium c3= new Premium(300,Carte.MasterCard);

		c1.transaction(100, c2);
		c2.depot(50);
		c3.retrait(2000);
		
		for(Compte c:Compte.getComptes())
		{
		System.out.println("Numéro de compte : "+c.getCode());
		System.out.println("Type : "+c.getClass().getSimpleName());
		System.out.println("Solde actuel : "+c.getSolde()+"\n");
		}
		
		
		System.out.println("Nombre de transactions :"+Compte.getNombreTransactions());
		System.out.println("Total des taxes :"+Compte.getTaxesBanque());
		
		
	}}

	
