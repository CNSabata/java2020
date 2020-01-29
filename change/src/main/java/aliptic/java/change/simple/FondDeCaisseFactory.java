package aliptic.java.change.simple;

import java.util.Arrays;

public abstract class FondDeCaisseFactory {

    public FondDeCaisseFactory() {
    }

    public FondDeCaisse creerFondDeCaisse(double montant) {
    	FondDeCaisse fondDeCaisse = getNewFondDeCaisse();
        if (montant < 0) {
            return fondDeCaisse;
        }
        
        // il s'agit maintenant de convertir le montant en Argent
        
        InfoMonnaie infoMonnaie = fondDeCaisse.getInfoMonnaie();
        int[] valeursBillets = infoMonnaie.getValeursBillet();
        double[] valeursPieces = infoMonnaie.getValeursPiece();
        
        // on travaille en centimes pour faire des operations avec des entiers 
        
        Arrays.sort(valeursBillets);
        Arrays.sort(valeursPieces);
        int minValue = valeursPieces.length > 0 ? (int)(valeursPieces[0] * 100) : valeursBillets[0] * 100;
        int restant = (int)(montant * 100);
        while (true) {
            for (int billet : valeursBillets) {
                if (restant >= (billet * 100)) {
                    fondDeCaisse.getArgent().add(new Billet(billet * 100));
                    restant -= (billet * 100);
                }
            }
            for (double piece : valeursPieces) {
                if (restant >= (int)(piece * 100)) {
                    fondDeCaisse.getArgent().add(new Piece((int)(piece * 100)));
                    restant -= (int)(piece * 100);
                }
            }
            if (restant < minValue) {
                break;
            }
        }
        return fondDeCaisse;
    }

    protected abstract FondDeCaisse getNewFondDeCaisse();
}
