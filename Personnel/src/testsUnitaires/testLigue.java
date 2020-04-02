package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
	@Test
	void createLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}

	@Test
	void addEmploye() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now()); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	@Test
	void testSetAdministrateur() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe administrateur= ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now()); 
		ligue.setAdministrateur(administrateur);
		assertEquals(administrateur, ligue.getAdministrateur());
	}
	
	@Test
	void getEmployes() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now()); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	@Test
	void compareTo() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Tiralarc");
		Ligue autre = gestionPersonnel.addLigue("Fléchettes");
		assertEquals(ligue.compareTo(autre), ligue.getNom().compareTo(autre.getNom()));
		assertTrue(ligue.compareTo(autre) > 0);
		assertEquals(ligue.compareTo(ligue), 0);
		assertTrue(autre.compareTo(ligue) < 0);

		
	}
	
	@Test
	void testSetNom() throws SauvegardeImpossible
	{
		String ligue = "Tiralarc";
		String ligue2 = "Fléchettes";
		Ligue laligue = gestionPersonnel.addLigue(ligue);
		laligue.setNom(ligue2);
		assertEquals(laligue.getNom(), ligue2);
		assertTrue(laligue.getNom() != ligue);
	}
	
	@Test
	void remove() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.now()); 
		ligue.remove();
		System.out.println(ligue.getEmployes());
		System.out.println(employe.getLigue());
		assertNull(ligue.getEmployes().contains(employe));
		assertNull(employe.getLigue());
		//TODO
	}
}
