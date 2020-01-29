package fr.aliptic.caisse;

public class Billet extends Argent {
	public Billet (int valeur) {
		super(valeur, Integer.toString(valeur));
	}
	public Billet(int valeur, String nom) {
		super(valeur, nom);
	}

	@Override
	public String toString() {
		return "Billet" + super.toString();
	}
	@Override
	public Monnaie.TYPE_MONNAIE getType() {
		return Monnaie.TYPE_MONNAIE.BILLET;
	}
}
