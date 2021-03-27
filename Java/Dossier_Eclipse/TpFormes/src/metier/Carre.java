package metier;

public class Carre extends Forme{

	public Carre(double longueur) {
		super(longueur, longueur, 4);
	}
	
	public double calculAir() {return longueur*largeur;}
	
	
	public double calculPerimetre() {return (longueur+largeur)*2;}
	

}
