package aliptic.java.change.simple;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Pour eviter les problemes de precision sur les operations, les caisses travaillent en centimes (int)
 * Le service getNbDigits de infoMonnaie permet de convertir les montants en centimes
 */
public class Caisse implements ICaisse {

    private String uid = UUID.randomUUID().toString();
    private InfoMonnaie infoMonnaie;
    private List<Compartiment> compartiments = new ArrayList<Compartiment>();
    
    // total en centimes
    private int total = 0;

    public Caisse(FondDeCaisse fondDeCaisse) {
        if (fondDeCaisse == null) {
            throw new IllegalArgumentException("parametre 'fond de caisse' non valide");
        }

        infoMonnaie = fondDeCaisse.getInfoMonnaie();

        total = fondDeCaisse.getArgent().stream().mapToInt(a -> a.getValeur()).sum();
        System.out.println(getLogPrefix() + "total fond de caisse : " + total +  " 0.01 " + infoMonnaie.getNom());

        // creation des compartiments
        for (int valeur : infoMonnaie.getValeursBillet()) {
            compartiments.add(new Compartiment(Monnaie.TYPE_MONNAIE.BILLET, convertToCentimes((double)valeur)));
        }
        for (double valeur : infoMonnaie.getValeursPiece()) {
            compartiments.add(new Compartiment(Monnaie.TYPE_MONNAIE.PIECE, convertToCentimes(valeur)));
        }
        // tri des compartiments par ordre croissant
        compartiments = compartiments.stream()
        		.sorted(Comparator.comparingInt(Compartiment::getValeur))
        		.collect(Collectors.toList());

        // repartition de l'argent dans les compartiments
        for (Compartiment compartiment : compartiments) {
            compartiment.getArgent()
            	.addAll(fondDeCaisse.getArgent().stream()
            			.filter(a -> a.getType().equals(compartiment.getType()) 
            							&& (a.getValeur() == compartiment.getValeur()))
            			.collect(Collectors.toList()));
        }
        
        fondDeCaisse.getArgent().clear();
    }

	@Override
	public boolean verifierCoherence() {
        int calcul = 0;
        for (Compartiment compartiment : compartiments) {
            calcul += compartiment.getArgent().stream().mapToInt(a -> a.getValeur()).sum();
        }
        System.out.println(getLogPrefix() + (calcul == total ?
                "La caisse est juste: le total calculé correspond bien au total enregistré" :
                "ATTENTION : erreur de caisse - calcul : " + convertFromCentimes(calcul)  + " " + infoMonnaie.getNom() + " - total : " +convertFromCentimes(total) + " " + infoMonnaie.getNom()));
        return calcul == total;
	}

	public String getMonnaie() {
        return infoMonnaie.getNom();
	}

	@Override
	public double getTotal() {
		return convertFromCentimes(total);
	}
	
	@Override
	public void afficherTotal() {
		System.out.println(getLogPrefix() + "total : " + convertFromCentimes(total));
	}

	@Override
	public void afficherContenu() {
		System.out.println(getLogPrefix() + "Unité: 0.01 " + infoMonnaie.getNom());
        compartiments.stream().filter(c -> c.getArgent().size() > 0)
        	.forEach(c -> System.out.println(getLogPrefix() + c + " nb : " + c.getArgent().size()));
	}

	@Override
	public boolean entree(Monnaie.TYPE_MONNAIE type, double valeur) {
		return ajouterArgent(type, convertToCentimes(valeur));
	}

	@Override
	public boolean sortie(Monnaie.TYPE_MONNAIE type, double valeur) {
        return sortirArgent(type, convertToCentimes(valeur));
	}

	/**
	 * Ajoute une unité d'argent dans un compartiment
	 * @param isBillet
	 * @param valeur
	 * @return
	 */
	private boolean ajouterArgent(Monnaie.TYPE_MONNAIE type, int valeur) {
		if (type == null || valeur <= 0) {
			throw new IllegalArgumentException("parametres non valides");
		}
		List<Compartiment> lCompartiments = compartiments.stream().filter(c -> c.getType().equals(type) && c.getValeur() == valeur).collect(Collectors.toList());
		if (lCompartiments == null || lCompartiments.size() != 1) {
			throw new IllegalArgumentException("Le compartiment [" + type + " " + convertFromCentimes(valeur) + "] n'existe pas");
		}
		lCompartiments.get(0).getArgent().add(type.equals(Monnaie.TYPE_MONNAIE.BILLET) ? new Billet(valeur) : new Piece(valeur));
		total += valeur;
        Comptable.getInstance().historiser("ajouterArgent", uid, type, valeur);
		return false;
	}
	
