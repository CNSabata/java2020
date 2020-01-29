package fr.aliptic.caisse;

import java.util.*;
import java.util.stream.Collectors;

import fr.aliptic.caisse.Monnaie.TYPE_MONNAIE;

public class Caisse implements ICaisse {
	private String uid = UUID.randomUUID().toString();
	private InfoMonnaie infoMonnaie;
	private List<Compartiment> compartiments = new ArrayList<Compartiment>();
	
	// total en centimes
	private int total = 0;
	
	public Caisse(FondDeCaisse fondDeCaisse) {
		if (fondDeCaisse == null) {
			throw new IllegalArgumentException("Paramètre 'fond de caisse' non valide.");
		}
		
		infoMonnaie = fondDeCaisse.getInfoMonnaie();
		
		total = fondDeCaisse.getArgent().stream().mapToInt(a -> a.getValeur()).sum();
		System.out.println(getLogPrefix() + "total fond de caisse : " + total + " " + infoMonnaie.getNom());

	    // création des compartiments
		for (int valeur : infoMonnaie.getValeursBillets()) {
			compartiments.add(new Compartiment(Monnaie.TYPE_MONNAIE.BILLET, convertToCentimes((double) valeur)));
		}
		for (double valeur : infoMonnaie.getValeursPieces()) {
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
	
	}

	@Override
	public boolean verifierCoherence() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
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
		compartiments.parallelStream().filter(c -> c.getArgent().size() > 0)
		.forEach(c -> System.out.println(getLogPrefix() + c + " nb : " + c.getArgent().size()));
	}
	@Override
	public boolean entree(TYPE_MONNAIE type, double valeur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sortie(TYPE_MONNAIE type, double valeur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afficherRenduMonnaie(double price, double given) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double cloturer() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getUid() {
		return uid;
	}
	
	private String getLogPrefix() {
		return "#" + uid + "| ";
	}
	
	private int convertToCentimes(double valeur) {
		return (int)(valeur * 100);
	}
	
	private double convertFromCentimes(int valeur) {
		return ((valeur * 1.0) / 100);
	}
}
