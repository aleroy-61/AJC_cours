package metier;

import java.util.ArrayList;
import java.util.List;

public abstract class Compte {


	protected int code;
	private static int cpt=0;

	protected double solde;
	protected double taxe;
	protected Carte cb;

	private static int nbTransac=0;
	private static double totalTaxe=0;
	
	
	private static List<Compte> banque = new ArrayList();

	public Compte() {
	}


	public Compte(double solde, double taxe, Carte cb) {
		this.solde = solde-cb.getPrix();
		this.taxe = taxe;
		this.cb = cb;
		cpt++;
		this.code=cpt;
		
		
		banque.add(this);
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		this.solde = solde;
	}


	public double getTaxe() {
		return taxe;
	}


	public void setTaxe(double taxe) {
		this.taxe = taxe;
	}


	public Carte getCb() {
		return cb;
	}


	public void setCb(Carte cb) {
		this.cb = cb;
	}


	public static int getCpt() {
		return cpt;
	}



	public static List<Compte> getBanque() {
		return banque;
	}


	public static void setBanque(List<Compte> banque) {
		Compte.banque = banque;
	}


	public void retrait(double montant) 
	{
		if(retraitOk(montant)) {

			solde-=montant+taxe;
			
			nbTransac++;
			totalTaxe+=taxe;
			
			System.out.println("Retrait OK pour le montant suivant : "+montant+"€");
		}
		else 
		{
			System.out.println("Retrait impossible pour le montant suivant : "+montant+"€");
		}
	}

	public void depot(double montant) 
	{
		if(depotOk(montant)) {

			solde+=montant-taxe;
			
			nbTransac++;
			totalTaxe+=taxe;
			
			System.out.println("Depot OK pour le montant suivant : "+montant+"€");
		}
		else 
		{
			System.out.println("Depot impossible pour le montant suivant : "+montant+"€");
		}
	}



	public void transfert(double montant,Compte c) 
	{

			if(this.retraitOk(montant) && c.depotOk(montant)) 
			{
				this.retrait(montant);
				c.depot(montant);
				System.out.println("Transfert ok pour le montant suivant : "+montant+"€ vers le compte "+c.getCode());
			}
			else 
			{
				System.out.println("Transfert impossible pour le montant suivant : "+montant+"€ vers le compte "+c.getCode());
			}
	}

	public abstract boolean retraitOk(double montant);
	public abstract boolean depotOk(double montant);



	
	
	public static int getNbTransac() {
		return nbTransac;
	}


	public static double getTotalTaxe() {
		return totalTaxe;
	}


	@Override
	public String toString() {
		return "Compte [code=" + code + ", solde=" + solde + ", taxe=" + taxe + ", cb=" + cb + "]";
	}










}
