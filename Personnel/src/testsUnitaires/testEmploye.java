package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import personnel.Employe;
import personnel.Ligue;
import personnel.GestionPersonnel;

class TestEmploye {


	@Test
	void testEmploye() {
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now(),LocalDate.now()); 
		assertTrue(ligue.getEmployes().contains(employe));
		assertEquals(employe.getLigue(),ligue);
	}
	
	@Test
	void testEstAdmin() {
		Ligue ligue = new Ligue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now(),LocalDate.now());
		ligue.setAdministrateur(employe);
		assertTrue(employe.estAdmin(ligue));
	}
	
	@Test
	void testEstRoot() {
		Employe root = GestionPersonnel.getGestionPersonnel().getRoot();
		assertTrue(root.estRoot());
	}
	
	@Test
	void testSetNom() {
		Ligue ligue = new Ligue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now(),LocalDate.now());
		String nom = "Druquer";
		employe.setNom(nom);
		assertEquals(employe.getNom(),nom);
	}

	
	@Test
	void testSetPrenom() {
		Ligue ligue = new Ligue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now(),LocalDate.now());
		String prénom = "JeanMichel";
		employe.setPrenom(prénom);
		assertEquals(employe.getPrenom(),prénom);
	}

	
	@Test
	void testSetMail() {
		Ligue ligue = new Ligue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now(),LocalDate.now());
		String mail = "JeanMichelDruquer@gmail.com";
		employe.setMail(mail);
		assertEquals(employe.getMail(),mail);
	}

	@Test
	void testCheckPassword() {
		Ligue ligue = new Ligue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now(),LocalDate.now());
		String mdp = "motdepasse";
		assertTrue(employe.checkPassword(mdp));
		assertFalse(employe.checkPassword("titidu94"));
	}

	@Test
	void testSetPassword() {
		Ligue ligue = new Ligue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now(),LocalDate.now());
		String password = "titus94";
		employe.setPassword(password);
		assertTrue(employe.checkPassword(password));
		assertFalse(employe.checkPassword("titidu94"));
		
	}

	@Test
	void testGetLigue() {
		Ligue ligue = new Ligue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now(),LocalDate.now());
		assertEquals(employe.getLigue(), ligue);
	}
	
	@Test
	void testRemove() {
		Ligue ligue = new Ligue("Tiralarc");
		Employe employe1 = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now(),LocalDate.now());
		Employe employe2 = GestionPersonnel.getGestionPersonnel().getRoot();
		employe1.estAdmin(ligue);
		employe1.remove();
		assertFalse(ligue.getEmployes().contains(employe1));
		assertNull(employe1.getLigue());
		assertTrue(ligue.getAdministrateur().equals(employe2));
	}
	
	@Test
	void testCompareTo() {
		Ligue ligue = new Ligue("Tiralarc");
		Employe employe1 = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now(),LocalDate.now());
		Employe employe2 = ligue.addEmploye("Pierre","Castor","Pierrecastor@gmail.com","histoire",LocalDate.now(),LocalDate.now());
		assertNotEquals(employe1.getPrenom().compareTo(employe2.getPrenom()),0);
	}
	
	@Test
	void testToString() {
		Ligue ligue = new Ligue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now(),LocalDate.now());
		assertEquals(employe.toString(), "Bouchar Gérard g.bouchar@gmail.com ("+ligue.toString()+")");
	}
	@Test
	void testSetDateFin() {
		Ligue ligue = new Ligue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now(),LocalDate.now());
		LocalDate date = LocalDate.of(2010, 01, 01);
		employe.setDateFin(date);
		assertTrue(employe.getDateFin()==date);
	}
	
	@Test
	void testSetDateDebut() {
		Ligue ligue = new Ligue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now(),LocalDate.now());
		LocalDate date = LocalDate.of(2020, 02, 02);
		employe.setDateDebut(date);
		assertTrue(employe.getDateDebut()==date);
	}
}
