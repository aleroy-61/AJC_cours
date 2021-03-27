package test;

import java.util.ArrayList;
import java.util.List;

import metier.Eleve;
import metier.Formateur;
import metier.Personne;

public class TestEleveStatic {

	public static void main(String[] args) {
		
		Personne p1 = new Personne();
		
		Formateur f = new Formateur();
		
		
		Eleve e= new Eleve();
		
		
		
		List<Personne> notreClasse = new ArrayList();
		
		notreClasse.add(f);
		notreClasse.add(e);
		notreClasse.add(p1);
		
		for(Personne p : notreClasse)
		{
			
			p.sePresenter();
		}		
		
	
		
		/*Eleve e1=new Eleve("Nom","Prenom",27);
		
		Eleve e2=new Eleve("Toto","Titi",27);
	
		

		
		Formateur f1 = new Formateur("Abid","Jordan",27);
		
		Formateur f2 = new Formateur("Gozlan","Olivier",35);
		
		
		
		List<Eleve> eleves = new ArrayList();
		eleves.add(e1);
		eleves.add(e2);
		eleves.add(f1);
		
		
		
		
		
		
*/
	}

}
