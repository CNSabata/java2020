package fr.demo;

public class Admin {

	public static void main(String[] args) {
		Personne personne = new Personne(123, 1999);
		personne.setAnneeInscription(2000);
		personne.setNom("Wayne");
		personne.setPrenom("John");
		personne.setRue("45 rue Jean Jaures");
		personne.setVille("87000 Limoges");
		
//		System.out.println(personne.getIdentifiant());
//		System.out.println(personne.getAnneeInscription());
		
		personne.afficherIdentite();
		personne.afficherAdresse();
		
		System.out.println();
		
		Entreprise entreprise = new Entreprise(124, 2010);
		entreprise.setDenomination("MonEntreprise");
		entreprise.setNumeroSiret(1234567890);
		entreprise.setRue("12 Place de la République");
		entreprise.setVille("87000 Limoges");
		
		entreprise.afficherIdentite();
		entreprise.afficherAdresse();
	}

}
