package metier;

public class Payant extends Compte {

	private double decouvert;
	public Payant(double solde, Carte cb, double decouvert) {
		super(solde-50, 1, cb);
		if(decouvert<0) 
		{
			this.decouvert=decouvert*-1;
		}
		else
		{
			this.decouvert=decouvert;
		}
	}
	
	public Payant() {
	}
	
	
	public double getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	
	@Override
	public boolean retraitOk(double montant) {
		if(solde+decouvert-montant-taxe>=0) {return true;}
		return false;
	}

	@Override
	public boolean depotOk(double montant) {
		if(solde+decouvert+montant-taxe>=0) {return true;}
		return false;
	}

	@Override
	public String toString() {
		return "Payant [decouvert=" + decouvert + ", code=" + code + ", solde=" + solde + ", taxe=" + taxe + ", cb="
				+ cb + "]";
	}
	
	
	
	

	
	

	
	
	
}
