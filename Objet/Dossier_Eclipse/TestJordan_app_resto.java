package test;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import metier.Boisson;
import metier.Plat;

public class TestJordan {

	
	public static String saisieString(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextLine();
	}
	
	public static void main(String[] args) {
	
		List<Plat> choixPlat = new ArrayList();
		List<Boisson> choixBoisson = new ArrayList();
		
		Boisson carteBoisson[] = Boisson.values();
		Plat cartePlat[] = Plat.values();
		
		System.out.println("Welcome chez chezJordan");
		
		
		String continueCommande = saisieString("Voulez vous une boisson ? y/n");
		String choix;
		while(continueCommande.equalsIgnoreCase("y")) 
		{
			for(Boisson b : carteBoisson) 
			{
				System.out.println(b+" - "+b.getPrix()+"€ ");
			}
			choix=saisieString("Choix de votre boisson");
			Boisson choixSaisieBoisson = Boisson.valueOf(choix);
			
			choixBoisson.add(choixSaisieBoisson);
			
			continueCommande= saisieString("Voulez vous une autre boisson ? y/n");
		}
		
		
		
		

		continueCommande = saisieString("Voulez vous un plat ? y/n");
		while(continueCommande.equals("y")) 
		{
			for(Plat p : cartePlat) 
			{
				System.out.println(p+" - "+p.getPrix()+"€ ");
			}
			choix=saisieString("Choix de votre plat");
			Plat choixSaisiePlat = Plat.valueOf(choix);
			
			choixPlat.add(choixSaisiePlat);
			
			continueCommande= saisieString("Voulez vous un autre plat ? y/n");
		}
		
		
		
		if(choixPlat.isEmpty()==true && choixBoisson.isEmpty()==true) 
		{
			System.out.println("Il faut commander la prochaine fois !");
		}
		else 
		{
			double total=0;
			
			
			for(Boisson b : choixBoisson) 
			{
				total+=b.getPrix();
			}
			for(Plat p : choixPlat) 
			{
				total+=p.getPrix();
			}
			
			System.out.println("Total de votre commande : "+total+"€");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
