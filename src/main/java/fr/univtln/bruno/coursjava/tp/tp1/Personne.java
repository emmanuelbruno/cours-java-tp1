/**
 * 
 */
package fr.univtln.bruno.coursjava.tp.tp1;

import java.util.Calendar;

/**
 * La Class Personne décrit une personne de l'application
 * 
 * @author Emmanuel BRUNO
 */
public class Personne {

	/**
	 * The Class Cerveau.
	 * 
	 * @author bruno
	 */
	public class Cerveau {

		/** The masse. */
		private int masse;
	}

	/**
	 * Sets the masse cerveau.
	 * 
	 * @param masse
	 *            the new masse cerveau
	 */
	public void setMasseCerveau(int masse) {
		cerveau.masse = masse;
	}

	/**
	 * @return La masse du cerveau de la Personne
	 */
	public int getMasseCerveau() {
		return cerveau.masse;
	}

	/** The cerveau. */
	private final Cerveau cerveau = new Cerveau();

	/** The nom. */
	public final String nom;

	/** The prenom. */
	public final String prenom;

	/** The salaire. */
	private float salaire;

	/** The annee naissance. */
	private int anneeNaissance;

	/** The total des salaires. */
	private static float totalDesSalaires;

	/**
	 * Gets the anne naissance.
	 * 
	 * @return the anneNaissance
	 */
	public int getAnneNaissance() {
		return anneeNaissance;
	}

	/**
	 * Sets the anne naissance.
	 * 
	 * @param anneNaissance
	 *            the anneNaissance to set
	 */
	public void setAnneNaissance(int anneNaissance) {
		this.anneeNaissance = anneNaissance;
	}

	/**
	 * Instantiates a new personne.
	 * 
	 * @param nom
	 *            the nom
	 * @param prenom
	 *            the prenom
	 * @param anneeNaissance
	 *            the annee naissance
	 * @param salaire
	 *            the salaire
	 */
	public Personne(String nom, String prenom, int anneeNaissance, float salaire) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
		this.anneeNaissance = anneeNaissance;
		totalDesSalaires += salaire;
	}

	/**
	 * Instantiates a new personne.
	 * 
	 * @param nom
	 *            the nom
	 * @param prenom
	 *            the prenom
	 */
	public Personne(String nom, String prenom) {
		this(nom, prenom, -1, -1);
	}

	/**
	 * Gets the nom.
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Gets the prenom.
	 * 
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Gets the age.
	 * 
	 * @return the age
	 */
	public int getAge() {
		return Calendar.getInstance().get(Calendar.YEAR) - anneeNaissance;
	}

	/**
	 * Gets the salaire.
	 * 
	 * @return the salaire
	 */
	public float getSalaire() {
		return salaire;
	}

	/**
	 * @return the totalDesSalaires
	 */
	public static float getTotalDesSalaires() {
		return totalDesSalaires;
	}

	/**
	 * Sets the salaire.
	 * 
	 * @param salaire
	 *            the salaire to set
	 * @throws SalaryException
	 *             the salary exception
	 */
	public void setSalaire(float salaire) throws SalaryException {
		if (salaire > 0) {
			totalDesSalaires -= this.salaire;
			this.salaire = salaire;
			totalDesSalaires += this.salaire;
		} else
			throw new SalaryException(salaire);
	}

	/**
	 * Comparer salaire.
	 * 
	 * @param p
	 *            La personne dont le salaire est a comparer
	 * @return -1, 0, 1 inférieur, égal, supérieur.
	 */
	public int comparerSalaire(Personne p) {
		float differenceSalaire = salaire - p.salaire;
		return (int) (differenceSalaire / Math.abs(differenceSalaire));
	}

	/**
	 * Comparer salaire.
	 * 
	 * @param p1
	 *            La premiere personne dont le salaire est a comparer.
	 * @param p2
	 *            La seconde personne dont le salaire est a comparer.
	 * @return -1, 0, 1 inférieur, égal, supérieur.
	 */
	public static int comparerSalaire(Personne p1, Personne p2) {
		return p1.comparerSalaire(p2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		totalDesSalaires -= salaire;
		super.finalize();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Personne)
			return ((Personne) o).anneeNaissance == this.anneeNaissance;
		else
			return super.equals(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getNom() + " " + getPrenom() + " est agé de " + getAge()
				+ " et gagne " + getSalaire() + "€";

	}
}
