package metier;

public class Course {

	
	private String libelle;
	private double distance;
	private Runner[] participants;
	
	
	
	public Course(String libelle, double distance, Runner[] participants) {
		this.libelle = libelle;
		this.distance = distance;
		this.participants = participants;
	}
	
	
	public Course(String libelle, double distance) {
		this.libelle = libelle;
		this.distance = distance;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}


	public Runner[] getParticipants() {
		return participants;
	}


	public void setParticipants(Runner[] participants) {
		this.participants = participants;
	}
	
	
}
