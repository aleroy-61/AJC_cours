package metier;

public enum Carte {
    CB (0), Visa(5), MasterCard(10);

	private double prixCarte;

    private Carte(double prixCarte) {
        this.prixCarte=prixCarte;
    }


    public double setprixCarte() {
        return prixCarte;
    }


    public double getprixCarte() {
        return prixCarte;
    }
}