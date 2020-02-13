package fr.aliptic.formation.java2020.miniprojet.services.priv;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.aliptic.formation.java2020.miniprojet.services.pub.MonServiceRemote;

@Stateless
public class MonServiceA implements MonServiceRemote {
	
	@EJB
	private MonServiceB servB;


	@Override
	public String ping() {
		return "pong";
	}

	public String getDateHeure() {
		return servB.getDateHeure();
	}
	
}
