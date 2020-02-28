package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.getInt;
import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.time.LocalDate;

import commandLineMenus.Menu;
import commandLineMenus.Option;
import personnel.Employe;
import personnel.GestionPersonnel;


public class EmployeConsole 
{
	private Option afficher(final Employe employe)
	{
		return new Option("Afficher l'employ�", "l", () -> {System.out.println(employe);});
	}

	Menu editerEmploye(Employe employe)
	{
		Menu menu = new Menu("G�rer le compte " + employe.getNom(), "c");
		menu.add(afficher(employe));
		menu.add(changerNom(employe));
		menu.add(changerPrenom(employe));
		menu.add(changerMail(employe));
		menu.add(changerPassword(employe));
		menu.add(changerDateDebut(employe));
		menu.add(changerDateFin(employe));
		menu.addBack("q");
		return menu;
	}

	private Option changerNom(final Employe employe)
	{
		return new Option("Changer le nom", "n", 
				() -> {employe.setNom(getString("Nouveau nom : "));}
			);
	}
	
	private Option changerPrenom(final Employe employe)
	{
		return new Option("Changer le pr�nom", "p", () -> {employe.setPrenom(getString("Nouveau pr�nom : "));});
	}
	
	private Option changerMail(final Employe employe)
	{
		return new Option("Changer le mail", "e", () -> {employe.setMail(getString("Nouveau mail : "));});
	}
	
	private Option changerPassword(final Employe employe)
	{
		return new Option("Changer le password", "x", () -> {employe.setPassword(getString("Nouveau password : "));});
	}
	
	private Option changerDateDebut(final Employe employe)
	{
		return new Option("Changer la date de Debut", "D", () -> {employe.setDateDebut(getDate());});
	}
	
	private Option changerDateFin(final Employe employe)
	{
		return new Option("Changer la date de Fin", "F", () -> {employe.setDateFin(getDate());});
	}
	private LocalDate  getDate() {
		int year,month,day;
		year = getInt("  Annee (yyyy) : ");
		month= getInt("  Mois (mm) : ");
		day = getInt("  Jour (jj) : ");
		
		LocalDate date = LocalDate.of(year, month, day);
		return date;
	}

}
