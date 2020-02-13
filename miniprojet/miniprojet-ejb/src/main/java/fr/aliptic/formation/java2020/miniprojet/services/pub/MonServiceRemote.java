package fr.aliptic.formation.java2020.miniprojet.services.pub;

import javax.ejb.Remote;

@Remote
public interface MonServiceRemote {
	String ping();
	String getDateHeure();
}
