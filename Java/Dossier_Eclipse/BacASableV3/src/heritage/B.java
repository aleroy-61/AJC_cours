package heritage;

public class B extends A {

	private String chaine;
	
	public B(int valeur, String chaine) {
		super(valeur);
		this.chaine=chaine;
	}
	
	
	
	public void m1() 
	{
		
		System.out.println("Je suis le numero : "+valeur);
		System.out.println("Je suis m1 de B (+++)");
	}
	
	
	
	
	
	
	

}
