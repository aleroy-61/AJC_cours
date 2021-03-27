package metier;

public class Humain implements Carnivore,Herbivore {

	@Override
	public void manger(String plante) {
		System.out.println("Je mange un(e) "+plante);
	}


	@Override
	public void manger(Animal a) {
		System.out.println("Je mange un "+a.getClass().getSimpleName());	
	}

}
