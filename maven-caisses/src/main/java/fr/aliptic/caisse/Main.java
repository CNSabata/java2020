package fr.aliptic.caisse;

public class Main {

	public static void main(String[] args) {
		FondDeCaisseFactory fdcFactory = new FondDeCaisseFRFactory();
		FondDeCaisse fdc = fdcFactory.creerFondDeCaisse(10000 / 100);
		
//		InfoMonnaie infoMonnaie = fdc.getInfoMonnaie();
//		
//		for (int billet : infoMonnaie.getValeursBillets()) {
//			for (int i = 0; i < 2; i++) {
//				fdc.getArgent()
//				.add(new Billet(billet * 100, Integer.toString(billet)));
//			}
//		}
//		
//		for (double piece : infoMonnaie.getValeursPieces()) {
//			for (int i = 0; i < 2; i++) {
//				fdc.getArgent()
//				.add(new Piece((int)(piece * 100), Double.toString(piece)));
//			}
//		}
//		

		// fdc.afficherContenu();
		Caisse caisse = new Caisse(fdc);
		caisse.afficherContenu();
	}

}
