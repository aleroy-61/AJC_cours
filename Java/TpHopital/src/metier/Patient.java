package metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Patient implements Serializable{

	private int id;
	private String nom;
	private String prenom;
	private List<Visite> visites=new ArrayList();
	public List<Visite> getVisites() {
		return visites;
	}
	
	public Patient(int id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	
}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
}
	
