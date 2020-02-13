package aliptic.java.change.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Un compartiment est identifie:
 * - par un type de monnaie (billet, piece)
 * - et une valeur exprimée en centime
 *
 */
public class Compartiment {
    private Monnaie.TYPE_MONNAIE type;
    private int valeur;
    private List<Argent> argent = new ArrayList<Argent>();

    public Compartiment(Monnaie.TYPE_MONNAIE type, int valeur) {
        this.type = type;
        this.valeur = valeur;
    }

    public Monnaie.TYPE_MONNAIE getType() {
        return type;
    }
    
    public int getValeur() {
        return valeur;
    }

    public List<Argent> getArgent() {
        return argent;
    }

    public String toString() {
        return "Compartiment [" + type + "][" + valeur + "]";
    }
}