    /**
     * Retire une unité d'argent d'un compatiment
     * Le compartiment est identifié par la valeur en centimes
     * @param type billet ou piece
     * @param valeur identification du compartiment par sa valeur
     * @return
     */
    private boolean sortirArgent(Monnaie.TYPE_MONNAIE type, int valeur) {
        Optional<Compartiment> compartiment = compartiments.stream().filter(c -> c.getValeur() == valeur).findFirst();
        if (!compartiment.isPresent()) {
            throw new IllegalArgumentException("Pas de compatiment pour la valeur [" + valeur + "]");
        }
        if (compartiment.get().getArgent().size() == 0) {
            System.out.println(getLogPrefix() + "Le " + compartiment.get() + " est vide");
            Comptable.getInstance().historiser("sortirArgent", uid, type, valeur, false);
            return false;
        }
        total -= compartiment.get().getValeur();
        compartiment.get().getArgent().remove(0);
        Comptable.getInstance().historiser("sortirArgent", uid, type, valeur, true);
        return true;
    }

	@Override
	public void afficherRenduMonnaie(double dPrice, double dGiven) {
        Comptable.getInstance().historiser("giveChange", dPrice, dGiven);
        if (dGiven < dPrice) {
            throw new IllegalArgumentException("Le montant donné n'est pas suffisant");
        }
        int price = convertToCentimes(dPrice);
        int given = convertToCentimes(dGiven);
        int due = given - price;
        boolean first = true;
        for (int i = compartiments.size() - 1; i >= 0; i--) {
            Compartiment compartiment = compartiments.get(i);
            int nb = (int) (due / (compartiment.getValeur()));
            if (nb > 0) {
            	if (first) {
            		System.out.println(getLogPrefix() + "Prix : " + dPrice + " - donné : " + dGiven + " - à rendre : ");
            		first = false;
            	}
                due -= nb*compartiment.getValeur();
                System.out.println(getLogPrefix() + "  " + nb + " " + compartiment.getType() + "(s) de " + convertFromCentimes(compartiment.getValeur()));
            }
        }
	}

	public double cloturer() {
		return convertFromCentimes(total);
	}
	
	public String getUid() {
		return uid;
	}
	
	private String getLogPrefix() {
		return "[" + uid + "] ";
	}
	
	private int convertToCentimes(double valeur) {
		return (int)(valeur * 100);
	}
	
	private double convertFromCentimes(int valeur) {
		return ((valeur * 1.0) / 100);
	}
	
	public static void main(String[] args) {
		
		// creation fond de caisse
		FondDeCaisse fdc = new FondDeCaisseFR();
		
		// creation et ajout argent dans fond de caisse
		InfoMonnaie infoMonnaie = fdc.getInfoMonnaie();
		for (int billet : infoMonnaie.getValeursBillet()) {
			for (int i = 0; i < 2; i++) {
				fdc.getArgent().add(new Billet(billet * 100));
			}
		}
		for (double piece : infoMonnaie.getValeursPiece()) {
			for (int i = 0; i < 10; i++) {
				fdc.getArgent().add(new Piece((int)(piece * 100)));
			}
		}
		fdc.afficherContenu();
		
		// creation caisse
		ICaisse caisse = new Caisse(fdc);
		caisse.afficherContenu();	
		caisse.afficherTotal();
		
		//FondDeCaisse fdcUS = new FondDeCaisseUS();
		//fdcUS.getArgent().addAll(
		//		Arrays.stream(fdcUS.getInfoMonnaie().getValeursBillet())
		//			.mapToObj(b -> { return new Billet(b * 100); } ).collect(Collectors.toList())));
	}
}
