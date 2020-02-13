package aliptic.java.change.simple;

public abstract class Argent {
    protected String nom;
    protected int valeur;
	public Argent(String nom, int valeur) {
		if (nom == null || "".equals(nom)) {
			throw new IllegalArgumentException("Parametre 'nom' non valides");
		}
        this.nom = nom;
        this.valeur = valeur;
	}
	public String getNom() {
		return nom;
	}
	public int getValeur() {
		return valeur;
	}
	public String toString() {
		return "[" + nom + ":" + valeur + "]";
	}
    public abstract Monnaie.TYPE_MONNAIE getType();
}
