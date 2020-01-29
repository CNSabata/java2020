package fr.aliptic.gestion.produits;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;

@SuppressWarnings("unused")
@Testable
public class JDBCTest {
	
//	@BeforeAll
//	public static void doToBeforeEachTest() {
//		System.out.println("to do before...");
//	}
//	
//	@AfterAll
//	public static void after() {
//		System.out.println("to do after...");
//	}
	
	@Test
	public void testConnection() {
		System.out.println("/!\\ Test connection");
		try {
			ProductDBUtils pDBU = ProductDBUtils.getInstance();
			assertTrue(pDBU instanceof ProductDBUtils);
			// System.out.println(pDBU);
			assertNotNull(pDBU.getServer(), "La propriété 'server' non valide");
			
			// Ceci est
			try (Connection connection = pDBU.getConnection()){
				assertNotNull(connection);
				System.out.println("Connection OK");
			}
			
			// Equivalent de : 
			/* 
			Connection connection = null;
			try {
				connection = pDBU.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			} // Catch additionnel
			finally {
				if (connection != null)
					connection.close();
			} */
			
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e);
		}
		System.out.println();
	}
	
	@Test
	public void testStatement() {
		System.out.println("/!\\ Test statement");
		try {
			ProductDBUtils pDBU = ProductDBUtils.getInstance();
			assertTrue(pDBU instanceof ProductDBUtils);
			// System.out.println(pDBU);
			assertNotNull(pDBU.getServer(), "La propriété 'server' non valide");
			
			try (Connection con = pDBU.getConnection()){
				assertNotNull(con);
				System.out.println("Connection OK");
			}
			// Ceci est
			try (Statement stmt = pDBU.getConnection().createStatement()){
				assertNotNull(stmt);
				System.out.println("Statement OK");
				pDBU.getConnection().createStatement();
			}
			
			// Equivalent de : 
			/* 
			Connection connection = null;
			try {
				connection = pDBU.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			} // Catch additionnel
			finally {
				if (connection != null)
					connection.close();
			} */
			
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e);
		}
		System.out.println();
	}
	
	@Test
	public void testSelect() {
		System.out.println("/!\\ Test select");
		try {
			ProductDBUtils pDBU = ProductDBUtils.getInstance();
			assertTrue(pDBU instanceof ProductDBUtils);
			// System.out.println(pDBU);
			assertNotNull(pDBU.getServer(), "La propriété 'server' non valide");
			
			// Ceci est
			try (Statement stmt = pDBU.getConnection().createStatement()){
				assertNotNull(stmt);
				System.out.println("Statement OK");
				
				String sql = "SELECT * FROM customers";
				try (ResultSet res = pDBU.getConnection().createStatement().executeQuery(sql)){
					System.out.println("Query OK : ");
					System.out.println("===========");
					
					while(res.next())
						System.out.println(res.getString("customerName") + " | " 
											+ res.getString("contactLastName") + " " 
											+ res.getString("contactFirstName"));
				}
				
			}
			
			// Equivalent de : 
			/* 
			Connection connection = null;
			try {
				connection = pDBU.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			} // Catch additionnel
			finally {
				if (connection != null)
					connection.close();
			} */
			
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e);
		}
	}
	
	@Test
	public void testSelectProducts() {
		System.out.println("/!\\ Test select products");
		try {
			ProductDBUtils pDBU = ProductDBUtils.getInstance();
			
			String req = "SELECT productCode, productName, productLine "
					+ "FROM products ORDER BY productLine, productName";
			
			try (Connection connection = pDBU.getConnection();
					Statement stmt = connection.createStatement();
					ResultSet res = stmt.executeQuery(req)){
				while(res.next()) {
					System.out.print(res.getString("productLine") + " # ");
					System.out.print(res.getString("productCode") + " # ");
					System.out.println(res.getString("productName"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}
}
