package metier;

public class Eleve extends Personne{


	private int identifiant;
	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public Signe getAstro() {
		return astro;
	}

	public void setAstro(Signe astro) {
		this.astro = astro;
	}

	public static int getCpt() {
		return cpt;
	}

	private Signe astro;
	
	private static int cpt=0;

	public Eleve(Signe astro) {
		cpt++;
		this.identifiant = cpt;
		this.astro = astro;
	}
	
	public Eleve() {}
	
	
	

	

	
	
	
	
}
