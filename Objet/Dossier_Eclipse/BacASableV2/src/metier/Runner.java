package metier;

public class Runner {

	private String nom;
	private int age;
	private int taille;

	
	
	public Runner(String nom, int age, int taille) {
		this.nom = nom;
		this.age = age;
		this.taille = taille;
	}
	
	public Runner(String nom, int age) {
		this.nom = nom;
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public void sePresenter() 
	{
		System.out.println("Nom : "+nom+", Taille : "+taille+", Age : "+age);
	}
	
	
}
