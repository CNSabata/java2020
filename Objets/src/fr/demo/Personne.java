package fr.demo;

public class Personne extends Client {
	private String nom;
	private String prenom;
	
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
	
	@Override
	public void afficherIdentite() {
		System.out.println(prenom + " " + nom);
	}

	public Personne(int id, int annee) {
		super(id, annee);
		// TODO Auto-generated constructor stub
	}

}
