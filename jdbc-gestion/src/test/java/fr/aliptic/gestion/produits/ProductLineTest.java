package fr.aliptic.gestion.produits;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;


@Testable
public class ProductLineTest {
	//@Test
	public void testProductLineFindAll() {
		System.out.println("/!\\ Test findAll()");
		try (Connection connection = ProductDBUtils.getInstance().getConnection()){
			DAO<ProductLine> productLineDAO = new ProductLineDAO(connection);
			List<ProductLine> productLines = productLineDAO.findAll();
			assertNotNull(productLines, "La liste des lignes de produits ne doit pas être nulle.");
			assertTrue(productLines.size() > 0, "La liste des lignes de produits ne doit pas être vide.");
			productLines.stream().forEach(p -> System.out.println(p));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e);
		}
	}
	
	//@Test
	public void testProductLineFind() {
		System.out.println("/!\\ Test find()");
		try (Connection connection = ProductDBUtils.getInstance().getConnection()){
			DAO<ProductLine> productLineDAO = new ProductLineDAO(connection);
			ProductLine productLine = productLineDAO.find("Classic Cars");
			assertNotNull(productLine, "La ligne de produits ne doit pas être nulle.");
			System.out.println(productLine);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e);
		}
	}
	
	//@Test
	public void testProductLineInsert() {
		System.out.println("/!\\ Test create()");
		try (Connection connection = ProductDBUtils.getInstance().getConnection()){
			DAO<ProductLine> productLineDAO = new ProductLineDAO(connection);
			boolean done = productLineDAO.create(new ProductLine("Supercars", "Ceci est un test", null, null));
			assertTrue(done, "La ligne de produits n'a pas été crée.");
			System.out.println("Success : " + done);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e);
		}
	}
	
	@Test
	public void testProductLineUpdate() {
		System.out.println("/!\\ Test update()");
		try (Connection connection = ProductDBUtils.getInstance().getConnection()){
			DAO<ProductLine> productLineDAO = new ProductLineDAO(connection);
			boolean done = productLineDAO.update(new ProductLine("Supercars", "Test EDIT description", null, null));
			assertTrue(done, "La ligne de produits n'a pas été éditée.");
			System.out.println("Success : " + done);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e);
		}
	}
	
	//@Test
	public void testProductLineDelete() {
		System.out.println("/!\\ Test delete()");
		try (Connection connection = ProductDBUtils.getInstance().getConnection()){
			DAO<ProductLine> productLineDAO = new ProductLineDAO(connection);
			boolean done = productLineDAO.delete(new ProductLine("Supercars", null, null, null));
			assertTrue(done, "La ligne de produits n'a pas été supprimée.");
			System.out.println("Success : " + done);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e);
		}
	}
}
