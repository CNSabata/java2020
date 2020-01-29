package fr.aliptic.caisse;

public abstract class Argent {
	protected int valeur;
	protected String nom;
	
	public Argent(int valeur, String nom) {
		if (nom == null || "".equals(nom)) {
			throw new IllegalArgumentException("Paramètre 'nom' non valide");
		}
		this.valeur = valeur;
		this.nom = nom;
	}

	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String toString() {
		return "[" + nom + ": " + valeur + "]";
	}
	public abstract Monnaie.TYPE_MONNAIE getType();
	
}
