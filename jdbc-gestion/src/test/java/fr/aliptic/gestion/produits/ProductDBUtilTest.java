package fr.aliptic.gestion.produits;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;


@Testable
public class ProductDBUtilTest {

	public void testAutre() {
		try (Connection connection = 
				ProductDBUtils.getInstance().getConnection()) {
			Statement stmt = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e);
		}
	}
	@Test
	public void testConnection() {
		try {
			ProductDBUtils productDBUtils = ProductDBUtils.getInstance();
			System.out.println(productDBUtils);
			assertNotNull(productDBUtils.getServer(), "La propriété 'server' non valide");
		
			try (Connection connection = productDBUtils.getConnection()) {
				assertNotNull(connection);
			}
			
			Connection connection = null;
			try {
				connection = productDBUtils.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (connection != null) {
					connection.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e);
		}
	}
	
	@Test
	public void testSelectGenProducts() {
		// CF. testSelectProductsOldSchool pour utilisation try / finally
		try {
			ProductDBUtils productDBUtils = ProductDBUtils.getInstance();		
			
			String request = "SELECT * FROM products";
			try (Connection connection = productDBUtils.getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(request); ) {
				
				ResultSetMetaData resultMetaData = resultSet.getMetaData();				
				System.out.println("resultMetaData column count : " + resultMetaData.getColumnCount());
				assertTrue(resultMetaData.getColumnCount() == 9, "9 colonnes dans la table products");
				// ATTENTION : premier indice = 1
				for (int i = 1; i <= resultMetaData.getColumnCount(); i++) {
					System.out.println("column " + 1 + " : " + resultMetaData.getColumnName(i) +  " [" + resultMetaData.getColumnTypeName(i) + "]");
				}
				
				while (resultSet.next()) {
					for (int i = 1; i <= resultMetaData.getColumnCount(); i++) {
						System.out.print(resultSet.getObject(i) + "  #  ");
						if (i == resultMetaData.getColumnCount()) {
							System.out.println("");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e);
		}
	}

	
	// @Test
	public void testSelectProducts() {
		try {
			ProductDBUtils productDBUtils = ProductDBUtils.getInstance();		
			
			String request = "SELECT productCode, productName, productLine "
					+ "FROM products ORDER BY productLine, productName";
			try (Connection connection = productDBUtils.getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(request); ) {				
				while (resultSet.next()) {
					System.out.print(resultSet.getString("productLine") + "  #  ");
					System.out.print(resultSet.getString("productCode") + "  #  ");
					System.out.println(resultSet.getString("productName"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e);
		}
	}

	// @Test
	public void testSelectProductsOldSchool() {
		try {
			ProductDBUtils productDBUtils = ProductDBUtils.getInstance();
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			try {
				connection = productDBUtils.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM products");
				ResultSetMetaData resultMetaData = resultSet.getMetaData();
				
				System.out.println("resultMetaData column count : " + resultMetaData.getColumnCount());
				assertTrue(resultMetaData.getColumnCount() == 9, "9 colonnes dans la table products");
				// ATTENTION : premier indice = 1
				for (int i = 1; i <= resultMetaData.getColumnCount(); i++) {
					System.out.println("column " + 1 + " : " + resultMetaData.getColumnName(i) +  " [" + resultMetaData.getColumnTypeName(i) + "]");
				}
				
				while (resultSet.next()) {
					for (int i = 1; i <= resultMetaData.getColumnCount(); i++) {
						System.out.print("\t" + resultSet.getObject(i) + " # ");
						if (i == resultMetaData.getColumnCount()) {
							System.out.println("");
						}
					}
				}
			} finally {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e);
		}
	}
}
