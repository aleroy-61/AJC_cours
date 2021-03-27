package metier;

public class Premium extends Compte {

	
	public Premium(double solde, Carte carte) {
		super(solde-150, 0, carte);
		
	}


	@Override
	public boolean retraitOk(double montant) { 
    		return true;}
    
   
	@Override
    public boolean depotOk(double montant) {
    		return true;}


	@Override
	public String toString() {
		return "Premium [code=" + code + ", solde=" + solde + ", taxe=" + taxe + ", carte=" + carte + "]";
	}
    		
	
	
}
