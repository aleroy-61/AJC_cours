package test;

import java.util.ArrayList;
import java.util.List;

import metier.Animal;
import metier.Carnivore;
import metier.Herbivore;
import metier.Humain;
import metier.Lion;
import metier.Porc;
import metier.Suricate;
import metier.Zebre;

public class Test {

	public static void main(String[] args) {
		
		List<Animal> zoo = new ArrayList();
		List<Carnivore> carnivores = new ArrayList();
		List<Herbivore> herbivores = new ArrayList();
		
	
		
		
		Humain jordan = new Humain();
		carnivores.add(jordan);
		herbivores.add(jordan);
		
		Zebre marty = new Zebre();
		zoo.add(marty);
		herbivores.add(marty);
		
		Lion simba = new Lion();
		zoo.add(simba);
		carnivores.add(simba);
		
		
		Porc babe = new Porc();
		zoo.add(babe);
		carnivores.add(babe);
		herbivores.add(babe);
		
		Suricate sid = new Suricate();
		zoo.add(sid);
		carnivores.add(sid);
		
		Carnivore c = simba;
		
		
	for(Animal a : zoo) 
	{
		
		if(a instanceof Carnivore && a instanceof Herbivore) 
		{
			System.out.println(a.getClass().getSimpleName()+" est Omnivore");
			((Carnivore) a).manger(marty);
			((Herbivore) a).manger("bambou");
		}
		else if( a instanceof Carnivore) 
		{
			System.out.println(a.getClass().getSimpleName()+" est Carnivore");
			((Carnivore) a).manger(marty);
		}else 
		{
			System.out.println(a.getClass().getSimpleName()+" est Herbivore");
			((Herbivore) a).manger("bambou");
		}
	}
		
	
	jordan.manger(sid);
		
		
		
		
	}

}
