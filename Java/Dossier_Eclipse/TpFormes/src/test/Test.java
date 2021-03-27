package test;

import java.util.ArrayList;
import java.util.List;

import metier.Carre;
import metier.Cercle;
import metier.Forme;
import metier.Losange;
import metier.Rectangle;

public class Test {

	public static void main(String[] args) {
	
		
		
		final double pi = 3.14159;
		
		// Impossible de faire pi=3;
		
		///Forme f1 = new Cercle(15);
		
		
		//f1= new Rectangle(14,7);
		
		Cercle cercle = new Cercle(10);
		
		
		System.out.println(cercle);
		
		Carre carre1 = new Carre(5);
		Carre carre2 = new Carre(6);
		
		Rectangle rectangle=new Rectangle(10,2);
		
		Losange losange = new Losange(7,12);
		
		carre1.comparer(losange);
		
	
		
		List<Forme> listeDeFormes = new ArrayList();
		
		
		//listeDeFormes.add(f1);
		listeDeFormes.add(cercle);
		listeDeFormes.add(carre1);
		listeDeFormes.add(losange);
		listeDeFormes.add(carre2);
		listeDeFormes.add(rectangle);
		
		
		for(Forme f : listeDeFormes) {
			
			System.out.println("La figure actuelle est un : "+f.getClass().getSimpleName());
			System.out.println("Son aire est :"+f.calculAir()+"cm², son perimetre : "+f.calculPerimetre()+"cm \n\n");
		}
		
		
		
		

	}

}
