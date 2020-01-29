package fr.java.hello;

import java.util.Scanner;

public class TD2 {

	public static void main(String[] args) {
		testExercice1();

	}

	private static void testExercice1() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Veuillez indiquer le prix à payer : ");
		double prix = scan.nextDouble();
		
		System.out.print("Veuillez indiquer avec quoi payer : ");
		double monnaie = scan.nextDouble();
		
		scan.close();
		int    billArr[] = {500, 200, 100, 50, 20, 10, 5};
		double centArr[] = {2, 1, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};
		char   devise = '€';
		double restant = monnaie - prix;
		
		if(prix > monnaie) {
			System.out.println("Vous n'avez pas assez pour payer.");
		}
		else {
			for (int i = 0; i < billArr.length; i++) {
				int count = (int)(restant / billArr[i]);
				String mul = "";
				
				if(count > 0) {
				    restant = restant - count * billArr[i];
				    if(count > 1)
				    	mul = "s";
					System.out.println("Il vous reste " + count + " billet" + mul + " de " + billArr[i] + devise);
				}
			}
			for (int i = 0; i < centArr.length; i++) {
				int count = (int)(restant / centArr[i]);
				String mul = "";
	
				if(count > 0) {
					restant = restant - count * centArr[i];
				    if(count > 1)
				    	mul = "s";
					System.out.println("Il vous reste " + count + " pièce" + mul + " de " + centArr[i] + devise);
				}
			}
			
			// System.out.println("Voici votre monnaie = ");
		}
		
		
	}

}
