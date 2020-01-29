package aliptic.java.change.simple;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;

@Testable
public class ArgentTest {

	@BeforeAll
	public static void doToBeforeEachTest() {
		System.out.println("to do before...");
	}
	
	@AfterAll
	public static void after() {
		System.out.println("to do after...");
	}
	
	@Test
	public void testCreerBillet() {
		System.out.println("test creerFDCTest");
		Billet billet = new Billet(100);
		assertTrue(billet instanceof Argent);
	}
}
