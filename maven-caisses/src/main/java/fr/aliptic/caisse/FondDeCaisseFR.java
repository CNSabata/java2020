package fr.aliptic.caisse;

public class FondDeCaisseFR extends FondDeCaisse {
	public FondDeCaisseFR() {
		super();
	}

	@Override
	public InfoMonnaie getInfoMonnaie() {
		return new InfoMonnaie(Monnaie.NOM_FR, Monnaie.BILLETS_FR, Monnaie.PIECES_FR);
	}

}
