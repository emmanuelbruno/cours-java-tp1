/**
 * 
 */
package fr.univtln.bruno.coursjava.tp.tp1;

/**
 * La classe Test perme tester la classe Personne du TP1.
 * 
 * @author Emmanuel BRUNO
 * @see Personne
 */
public class Test {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		System.out.println("Hello World !");

		Personne p = new Personne("Pierre", "Truc");
		p.setAnneNaissance(1950);

		Personne p2 = new Personne("Marc", "Durand");
		p2.setAnneNaissance(1950);

		try {
			p.setSalaire(2000);
			p2.setSalaire(1500);
		} catch (SalaryException e) {
			System.err.println("Le salaire " + e.SALAIRE + " illégal");
			System.exit(0);
		}

		System.out.println("Le total des salaires est de "
				+ Personne.getTotalDesSalaires());

		System.out.println("Comparaison des salaires (via une instance):"
				+ p.comparerSalaire(p2));
		System.out.println("Comparaison des salaires (via la classe):"
				+ Personne.comparerSalaire(p, p2));

		System.out.println(p.getNom() + " " + p.getPrenom() + " est agé de "
				+ p.getAge() + " et gagne " + p.getSalaire() + "€");

		System.out.println(p2.toString());

		if (p.equals(p2))
			System.out.println("Les deux personnes sont égales");
		else
			System.out.println("Les deux personnes ne sont pas égales");

	}
}
