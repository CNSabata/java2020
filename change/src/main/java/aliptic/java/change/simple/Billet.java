package aliptic.java.change.simple;

public class Billet extends Argent {
	public Billet(int valeur) {
        super(Integer.toString(valeur), valeur);
    }
	public Billet(String nom, int valeur) {
	    super(nom, valeur);
	}
	public String toString() {
		return "Billet" + super.toString();
	}
	@Override
    public Monnaie.TYPE_MONNAIE getType() {
        return Monnaie.TYPE_MONNAIE.BILLET;
    }
}
