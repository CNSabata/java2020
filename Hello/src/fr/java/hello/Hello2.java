package fr.java.hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Hello2 {
	
	public static void main(String[] args) {
//		try {
//			System.out.println("Bonjour " + args[0]);
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("Il y a eu une erreur.");
//			System.out.println(e.getMessage());
//		}
		// traiterFichier();
		traiterChange();
	}

	private static void traiterChange() {
		System.out.println(Transaction.taux);
		Transaction tr = new Transaction(12);
		System.out.println(tr.calculChange());
		Transaction tr2 = new Transaction(20);
		System.out.println(tr2.calculChange());
		Transaction tr3 = new Transaction(30);
		System.out.println(tr3.calculChange());
		
		Transaction.taux = 2;
		
		Transaction tr4 = new Transaction(12);
		System.out.println(tr4.calculChange());
		Transaction tr5 = new Transaction(20);
		System.out.println(tr5.calculChange());
		Transaction tr6 = new Transaction(30);
		System.out.println(tr6.calculChange());
		
//		Integer temperature = new Integer(123);
//		Integer temperature = Integer.valueOf(123);
//		int max = Integer.MAX_VALUE;
	}

	@SuppressWarnings("unused")
	private static void traiterFichier() {
		File file = new File("\\home\\yper\\fichier.txt");
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			String line;
			line = bufferReader.readLine();
			bufferReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
