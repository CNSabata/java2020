package aliptic.java.change.simple;

public class FondDeCaisseUSFactory extends FondDeCaisseFactory {

	public FondDeCaisseUSFactory() {
        super();
    }
    
    @Override
    protected FondDeCaisse getNewFondDeCaisse() {
        return new FondDeCaisseUS();
    }
}
