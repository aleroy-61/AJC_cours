package metier;

public class Rectangle extends Forme{

	
	public Rectangle(double longueur, double largeur) {
		super(longueur, largeur, 4);
	}
	
	
	
	public double calculAir() {return longueur*largeur;}
	
	
	public double calculPerimetre() {return (longueur+largeur)*2;}
}
