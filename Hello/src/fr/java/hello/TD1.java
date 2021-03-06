package fr.java.hello;
import java.math.BigDecimal;
import java.util.*;

public class TD1 {

	public static void main(String[] args) {
		// testExercice1();
		// testExercice2();
		// testExercice3();
		// testExercice4();
		// testExercice5();
		// testExercice6();
		// testExercice7();
		testExercice8();
	}

	private static void testExercice8() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Entrer une valeur de produit : ");
		double invAmount = scan.nextDouble();
		System.out.println();
		
		System.out.print("Entrer une somme de paiement : ");
		double invMoney = scan.nextDouble();
		System.out.println();
		
		scan.close();
		double invLeft = invMoney - invAmount;
		
		if (invLeft < 0) {
			System.out.println("Saisie invalide");
		} else {
			// Euros
			int e500 = (int)(invLeft / 500); invLeft -= e500 * 500; 
			int e100 = (int)(invLeft / 100); invLeft -= e100 * 100; 
			int e50 =  (int)(invLeft / 50);  invLeft -= e50 * 50;   
			int e20 =  (int)(invLeft / 20);  invLeft -= e20 * 20;   
			int e10 =  (int)(invLeft / 10);  invLeft -= e10 * 10;   
			int e5 =   (int)(invLeft / 5);   invLeft -= e5 * 5;     
			int e2 =   (int)(invLeft / 2);   invLeft -= e2 * 2;     
			int e =    (int)invLeft;         invLeft -= e;          
			
			// Centimes
			invLeft *= 100;
			int c50 =  (int)invLeft / 50;    invLeft -= c50 * 50;   
			int c20 =  (int)invLeft / 20;    invLeft -= c20 * 20;   
			int c10 =  (int)invLeft / 10;    invLeft -= c10 * 10;   
			int c5 =   (int)invLeft / 5;     invLeft -= c5 * 5;     
			int c2 =   (int)invLeft / 2;     invLeft -= c2 * 2;     
			int c =    (int)invLeft;                                   
			
			// Printer
			System.out.println("Voici votre monnaie :");
			
			// Euros
			if (e500 != 0){System.out.println(e500 + " billet(s) de 500€.");}
			if (e100 != 0){System.out.println(e100 + " billet(s) de 100€.");}
			if (e50  != 0){System.out.println(e50  + " billet(s) de 50€.");}
			if (e20  != 0){System.out.println(e20  + " billet(s) de 20€.");}
			if (e10  != 0){System.out.println(e10  + " billet(s) de 10€.");}
			if (e5   != 0){System.out.println(e5   + " billet(s) de 5€.");}
			if (e2   != 0){System.out.println(e2   + " pièce(s) de 2€.");}
			if (e    != 0){System.out.println(e    + " pièce(s) de 1€.");}
			
			// Centimes
			if (c50  != 0){System.out.println(c50  + " pièce(s) de 0.50€.");}
			if (c20  != 0){System.out.println(c20  + " pièce(s) de 0.20€.");}
			if (c10  != 0){System.out.println(c10  + " pièce(s) de 0.10€.");}
			if (c5   != 0){System.out.println(c5   + " pièce(s) de 0.05€.");}
			if (c2   != 0){System.out.println(c2   + " pièce(s) de 0.02€.");}
			if (c    != 0){System.out.println(c    + " pièce(s) de 0.01€.");}
		}
		
	}

	@SuppressWarnings("unused")
	private static void testExercice7() {
		// if (x % 2 == 0) pair else impair
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Entrer un nombre de lignes : ");
		
		scan.close();
		int lignes = scan.nextInt();
		String star = "*"; // str.repeat(nb);
		String space = " "; // Idem
		ArrayList<Integer> odds = new ArrayList<Integer>();
		
		for (int i = 1; odds.size() != lignes; i++) {
		   if (i % 2 != 0) {
			   odds.add(i);
		   }
		}
		
		int j = 1;
		for (int i = lignes; i > 0; i--) {
			System.out.print(space.repeat(i - 1)); // Espace
			System.out.print(star.repeat(odds.get(j - 1))); // Etoile
			j++;
			System.out.println(); // Ligne
		}
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer> oddsRev = (ArrayList<Integer>) odds.clone();
		Collections.reverse(oddsRev);
		
		for (int i = 1; i <= lignes; i++) {
			System.out.print(space.repeat(i - 1)); // Espace
			System.out.print(star.repeat(oddsRev.get(i - 1))); // Etoile
			System.out.println(); // Ligne
		}
		
		
	}

	@SuppressWarnings("unused")
	private static void testExercice6() {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Bienvenue dans le jeu du dé. Voulez vous afficher les options? (O/n)");
		String options = scan.next();
		int coups = 0;
		int coupsMax = Integer.MAX_VALUE;
		int min = 0;
		int max = 0;
		
		if(options.equals("O") || options.equals("o")) {
			System.out.println("En combien de coups maximum voulez vous jouer cette partie?");
			coupsMax = scan.nextInt();
			
			System.out.println("Nombre minimum?");
			min = scan.nextInt();
			
			System.out.println("Nombre maximum?");
			max = scan.nextInt();
		
		} else if (options.equals("N") || options.equals("n")) {
			System.out.println("Pas d'options. Défaut MinMax de 1 à 6, nombre max de coups.");
			min = 1;
			max = 6;
		} else { System.out.println("Entrée invalide"); }

		

		
		// rand.nextInt((max - min) + 1) + min;
		// (Math.random() * ((max - min) + 1)) + min;
		int nb = rand.nextInt((max - min) + 1) + min;
		
		System.out.println("Bien. Commençons.");
		System.out.println("Choissez un nombre entre "+min+" et "+max+" :");
		int choix = 0;
		
		while(choix != nb || coups < coupsMax) {
			choix = scan.nextInt();
			if(choix < nb) {System.out.println("Trop petit");}
			if(choix > nb) {System.out.println("Trop grand");}
			coups++;
		}
		
		scan.close();
		System.out.println("Bravo, vous avez trouvé ! :)");
		System.out.println("Le nombre était  : " + nb);
		System.out.println("Il vous à fallu : " + coups + " coups.");
	}

	@SuppressWarnings("unused")
	private static void testExercice5() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Veuillez saisir un jour, un mois, puis une année (date) :");
		int jour = scan.nextInt();
		int mois = scan.nextInt();
		int annee = scan.nextInt();
		scan.close();
		
		boolean jourValide = false;
		boolean moisValide = false;
		boolean anneeValide = false;
		
		boolean bissextile = false;
		
		// Check année valide
		if (annee > 0) {
			anneeValide = true;
		}
		
		// Check bissextile
		if( (annee % 4 == 0 && annee % 100 != 0)||(annee % 400 == 0) ) {
			bissextile = true;
		}

		// Check jour valide
		if(mois <= 12 && mois > 0) {
			moisValide = true; // Check mois valide
			switch (mois) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if(jour <= 31 && jour > 0) {
						jourValide = true;
					}
					break;
				case 2:
					if(jour <= 29 && bissextile == true && jour > 0) {
						jourValide = true;
					}
					else if(jour <= 28 && bissextile == false && jour > 0) {
						jourValide = true;
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if(jour <= 30 && jour > 0) {
						jourValide = true;
					}
					break;
			}
		}
		
		// Le grand final
		if (jourValide == true && moisValide == true && anneeValide == true ) {
			System.out.println("La date est valide");
		}
		else {
			System.out.println("La date est invalide");
		}
	}

	@SuppressWarnings("unused")
	private static void testExercice4() {
		int[] notes = {12, 18, 8, 15, 7, 11, 15, 16};
		
		int min = Arrays.stream(notes).min().getAsInt();
		int max = Arrays.stream(notes).max().getAsInt();
		double avg = Arrays.stream(notes).average().getAsDouble();
		
		int sup10 = 0;
	      for(int i = 0; i < notes.length; i++) {
	          if(notes[i] > 10) {
	             sup10++;
	          }
	      }
	    int supAvg = 0;
	      for(int k = 0; k < notes.length; k++) {
	          if(notes[k] > avg) {
	             supAvg++;
	          }
	      }
	    
	    System.out.println("Les résultats :");
	    System.out.println("Valeur minimale = "					 + min);
	    System.out.println("Valeur maximale = "					 + max);
	    System.out.println("Valeur moyenne = "					 + avg);
	    System.out.println("Nb valeurs supérieures à 10 = "		 + sup10);
	    System.out.println("Nb valeurs supérieures à la moyenne = " + supAvg);
		
	}

	@SuppressWarnings("unused")
	private static void testExercice3() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Veuillez saisir trois nombres :");
		int Num1 = scan.nextInt();
		int Num2 = scan.nextInt();
		int Num3 = scan.nextInt();
		scan.close();
		
		if(Num1 == Num2 && Num2 == Num3 && Num1 == Num3) {
			System.out.println("Les trois nombres sont égaux");
		}
		else if(Num1 == Num2 || Num1 == Num3 || Num2 == Num3) {
			System.out.println("Deux nombres sont égaux");
		}
		else {
			System.out.println("Il n'a pas d'égaux dans ces nombres");
		}
	}

	@SuppressWarnings("unused")
	private static void testExercice2() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Combien de photocopies voulez-vous effectuer?");
		int copyNum = scan.nextInt();
		scan.close();
		
		String str = "Vous devez payer : ";
		String str2 = "Au revoir et bonne journée :)";
		BigDecimal prixFinal;
		
		if(copyNum <= 10 && copyNum > 0) {
			BigDecimal prix10 = new BigDecimal("0.10");
			prixFinal = BigDecimal.valueOf(copyNum).multiply(prix10);
			System.out.println(str + prixFinal);
			System.out.println("Prix unitaire = " + prix10);
			System.out.println(str2);
		}
		
		if(copyNum <= 30 && copyNum > 10) {
			BigDecimal prix20 = new BigDecimal("0.09");
			prixFinal = BigDecimal.valueOf(copyNum).multiply(prix20);
			System.out.println(str + prixFinal);
			System.out.println("Prix unitaire = " + prix20);
			System.out.println(str2);
		}
		if(copyNum > 30) {
			BigDecimal prix30 = new BigDecimal("0.08");
			prixFinal = BigDecimal.valueOf(copyNum).multiply(prix30);
			System.out.println(str + prixFinal);
			System.out.println("Prix unitaire = " + prix30);
			System.out.println(str2);
		}
		
	}

	@SuppressWarnings("unused")
	private static void testExercice1() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Quel est votre âge?");
		int ageEnfant = scan.nextInt();
		scan.close();
		
		String str = "Vous êtes dans la catégorie ";
		char dot = '.';
		
		switch(ageEnfant) {
			case 6:
			case 7:
				System.out.println(str + "poussin" + dot);
				break;
			case 8:
			case 9:
				System.out.println(str + "pupille" + dot);
				break;
			case 10:
			case 11:
				System.out.println(str + "minime" + dot);
				break;
			case 12:
				System.out.println(str + "cadet" + dot);
				break;
		}
	}

}
