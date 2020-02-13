package aliptic.java.change.simple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class FondDeCaisse {
    private List<Argent> argent = new ArrayList<Argent>();

    public FondDeCaisse() {
    }

    public List<Argent> getArgent() {
        return argent;
    }
    
    public void afficherContenu() {
    	argent.stream().sorted(Comparator.comparingInt(Argent::getValeur))
    		.forEach(a -> System.out.println(a));
    }
    
    public abstract InfoMonnaie getInfoMonnaie();
}
