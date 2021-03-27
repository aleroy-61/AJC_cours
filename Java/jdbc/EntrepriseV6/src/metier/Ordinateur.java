package metier;

public class Ordinateur {

	private int numero;
	
	private String marque;
	
	private int ram;

	private String couleur;
	
	
	
	public Ordinateur() {
	}



	public Ordinateur(int numero, String marque, int ram, String couleur) {
		this.numero = numero;
		this.marque = marque;
		this.ram = ram;
		this.couleur = couleur;
	}


	
	

	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public String getMarque() {
		return marque;
	}



	public void setMarque(String marque) {
		this.marque = marque;
	}



	public int getRam() {
		return ram;
	}



	public void setRam(int ram) {
		this.ram = ram;
	}



	public String getCouleur() {
		return couleur;
	}



	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}



	@Override
	public String toString() {
		return "Ordinateur [numero=" + numero + ", marque=" + marque + ", ram=" + ram + ", couleur=" + couleur + "]";
	}
	
	
	
	
}
