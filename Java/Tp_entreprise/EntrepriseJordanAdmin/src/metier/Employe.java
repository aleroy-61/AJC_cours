package metier;

import java.time.LocalDate;

public class Employe extends Compte {
	
	private int id;
	private String nom;
	private String job;
	private Employe manager;
	private LocalDate embauche;
	private double salaire;
	private Double commission;
	private Departement departement;
	
	public Employe() {
	}

	public Employe(int id, String nom, String job, Employe manager, String embauche, double salaire, Double commission,
			Departement departement) {
		this.id = id;
		this.nom = nom;
		this.job = job;
		this.manager = manager;
		this.embauche = LocalDate.parse(embauche);
		this.salaire = salaire;
		this.commission = commission;
		this.departement = departement;
	}
	
	public Employe(String login,String password,int id, String nom, String job, Employe manager, String embauche, double salaire, Double commission,
			Departement departement) {
		super(login,password);
		this.id = id;
		this.nom = nom;
		this.job = job;
		this.manager = manager;
		this.embauche = LocalDate.parse(embauche);
		this.salaire = salaire;
		this.commission = commission;
		this.departement = departement;
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Employe getManager() {
		return manager;
	}

	public void setManager(Employe manager) {
		this.manager = manager;
	}

	public LocalDate getEmbauche() {
		return embauche;
	}

	public void setEmbauche(String embauche) {
		this.embauche = LocalDate.parse(embauche);
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", job=" + job + ", manager=" + manager + ", embauche=" + embauche
				+ ", salaire=" + salaire + ", commission=" + commission + ", departement=" + departement + "]";
	}
	
	
}
