package metier;

public class Payant extends Compte {
	
	private double decouvert;
	
public Payant(double solde, Carte carte, double decouvert) {
		super(solde-50, 1, carte);
		this.decouvert=decouvert;
		
	}





	@Override
	public boolean retraitOk(double montant) {
    	if(solde-montant-taxe>=-decouvert) { 
    		return true;}
    	else {System.out.println("Erreur, le solde du compte  n'est pas suffisant pour faire un retrait de :"+montant+"€\n");
    		return false;}
    
    }
   
	@Override
    public boolean depotOk(double montant) {
    	if(solde+montant-taxe>=-decouvert) { //Découvert de 100€ pour un compte Payant
    		return true;}
    	else {System.out.println("Erreur, le solde du compte  n'est pas suffisant pour faire un depot de :"+montant+"€\n");
    		return false;}
    	}



	@Override
	public String toString() {
		return "Payant [decouvert=" + decouvert + ", code=" + code + ", solde=" + solde + ", taxe=" + taxe + ", carte="
				+ carte + "]";
	
	}	
	
	
	public double getDecouvert() {
	return decouvert;
}



public void setDecouvert(double decouvert) {
	this.decouvert = decouvert;
}

	
}