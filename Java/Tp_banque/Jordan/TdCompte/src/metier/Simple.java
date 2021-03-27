package metier;

public class Simple extends Compte {

	
	public Simple(double solde, Carte cb) {
		super(solde, 5, cb);
	}

	public Simple() {
	}
	
	
	
	
	

	@Override
	public boolean retraitOk(double montant) {
		if(solde-montant-taxe>=0) {return true;}
		return false;
	}

	@Override
	public boolean depotOk(double montant) {
		if(solde+montant-taxe>=0) {return true;}
		return false;
	}

	
	@Override
	public String toString() {
		return "Simple [code=" + code + ", solde=" + solde + ", taxe=" + taxe + ", cb=" + cb + "]";
	}
	
}
