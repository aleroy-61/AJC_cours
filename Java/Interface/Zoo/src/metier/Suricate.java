package metier;

public class Suricate extends Animal implements Carnivore{

	@Override
	public void manger(Animal a) {
		System.out.println("Je mange un "+a.getClass().getSimpleName());
	}
	
	

}
