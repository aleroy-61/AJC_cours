package metier;

public class Simple extends Compte{
	
	

	public Simple(double solde, Carte carte) {
		super(solde, 5, carte);
		
	}

	public boolean retraitOk(double montant) {
    	if(solde-montant-taxe>=0) { 
    		return true;}
    	else {
    		return false;}
    
    }
   
    public boolean depotOk(double montant) {
    	if(solde+montant-taxe>=0) { 
    		return true;}
    	else {
    		return false;}
    	}

	@Override
	public String toString() {
		return "Simple [code=" + code + ", solde=" + solde + ", taxe=" + taxe + ", carte=" + carte + "]";
	}
	
 

	
	
	}
	
	


