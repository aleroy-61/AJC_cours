package metier;

public abstract class Forme {

	protected double longueur;
	protected double largeur;
	protected int nbCote;
	
	
	
	public Forme(double longueur, double largeur, int nbCote) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.nbCote = nbCote;
	}



	public double getLongueur() {
		return longueur;
	}



	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}



	public double getLargeur() {
		return largeur;
	}



	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}



	public int getNbCote() {
		return nbCote;
	}



	public void setNbCote(int nbCote) {
		this.nbCote = nbCote;
	}
	
	
	public double calculAir() {return 0;}
	
	//Une methode final ne peut pas etre modifiée dans les classes filles 
	public final void showNbCote() 
	{
		System.out.println("Un "+this.getClass().getSimpleName()+ "doit avoir "+nbCote+" cotés");
	}
	
	
	public void comparer(Forme f) 
	{
		if(this.calculAir()>f.calculAir()) 
		{
			System.out.println("L'air du "+this.getClass().getSimpleName()+" est > à celle du "+f.getClass().getSimpleName());
		}
		else 
		{
			System.out.println("L'air du "+this.getClass().getSimpleName()+" est < à celle du "+f.getClass().getSimpleName());
		}
		
	}
	
	public double calculPerimetre() {return 0;}



	@Override
	public String toString() {
		return "Forme [longueur=" + longueur + ", largeur=" + largeur + ", nbCote=" + nbCote + "]";
	}
	
	
	
}
