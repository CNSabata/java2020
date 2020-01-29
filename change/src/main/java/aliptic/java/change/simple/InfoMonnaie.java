package aliptic.java.change.simple;

public class InfoMonnaie {
	private String nom;
	private int[] valeursBillet;
	private double[] valeursPiece;
	public InfoMonnaie(String nom, int[] valeursBillet, double[] valeursPiece) {
		this.nom = nom;
		this.valeursBillet = valeursBillet;
		this.valeursPiece = valeursPiece;
	}
	public String getNom() {
		return nom;
	}
	public int[] getValeursBillet() {
		return valeursBillet;
	}
	public double[] getValeursPiece() {
		return valeursPiece;
	}
}
