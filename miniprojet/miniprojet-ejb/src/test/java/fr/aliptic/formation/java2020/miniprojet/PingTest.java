package fr.aliptic.formation.java2020.miniprojet;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.aliptic.formation.java2020.miniprojet.services.pub.MonServiceRemote;

public class PingTest {
	static MonServiceRemote service;
	
//	@BeforeClass
//	public void toDoBefore() {
//		try {
//			init();
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
	
	@BeforeClass
	public static void init() throws NamingException {
		Hashtable<Object, Object> props = new Hashtable<>();
	    
	    props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
	    props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

	    props.put("jboss.naming.client.ejb.context", false);
	    props.put("org.jboss.ejb.client.scoped.context", true);

	    props.put("endpoint.name", "client-endpoint");
	    props.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", false);
	    props.put("remote.connections", "default");
	    props.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", false);

	    props.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
	    props.put("remote.connection.default.host", "127.0.0.1");
	    props.put("remote.connection.default.port", "8080");
	//  props.put(Context.PROVIDER_URL,"remote://localhost:4447");
	//  props.put(Context.SECURITY_PRINCIPAL, "testuser");
	//  props.put(Context.SECURITY_CREDENTIALS, "testpassword");
	   
	    props.put("jboss.naming.client.ejb.context", true);
	    
	    InitialContext ctx = new InitialContext(props);
	    
	    service = (MonServiceRemote) ctx.lookup("ejb:miniprojet/miniprojet-ejb/MonServiceA!fr.aliptic.formation.java2020.miniprojet.services.pub.MonServiceRemote");
	}
	
	@Test
	public void testConnection() {
		assertEquals("pong", service.ping());
	}
	
	@Test
	public void testDateHeure() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		assertEquals(dtf.format(now), service.getDateHeure());
	}

}

