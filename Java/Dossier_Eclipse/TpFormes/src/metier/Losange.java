package metier;

public class Losange extends Forme {

	
	private double hauteur;
	
	
	public Losange(double longueur,double hauteur) {
		super(longueur, 0, 4);
		this.hauteur=hauteur;
	}
	
	
	
	
	public double getHauteur() {
		return hauteur;
	}


	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}




	public double calculAir() {return this.longueur*this.hauteur;}
	
	
	public double calculPerimetre() {return longueur*4;}
	
	
	
}
