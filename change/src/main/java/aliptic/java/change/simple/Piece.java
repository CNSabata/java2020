package aliptic.java.change.simple;

public class Piece extends Argent {
	public Piece(int valeur) {
		super(Integer.toString(valeur), valeur);
    }
    public Piece(String nom, int valeur) {
    	super(nom, valeur);
    }
	public String toString() {
		return "Piece" + super.toString();
	}
    public Monnaie.TYPE_MONNAIE getType() {
        return Monnaie.TYPE_MONNAIE.PIECE;
    }
}
