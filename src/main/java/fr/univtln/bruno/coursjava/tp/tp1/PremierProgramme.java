/**
 * Ce premier programme Java
 * dit "Bonjour"
 */
package fr.univtln.bruno.coursjava.tp.tp1;

/**
 * @author Emmanuel Bruno
 * 
 */
public class PremierProgramme {

	/**
	 * @param args
	 *            le premier paramètre passé en ligne de commande est un prénom
	 */
	public static void main(String[] args) {
		if (args.length == 1)
			System.out.println("Bonjour " + args[0]);
		else
			System.out.println("Usage : PremierProgramme [prenom]");
	}

}
