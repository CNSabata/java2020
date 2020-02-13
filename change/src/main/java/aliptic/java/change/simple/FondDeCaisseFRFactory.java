package aliptic.java.change.simple;

public class FondDeCaisseFRFactory extends FondDeCaisseFactory {
	
    public FondDeCaisseFRFactory() {
        super();
    }
    
    @Override
    protected FondDeCaisse getNewFondDeCaisse() {
        return new FondDeCaisseFR();
    }
}

