package metier;

import java.sql.Date;
import java.time.LocalDate;

public class Visite {

	private int id;
	private Patient patient;
	private Medecin medecin;
	private double coutConsultation;
	private int salle;
	private LocalDate date;
	
	public Visite(int id, Patient patient, Medecin medecin, double coutConsultation, int salle, String date) {
		this.id = id;
		this.patient = patient;
		this.medecin = medecin;
		this.coutConsultation = coutConsultation;
		this.salle = salle;
		this.date = LocalDate.parse(date);
	}
	
	public Visite(int id, Patient patient, Medecin medecin, double coutConsultation, int salle) {
		this.id = id;
		this.patient = patient;
		this.medecin = medecin;
		this.coutConsultation = coutConsultation;
		this.salle = salle;
		this.date = LocalDate.now();
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public double getCoutConsultation() {
		return coutConsultation;
	}

	public void setCoutConsultation(double coutConsultation) {
		this.coutConsultation = coutConsultation;
	}

	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = LocalDate.parse(date);
	}
	

	@Override
	public String toString() {
		return "Visite [id=" + id + ", medecin=" + medecin + ", coutConsultation=" + coutConsultation + ", salle="
				+ salle + ", date=" + date + "]";
	}

	
	
	
	
}
