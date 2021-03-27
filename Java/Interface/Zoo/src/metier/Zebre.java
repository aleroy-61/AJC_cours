package metier;

public class Zebre extends Animal implements Herbivore {

	@Override
	public void manger(String plante) {
		System.out.println("Je mange un(e) "+plante);
		
	}

}
