package fr.demo;

public class Entreprise extends Client {
	private int numeroSiret;
	private String denomination;
	
	
	public int getNumeroSiret() {
		return numeroSiret;
	}


	public void setNumeroSiret(int i) {
		this.numeroSiret = i;
	}


	public String getDenomination() {
		return denomination;
	}


	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	@Override
	public void afficherIdentite() {
		System.out.println(denomination + " " + numeroSiret);
	}

	public Entreprise(int id, int annee) {
		super(id, annee);
		// TODO Auto-generated constructor stub
	}

}
