package fr.univtln.bruno.coursjava.tp.tp1;

/**
 * The Class SalaryException.
 */
public class SalaryException extends Exception {

	/** Le salaire qui a posé un problème. */
	public final float SALAIRE;

	/**
	 * Instantiates a new salary exception.
	 * 
	 * @param salaire
	 *            le salaire qui a posé un problème
	 */
	public SalaryException(float salaire) {
		super();
		this.SALAIRE = salaire;
	}

}
