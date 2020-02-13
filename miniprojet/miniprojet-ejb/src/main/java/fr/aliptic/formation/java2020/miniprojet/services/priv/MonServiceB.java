package fr.aliptic.formation.java2020.miniprojet.services.priv;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
@Stateless
public class MonServiceB {
	
	public String getDate() {    
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		return dtf.format(now);  
	}

	public String getHeure() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		return dtf.format(now); 
	}

	public String getDateHeure() {
			return getDate() + " " + getHeure();
	}   
}
