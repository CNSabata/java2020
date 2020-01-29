package fr.aliptic.caisse;

public class FondDeCaisseUSFactory extends FondDeCaisseFactory {

	public FondDeCaisseUSFactory() {
		super();
	}
	
	@Override
	protected FondDeCaisse getNewFondDeCaisse() {
		return new FondDeCaisseUS();
	}

}
