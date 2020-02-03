package personnel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Gestion du personnel. Un seul objet de cette classe existe.
 * Il n'est pas possible d'instancier directement cette classe, 
 * la m�thode {@link #getGestionPersonnel getGestionPersonnel} 
 * le fait automatiquement et retourne toujours le m�me objet.
 * Dans le cas où {@link #sauvegarder()} a été appel� lors 
 * d'une ex�cution pr�c�dente, c'est l'objet sauvegard� qui est
 * retourn�.
 */

public class GestionPersonnel implements Serializable
{
	private static final long serialVersionUID = -105283113987886425L;
	private static GestionPersonnel gestionPersonnel = null;
	private SortedSet<Ligue> ligues;
	private Employe root = new Employe(null, "root", "", "","toor",LocalDate.now());
	private static Passerelle passerelle = new serialisation.Serialization();
	
	/**
	 * Retourne l'unique instance de cette classe.
	 * Cr�e cet objet s'il n'existe d�j�.
	 * @return l'unique objet de type {@link GestionPersonnel}.
	 */
	
	public static GestionPersonnel getGestionPersonnel()
	{
		if (gestionPersonnel == null)
		{
			gestionPersonnel = passerelle.getGestionPersonnel();
			if (gestionPersonnel == null)
				gestionPersonnel = new GestionPersonnel();
		}
		return gestionPersonnel;
	}

	private GestionPersonnel()
	{
		ligues = new TreeSet<>();
	}
	
	public void sauvegarder() throws SauvegardeImpossible
	{
		passerelle.sauvegarderGestionPersonnel(this);
	}
	
	/**
	 * Retourne la ligue dont administrateur est l'administrateur,
	 * null s'il n'est pas un administrateur.
	 * @param administrateur l'administrateur de la ligue recherch�e.
	 * @return la ligue dont administrateur est l'administrateur.
	 */
	
	public Ligue getLigue(Employe administrateur)
	{
		if (administrateur.estAdmin(administrateur.getLigue()))
			return administrateur.getLigue();
		else
			return null;
	}

	/**
	 * Retourne toutes les ligues enregistr�es.
	 * @return toutes les ligues enregistr�es.
	 */
	
	public SortedSet<Ligue> getLigues()
	{
		return Collections.unmodifiableSortedSet(ligues);
	}

	void add(Ligue ligue)
	{
		ligues.add(ligue);
	}
	

	void remove(Ligue ligue)
	{
		ligues.remove(ligue);
	}

	/**
	 * Retourne le root (super-utilisateur).
	 * @return le root.
	 */
	
	public Employe getRoot()
	{
		return root;
	}
}
