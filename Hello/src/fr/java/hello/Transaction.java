package fr.java.hello;

public class Transaction {
	private double montant;
	public static double taux = 1;

	public Transaction(double montant) {
		this.montant = montant;
	}
	
	public double getMontant() {
		return montant;
	}
	
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	public double calculChange() {
		return montant * taux;
	}
}
