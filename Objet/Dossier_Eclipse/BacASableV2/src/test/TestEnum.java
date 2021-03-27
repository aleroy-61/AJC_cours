package test;
import java.util.Arrays;
import java.util.Scanner;

import metier.Eleve;
import metier.Signe;

public class TestEnum {

	
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

	
	public static void main(String[] args) {
	
		Eleve e1= new Eleve("Abid","Jordan",27);
		
		
		System.out.println(Arrays.toString(Signe.values()));
		
		String saisieAstro=saisieString("Quel est votre signe");
		Signe astro=Signe.valueOf(saisieAstro);
		
		
		System.out.println(astro.getOrdre());
		//Signe astro2=Signe.Taureau;
		
		
		
		
		e1.setAstro(astro);
		e1.sePresenter();
		
	}

}
