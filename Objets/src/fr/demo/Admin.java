package fr.demo;

public class Admin {

	public static void main(String[] args) {
		Personne personne = new Personne(123, 1999);
		
		System.out.println(personne.getIdentifiant());
		System.out.println(personne.getAnneeInscription());
	}

}