package aliptic.java.change.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaisseOrchestrateur {

	private Map<FondDeCaisseFactory, Configuration> configurations = new HashMap<FondDeCaisseFactory, Configuration>();
	private List<ICaisse> caisses;
	
	public void addConfiguration(FondDeCaisseFactory factory, int nbCaisses, double montantFondDeCaisse) {
		configurations.put(factory, new Configuration(nbCaisses, montantFondDeCaisse));
	}
	
	public int demarrerJournee() {
		caisses = new ArrayList<ICaisse>();
		for (FondDeCaisseFactory factory : configurations.keySet()) {
			Configuration config = configurations.get(factory);
			for (int i = 0; i < config.getNbCaisses(); i++) {
				FondDeCaisse fdc = factory.creerFondDeCaisse(config.getMontantFondDeCaisse());
	            caisses.add(new Caisse(fdc));
			}
		}
		return caisses.size();
	}	
	
	public double terminerJournee() {
		double total = 0;
		for (ICaisse caisse : caisses) {
			total += caisse.cloturer();
		}
		caisses = null;
		return total;
	}
	
	public List<ICaisse> getCaisses() {
		return caisses;
	}

	private class Configuration {
		private int nbCaisses;
		private double montantFondDeCaisse;
		public Configuration(int nbCaisses, double montantFondDeCaisse) {
			this.nbCaisses = nbCaisses;
			this.montantFondDeCaisse = montantFondDeCaisse;
		}
		public int getNbCaisses() {
			return nbCaisses;
		}
		public double getMontantFondDeCaisse() {
			return montantFondDeCaisse;
		}
	}
}
