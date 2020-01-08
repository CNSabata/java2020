package fr.demo;

public class Client {
	private int identifiant;
	private int anneeInscription;
	private String nom;
	private String prenom;
	private String rue;
	private String ville;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Client(int id, int annee) {
		identifiant = id;
		anneeInscription = annee;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public int getAnneeInscription() {
		return anneeInscription;
	}

	public void setAnneeInscription(int anneeInscription) {
		this.anneeInscription = anneeInscription;
	}
	
	public void afficherIdentite() {
		System.out.println(prenom + " " + nom);
	}
	
	public void afficherAdresse() {
		System.out.println(rue + "\n" + ville);
	}
	
	
}
