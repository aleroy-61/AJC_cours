package metier;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Compte {

	protected int code;
    protected double solde;
    protected double taxe;
    protected static int cpt=0;
    protected Carte carte;
    protected static int nombreTransactions=0;
    protected static List<Compte> comptes=new ArrayList();
    protected static double taxesBanque=0;
    
   
	public Compte(double solde, double taxe, Carte carte) {
        this.taxe = taxe;
        cpt++;
        this.code = cpt;
        this.solde=solde;
        this.carte=carte; 
        this.solde-=carte.getprixCarte();
    	comptes.add(this);
    	}

	public static double getTaxesBanque() {
		return taxesBanque;
	}
	
	public static List<Compte> getComptes() {
		return comptes;
	}


	public static void setComptes(List<Compte> comptes) {
		Compte.comptes = comptes;
	}


	public Carte getCarte() {
		return carte;
	}


	public void setCarte(Carte carte) {
		this.carte = carte;
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

    public static int getNombreTransactions() {
		return nombreTransactions;
	}

    public abstract boolean retraitOk(double montant);
    
       
    public abstract boolean depotOk(double montant);
    	
    
    
    public void depot(double montant) {
    	if(this.depotOk(montant)==true) {
    	solde+=montant-taxe;
    	nombreTransactions++;
    	taxesBanque+=taxe;
    	System.out.println("Solde du compte n°"+this.getCode()+" après opération : "+this.getSolde()+"\n");
    	}
    	
    }
    
    public void retrait(double montant) {
    	if(this.retraitOk(montant)==true) {
    	solde-=montant+taxe;
    	nombreTransactions++;
    	taxesBanque+=taxe;
    	System.out.println("Solde du compte n°"+this.getCode()+" après opération : "+this.getSolde()+"\n");
    	}//+taxe a cause du signe sinon ca fait +taxe
    
	}
    
    	public void transaction(double montant,Compte destinataire) {
    		if(this.retraitOk(montant)==true&&destinataire.depotOk(montant)==true) {
    		this.retrait(montant);
    		destinataire.depot(montant);}}
    		
    
    		

    		}
    		
    		
    		
    		
    		
    	

