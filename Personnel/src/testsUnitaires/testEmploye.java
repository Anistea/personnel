package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import personnel.Employe;
import personnel.Ligue;
import personnel.SauvegardeImpossible;
import personnel.GestionPersonnel;

class TestEmploye {

	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	@Test
	void testEmploye() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now()); 
		assertTrue(ligue.getEmployes().contains(employe));
		assertEquals(employe.getLigue(),ligue);
	}
	
	@Test
	void testEstAdmin() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		ligue.setAdministrateur(employe);
		assertTrue(employe.estAdmin(ligue));
	}
	
	@Test
	void testEstRoot() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Tiralarc");
		Employe root = GestionPersonnel.getGestionPersonnel().getRoot();
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		assertTrue(root.estRoot());
		assertFalse(employe.estRoot());
		
		
	}
	
	@Test
	void testSetNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		String nom = "Druquer";
		employe.setNom(nom);
		assertEquals(employe.getNom(),nom);
	}

	
	@Test
	void testSetPrenom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		String prénom = "JeanMichel";
		employe.setPrenom(prénom);
		assertEquals(employe.getPrenom(),prénom);
	}

	
	@Test
	void testSetMail() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		String mail = "JeanMichelDruquer@gmail.com";
		employe.setMail(mail);
		assertEquals(employe.getMail(),mail);
	}

	@Test
	void testCheckPassword() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		String mdp = "motdepasse";
		assertTrue(employe.checkPassword(mdp));
		assertFalse(employe.checkPassword("titidu94"));
	}

	@Test
	void testSetPassword() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		String password = "titus94";
		employe.setPassword(password);
		assertTrue(employe.checkPassword(password));
		assertFalse(employe.checkPassword("titidu94"));
		
	}

	@Test
	void testGetLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		assertEquals(employe.getLigue(), ligue);
	}
	
	@Test
	void testRemove() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Tiralarc");
		Employe employe1 = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		Employe employe2 = GestionPersonnel.getGestionPersonnel().getRoot();
		ligue.setAdministrateur(employe1);
		employe1.remove();
		assertFalse(ligue.getEmployes().contains(employe1));
		assertNull(employe1.getLigue());
		assertTrue(ligue.getAdministrateur().equals(employe2));
	}
	
	@Test
	void testCompareTo() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Tiralarc");
		Employe employe1 = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		Employe employe2 = ligue.addEmploye("Pierre","Castor","Pierrecastor@gmail.com","histoire",LocalDate.now());
		assertNotEquals(employe1.getPrenom().compareTo(employe2.getPrenom()),0);
	}
	
	@Test
	void testToString() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		assertEquals(employe.toString(), "Bouchar Gérard g.bouchar@gmail.com ("+ligue.toString()+")");
	}
	@Test
	void testSetDateFin() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		LocalDate date = LocalDate.of(2010, 01, 01);
		employe.setDateFin(date);
		assertEquals(employe.getDateFin(), date);
	}
	
	@Test
	void testSetDateDebut() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Tiralarc");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty",LocalDate.now());
		LocalDate date = LocalDate.of(2020, 02, 02);
		employe.setDateDebut(date);
		assertEquals(employe.getDateDebut(), date);
	}
}
