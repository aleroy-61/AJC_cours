package metier;

public enum Signe {
	Bélier(5,"15/04"),Taureau(6),Gémeaux(7),Cancer(8),Lion(9),Vierge(10) ,Balance(11),Scorpion(12),Sagittaire(1) ,Verseau(3),Capricorne(2),Poisson(4);

	private int ordre;
	private String debut;
	
	private Signe(int ordre) 
	{
		this.ordre=ordre;
	}
	
	private Signe(int ordre,String debut) 
	{
		this.ordre=ordre;
		this.debut=debut;
	}

	public int getOrdre() {
		return ordre;
	}
	
	public String getDebut() 
	{
		return debut;
	}
	
	
	

}
