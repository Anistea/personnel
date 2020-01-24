package personnel;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Employ� d'une ligue h�berg�e par la M2L. Certains peuvent 
 * �tre administrateurs des employ�s de leur ligue.
 * Un seul employ�, rattach� �aucune ligue, est le root.
 * Il est impossible d'instancier directement un employ�, 
 * il faut passer la m�thode {@link Ligue#addEmploye addEmploye}.
 */

public class Employe implements Serializable, Comparable<Employe>
{
	private static final long serialVersionUID = 4795721718037994734L;
	private String nom, prenom, password, mail;
	private Ligue ligue;
	private LocalDate dateFin;
	private LocalDate dateDebut; 
	Employe(Ligue ligue, String nom, String prenom, String mail, String password, LocalDate dateFin, LocalDate dateDebut)
	
	{
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.ligue = ligue;
	}
	
	/**
	 * Retourne vrai ssi l'employ� est administrateur de la ligue 
	 * pass�e en param�tre.
	 * @return vrai ssi l'employ� est administrateur de la ligue 
	 * pass�e en paramètre.
	 * @param ligue la ligue pour laquelle on souhaite v�rifier si this 
	 * est l'admininstrateur.
	 */
	
	public boolean estAdmin(Ligue ligue)
	{
		return ligue.getAdministrateur() == this;
	}
	
	/**
	 * Retourne vrai ssi l'employ� est le root.
	 * @return vrai ssi l'employ� est le root.
	 */
	
	public boolean estRoot()
	{
		return GestionPersonnel.getGestionPersonnel().getRoot() == this;
	}
	
	/**
	 * Retourne la date de cloture des inscriptions.
	 * @return
	 */
	
	public LocalDate getDateFin()
	{
		return dateFin;
	}
	
	public void setDateFin(LocalDate dateFin)
	{
		// TODO vérifier que l'on avance pas la date.
		
		if (this.dateFin.isBefore(dateFin) || dateFin.equals(this.dateFin)) 
			this.dateFin = dateFin;
	else
			throw new RuntimeException("Date de Fin invalide !");
	
	}
	
	
	/***************************************************************************
	 * Retourne la date de debut des inscriptions.
	 * @return
	 */
	
	public LocalDate getDateDebut()
	{
		return dateDebut;
	}
	
	public void setDateDebut(LocalDate dateDebut)
	{
		// TODO vérifier que l'on avance pas la date.
		
		if (this.dateDebut.isBefore(dateDebut) || dateDebut.equals(this.dateDebut)) 
			this.dateDebut = dateDebut;
	else
			throw new RuntimeException("Date de D�but invalide !");
	
	}
	
	/**
	 * Retourne le nom de l'employ�.
	 * @return le nom de l'employ�. 
	 */
	
	public String getNom()
	{
		return nom;
	}

	/**
	 * Change le nom de l'employ�.
	 * @param nom le nouveau nom.
	 */
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Retourne le pr�nom de l'employ�.
	 * @return le pr�nom de l'employ�.
	 */
	
	public String getPrenom()
	{
		return prenom;
	}
	
	/**
	 * Change le pr�nom de l'employ�.
	 * @param prenom le nouveau pr�nom de l'employ�. 
	 */

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	/**
	 * Retourne le mail de l'employ�.
	 * @return le mail de l'employ�.
	 */
	
	public String getMail()
	{
		return mail;
	}
	
	/**
	 * Change le mail de l'employ�.
	 * @param mail le nouveau mail de l'employ�.
	 */

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	/**
	 * Retourne vrai ssi le password pass� en param�tre est bien celui
	 * de l'employ�.
	 * @return vrai ssi le password pass� en param�tre est bien celui
	 * de l'employ�.
	 * @param password le password auquel comparer celui de l'employ�.
	 */
	
	public boolean checkPassword(String password)
	{
		return this.password.equals(password);
	}

	/**
	 * Change le password de l'employ�.
	 * @param password le nouveau password de l'employ�. 
	 */
	
	public void setPassword(String password)
	{
		this.password= password;
	}

	/**
	 * Retourne la ligue à laquelle l'employ� est affect�.
	 * @return la ligue à laquelle l'employ� est affect�.
	 */
	
	public Ligue getLigue()
	{
		return ligue;
	}

	/**
	 * Supprime l'employ�. Si celui-ci est un administrateur, le root
	 * r�cup�re les droits d'administration sur sa ligue.
	 */
	
	public void remove()
	{
		Employe root = GestionPersonnel.getGestionPersonnel().getRoot();
		if (this != root)
		{
			if (estAdmin(getLigue()))
				getLigue().setAdministrateur(root);
			ligue.remove(this);
			this.ligue = null;
		}
		else
			throw new ImpossibleDeSupprimerRoot();
	}

	@Override
	public int compareTo(Employe autre)
	{
		int cmp = getNom().compareTo(autre.getNom());
		if (cmp != 0)
			return cmp;
		return getPrenom().compareTo(autre.getPrenom());
	}
	
	@Override
	public String toString()
	{
		String res = nom + " " + prenom + " " + mail + " (";
		if (estRoot())
			res += "super-utilisateur";
		else
			res += ligue.toString();
		return res + ")";
	}
}
