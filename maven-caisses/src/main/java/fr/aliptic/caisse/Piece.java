package fr.aliptic.caisse;

public class Piece extends Argent {
	public Piece (int valeur) {
		super(valeur, Integer.toString(valeur));
	}
	public Piece(int valeur, String nom) {
		super(valeur, nom);
	}

	@Override
	public String toString() {
		return "Pieces" + super.toString();
	}
	@Override
	public Monnaie.TYPE_MONNAIE getType() {
		return Monnaie.TYPE_MONNAIE.PIECE;
	}
}
