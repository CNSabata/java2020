package fr.aliptic.caisse;

public class FondDeCaisseUS extends FondDeCaisse {
	public FondDeCaisseUS() {
		super();
	}

	@Override
	public InfoMonnaie getInfoMonnaie() {
		return new InfoMonnaie(Monnaie.NOM_US, Monnaie.BILLETS_US, Monnaie.PIECES_US);
	}

}
