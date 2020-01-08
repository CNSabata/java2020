package fr.demo;

public class Admin {

	public static void main(String[] args) {
		Client client = new Client(123, 1999);
		client.setAnneeInscription(2000);
		client.setNom("Wayne");
		client.setPrenom("John");
		client.setRue("45 rue Jean Jaures");
		client.setVille("87000 Limoges");
		
//		System.out.println(personne.getIdentifiant());
//		System.out.println(personne.getAnneeInscription());
		
		client.afficherIdentite();
		client.afficherAdresse();
	}

}
