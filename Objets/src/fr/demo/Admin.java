package fr.demo;

public class Admin {

	public static void main(String[] args) {
		Personne personne = new Personne(123, 1999);
		personne.setAnneeInscription(2000);
		personne.setNom("Wayne");
		personne.setPrenom("John");
		Adresse adressePers = new Adresse("45 rue Jean Jaurès", "87000 Limoges");
		personne.setAdresse(adressePers);
		
		if(personne.getAdresse() != null)
			personne.getAdresse().afficherAdressePostale();
		
//		System.out.println(personne.getIdentifiant());
//		System.out.println(personne.getAnneeInscription());
		
		personne.afficherIdentite();
		
		System.out.println();
		
		Entreprise entreprise = new Entreprise(124, 2010);
		entreprise.setDenomination("MonEntreprise");
		entreprise.setNumeroSiret(1234567890);
		entreprise.setAdresse(new Adresse("33 rue Balzac", "87000 Limoges"));
		
		entreprise.afficherIdentite();
		if(entreprise.getAdresse() != null)
			entreprise.getAdresse().afficherAdressePostale();
	}

}
