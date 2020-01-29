package aliptic.java.change.simple;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		CaisseOrchestrateur orchestrateur = new CaisseOrchestrateur();
		
		double fondDeCaisse = 4*10000 + 1*10000;

		orchestrateur.addConfiguration(new FondDeCaisseFRFactory(), 4, 10000);
		orchestrateur.addConfiguration(new FondDeCaisseUSFactory(), 1, 10000);

		System.out.println("");
		System.out.println(">>> demarrer journee");
		System.out.println("");
		
		orchestrateur.demarrerJournee();

		List<ICaisse> caisses = orchestrateur.getCaisses();
		
		System.out.println("");
		System.out.println(">>> afficher contenu");
		System.out.println("");
		
		for (ICaisse caisse : caisses) {
			caisse.afficherContenu();
		}

		System.out.println("");
		System.out.println(">>> afficher total, afficher rendu monnaie, entrees / sorties, afficher total");
		System.out.println("");

		for (ICaisse caisse : caisses) {
			caisse.afficherTotal();
			caisse.afficherRenduMonnaie(120, 150);
			caisse.entree(Monnaie.TYPE_MONNAIE.BILLET, 100);
			caisse.entree(Monnaie.TYPE_MONNAIE.BILLET, 50);
			caisse.sortie(Monnaie.TYPE_MONNAIE.BILLET, 10);
			caisse.sortie(Monnaie.TYPE_MONNAIE.BILLET, 10);
			caisse.sortie(Monnaie.TYPE_MONNAIE.BILLET, 10);
			caisse.afficherTotal();
		}
		
		System.out.println("");
		System.out.println(">>> controler les caisses");
		System.out.println("");

		for (IAdministrable caisse : caisses) {
			caisse.verifierCoherence();
		}

		System.out.println("");
		System.out.println(">>> terminer journee");
		System.out.println("");
		
		double total = orchestrateur.terminerJournee();
		double recette = total - fondDeCaisse;
		
		System.out.println(">>> RECETTE journee : " + Double.toString(recette));

	}
}
