package fr.aliptic.caisse;

public class InfoMonnaie {
	private String nom;
	private int[] valeursBillets;
	private double[] valeursPieces;
	
	public InfoMonnaie(String nom, int[] valeursBillets, double[] valeursPieces) {
		this.nom = nom;
		this.valeursBillets = valeursBillets;
		this.valeursPieces = valeursPieces;
	}

	public String getNom() {
		return nom;
	}

	public int[] getValeursBillets() {
		return valeursBillets;
	}

	public double[] getValeursPieces() {
		return valeursPieces;
	}
}
