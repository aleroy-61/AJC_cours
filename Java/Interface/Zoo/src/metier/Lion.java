package metier;

public class Lion extends Animal implements Carnivore{

	@Override
	public void manger(Animal a) {
		System.out.println("Je mange un "+a.getClass().getSimpleName());
		
	}

}
