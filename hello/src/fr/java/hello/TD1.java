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
		testExercice7();
	}
	
	private static void testExercice7() {
        int i, space, rows, k=0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter un nombre of lignes : ");
        rows = scan.nextInt();
        String str1 = "  ";
        String str2 = "* ";
        
        List<String> pyramid = new ArrayList<>();
        
        // Pyramide dans le bon sens
        for(i=1; i<=rows; i++){
            for(space=1; space<=(rows-i); space++)
            {
                System.out.print(str1);
                pyramid.add(str1);
            }
            while(k != (2*i-1))
            {
                System.out.print(str2);
                pyramid.add(str2);
                k++;
            }
            k = 0;
            pyramid.add("NL");
            System.out.println();
        }
        
        // Pyramide inversée
        
        List<String> revPyramid = new ArrayList<>();
        
        pyramid.forEach(
        		(var) -> {	String concatStr = "";
        					if(var.equals(str1) || var.equals(str2)) {
        						concatStr = concatStr + var;
        						revPyramid.add(concatStr);
        						
        					} 
        					else if(var.equals("NL")) {
        						concatStr = "";
        						revPyramid.add(var);
        					} 
        				}
        			);
        
        Collections.reverse(revPyramid);
        revPyramid.forEach((var) -> {
        	if(!var.equals("NL")) {
        		System.out.print(var);
        	} else if (var.equals("NL")) {
        		System.out.println();
        	}
        	
        });
        
	}

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
