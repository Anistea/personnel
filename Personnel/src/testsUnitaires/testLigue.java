package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	@Test
	void createLigue() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}

	@Test
	void addEmploye() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now(), LocalDate.now()); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	@Test
	void testSetAdministrateur() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe administrateur= ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now(), LocalDate.now()); 
		ligue.setAdministrateur(administrateur);
		assertEquals(administrateur, ligue.getAdministrateur());
	}
	
	@Test
	void getEmployes() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now(), LocalDate.now()); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	@Test
	void compareTo() {
		Ligue ligue = new Ligue("Tiralarc");
		Ligue autre = new Ligue("Fléchettes");
		assertEquals(ligue.compareTo(autre), ligue.getNom().compareTo(autre.getNom()));
		assertTrue(ligue.compareTo(autre) > 0);
		assertEquals(ligue.compareTo(ligue), 0);
		assertTrue(autre.compareTo(ligue) < 0);

		
	}
	
	@Test
	void testSetNom() {
		String ligue = "Tiralarc";
		String ligue2 = "Fléchettes";
		Ligue laligue = new Ligue(ligue);
		laligue.setNom(ligue2);
		assertEquals(laligue.getNom(), ligue2);
		assertTrue(laligue.getNom() != ligue);
	}
	
	@Test
	void remove() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now(), LocalDate.now()); 
		ligue.remove();
		System.out.println(ligue.getEmployes());
		System.out.println(employe.getLigue());
		assertNull(ligue.getEmployes().contains(employe));
		assertNull(employe.getLigue());
		//TODO
	}
}
