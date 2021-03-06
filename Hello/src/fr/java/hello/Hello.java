package fr.java.hello;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		System.out.println("Bonjour le monde");
		// testDesTypesPrimitifs();
		// testComparateurs();
		// testTableaux();
		testScanner();
	}

	private static void testScanner() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisissez un mot");
		
//		String str = sc.nextLine(); // sc.next();
//		System.out.println("Vous avez saisi : " + str);
		
		String str = sc.next();
		System.out.println("Vous avez saisi : " + str);
		str = sc.next();
		System.out.println("Vous avez saisi : " + str);
		
		sc.close();
	}

	@SuppressWarnings("unused")
	private static void testTableaux() {
		int[] monTableau; // int monTableau[];
		monTableau = new int[3];
		System.out.println(monTableau[1]);
		monTableau[1] = 1999;
		System.out.println(monTableau.length);
		
		String[] monTab = {"chaineA", "chaineB", "chaineC", "chaineD"};
		// String[] autreTab = monTab;
		String[] autreTab = new String[3];
		// System.arraycopy(monTab, 0, autreTab, 0, 3);
		autreTab = monTab.clone();
		
		monTab[0] = "chaineAmodifiee";
		System.out.println(autreTab[3]);
		
		for (String uneChaine : monTab) {
			System.out.println(uneChaine);
		}
	}

	@SuppressWarnings("unused")
	private static void testComparateurs() {
		int x = 10;
		x += 10;
		System.out.println(x);
		
		//x++;
		++x;
		System.out.println(x);
		
		int a = 5;
		int b = 6;
		boolean res = a == b; // <= >= !=
		System.out.println(res);
		
		String chaineA = "Bonjour";
		String chaineB = "Bon" + "jour";
		
		res = chaineA == chaineB;
		System.out.println(res);
		
		res = chaineA.equals(chaineB);
		System.out.println(res);
		
		// Là on a un souci -- Jérome
		String s1 = "BONJOUR";
		String s2 = "bonjour";
		System.out.println(s1 == s2.toUpperCase());
		System.out.println(s1.equals(s2.toUpperCase()));
		
		// && || ! : opérateur booléens		
	}
	
	@SuppressWarnings("unused")
	private static void testDesTypesPrimitifs() {
		// Un nom de variable commence par une lettre
		// Peut contenir des lettres ou des nombres ou _ ou $

		// Classe number, Long par exemple est une sous-classe
		
		// Variables : type Nom = Maximum
		// type.MAX_VALUE; Pour les max
		// Out of range; prendre le L pour interpréter en litéral
		// Par défaut un chiffre à virgule est un double, il faut donc F pour les float en litéral, D pour les double en litéral
		// Possibilité de séparer les chiffres avec _ tel 922_337_203_685_477_580_7L
		
		// Entier sur un octet
		byte entierSurUnOctet = 127; // -128
		System.out.println(entierSurUnOctet);
		
		// Entier court
		short unCourt = 32767; 
		System.out.println(unCourt);
		
		// Entier
		int vitesse = 2147483647;
		System.out.println(vitesse);
		
		// Entier long
		long max = Long.MAX_VALUE;
		System.out.println(max);
		
		// Le flottant
		float unFlottant = 3.141592654F;
		System.out.println(unFlottant);
		
		// Le double
		double unDouble = 3.14159265359D; // 0.0004243e3D possible exponentiel
		System.out.println(unDouble);
		
		// Booléen
		boolean isValid = true;
		System.out.println(isValid);
		
		// Le caractère unicode
		char unCaractere = 'a';
		char unAutreCaractere = '\u8723';
		System.out.println(unCaractere);
		System.out.println(unAutreCaractere);
		
		
		// String est une classe
		
		// Chaine de caractères
		String uneChaine = "Ceci est une chaine";
		String uneAutreChaine = new String("Ma chaine de caractère");
		
		System.out.println(uneChaine);
		System.out.println(uneAutreChaine);
		
		System.out.println("Le résultat est " + unDouble);
		System.out.println("Le résultat est " + isValid);
		
		System.out.println("\""); // String
		System.out.println('a'); // Caractère
		
		double calcul = 10d/3;
		int res = (int) calcul;
		System.out.println(res);
		
		byte petitNombre = (byte) 129;
		System.out.println(petitNombre);
		
		// Méthodes sur les chaines
		uneChaine = uneChaine.toUpperCase();
		//System.out.println(uneChaine.toUpperCase());
		System.out.println(uneChaine);
		
		int x = 10;
		x = traiteNombre(x);
		System.out.println(x);
	}

	private static int traiteNombre(int y) {
		y = y * 2;
		return y;
	}

}
