package fr.demo;

public class Entreprise extends Client {
	private String numeroSiret;
	private String denomination;
	
	
	public String getNumeroSiret() {
		return numeroSiret;
	}


	public void setNumeroSiret(String numeroSiret) {
		this.numeroSiret = numeroSiret;
	}


	public String getDenomination() {
		return denomination;
	}


	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}


	public Entreprise(int id, int annee) {
		super(id, annee);
		// TODO Auto-generated constructor stub
	}

}
