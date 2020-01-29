package fr.aliptic.caisse;

public interface ICaisse extends IAdministrable {
	String getMonnaie();
	double getTotal();
	boolean entree(Monnaie.TYPE_MONNAIE type, double valeur);
	boolean sortie(Monnaie.TYPE_MONNAIE type, double valeur);
	void afficherContenu();
	void afficherTotal();
	void afficherRenduMonnaie(double price, double given);
	double cloturer();
}
