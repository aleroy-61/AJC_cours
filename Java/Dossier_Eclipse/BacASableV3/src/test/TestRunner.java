package test;
import java.util.Arrays;
import java.util.Scanner;

import metier.Course;

import metier.Runner;

public class TestRunner {

	
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
		
		
		
		
		Runner r1 = new Runner("Abid", 27, 173);
		Runner r2 = new Runner("Toto", 30, 180);
		Runner r3 = new Runner("Titi", 25, 165);
		Runner r4 = new Runner("Tutu", 65);
		
		Runner tab[]= {r1,r2,r3,r4};
		
		Runner tab2[]= {r1,r2};
		
		
		Course c1 = new Course("Marathon", 42.2);
		
		Course c2 = new Course("Semi-Marathon", 21.1,tab);
		
		Course c3 = new Course("Autre course", 10,tab2);
		
		
		/*for(int i=0; i<tab.length;i++) 
		{
			tab[i].sePresenter();
		}
		*/
		
		for(Runner r : c2.getParticipants()) 
		{
			r.sePresenter();
		}	
			
		
	}

}
