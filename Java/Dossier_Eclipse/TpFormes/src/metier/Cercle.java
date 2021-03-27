package metier;

public class Cercle extends Forme {

	private double rayon;
	
	public Cercle(double rayon) {
		super(0, 0, 0);
		this.rayon=rayon;
	}
	
	public double calculAir() {return Math.PI * rayon*rayon;}
	
	
	public double calculPerimetre() { return Math.PI *(rayon+rayon);}


	
	
	
	
}
