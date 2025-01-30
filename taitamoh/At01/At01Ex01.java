package taitamoh.At01;

import java.util.*;

public class At01Ex01 {
	public static void main(String[] args) {
		Scanner cl = new Scanner(System.in);

		char choix;
		// Déclarer les variables
		int nb, pondExamen, pondTpratique, notes, troisNb, nbDepart, nbFinal, valeurP,
				resulSommeS, nbBase, valeurR, resulE;
		float resultat, noteEnP, noteEnL;
		String resultatOrdre;
		do {
			System.out.println("Menu principal");
			System.out.println("-------------------------");
			System.out.println("1 - Calcul moyenne");
			System.out.println("2 - Calcul note pondérée");
			System.out.println("3 - Conversion note");
			System.out.println("4 - Détermine ordre");
			System.out.println("5 - Calcul somme suite");
			System.out.println("6 - Exposant maximal");
			System.out.println("9 - Quitter");
			System.out.print("Votre choix > ");
			choix = cl.next().charAt(0);
			switch (choix) {
				case '1':
					// Affichage + lire trois valeurs
					System.out.print("Entrez trois valeurs séparées par des espaces :");
					nb = cl.nextInt();
					// Appeler méthode moyenne() et récupérer résultat
					resultat = moyenne(nb, nb, nb);
					// Afficher résultat
					System.out.println("La moyenne vaut " + resultat);
					break;
				case '2': // Calcul note pondérée
					// Affichage + lire deux valeurs (examens)
					System.out.print("Entrez la pondération des examens et la note obtenue : ");
					pondExamen = cl.nextInt();
					// Affichage + lire deux valeurs (travaux)
					System.out.print("Entrez la pondération des travaux et la note obtenue : ");
					pondTpratique = cl.nextInt();
					// Appeler méthode notePonderee() et récupérer résultat
					notes = notePonderee(pondExamen, pondExamen, pondTpratique, pondTpratique);
					// Afficher résultat ou message selon valeur de retour
					if (notes == -1) {
						System.out.println("Erreur dans les données");
					} else {
						System.out.println("La note pondérée est " + notes);
					}
					break;
				case '3': // Conversion note
					// Affichage + lire valeur note
					System.out.print("Entrez la note en pourcentage : ");
					noteEnP = cl.nextInt();
					// Appeler méthode conversionNote() et récupérer résultat
					noteEnL = conversionNote(noteEnP);
					// Afficher résultat
					System.out.println("La note en lettre est : " + noteEnL);
					break;
				case '4': // Détermine ordre
					// Affichage + lire trois valeurs
					System.out.print("Entrez trois valeurs séparées par des espaces : ");
					troisNb = cl.nextInt();
					// Appeler méthode ordre() et récupérer résultat
					resultatOrdre = ordre(troisNb, troisNb, troisNb);
					// Afficher résultat
					System.out.println(resultatOrdre);
					break;
				case '5': // Calcul somme suite
					// Affichage + lire valeur départ
					System.out.print("Inscrivez le nombre de départ : ");
					nbDepart = cl.nextInt();
					// Affichage + lire valeur finale
					System.out.print("Inscrivez le nombre final : ");
					nbFinal = cl.nextInt();
					// Affichage + lire valeur pas
					System.out.print("Indiquez le pas : ");
					valeurP = cl.nextInt();
					// Appeler méthode sommeSuite() et récupérer résultat
					resulSommeS = sommeSuite(nbDepart, nbFinal, valeurP);
					// Afficher résultat ou message selon valeur de retour
					if (resulSommeS == -1) {
						System.out.println("Somme impossible");
					} else {
						System.out.println("La somme de la suite est égale à " + resulSommeS);
					}
					System.out.println("La somme de la suite est égale à " + resulSommeS);
					break;
				case '6': // Exposant maximal
					// Affichage + lire valeur base
					System.out.print("Entrez une base :");
					nbBase = cl.nextInt();
					// Affichage + lire valeur recherchée
					System.out.println("Entrez la valeur recherchée : ");
					valeurR = cl.nextInt();
					// Appeler méthode expMax() et récupérer résultat
					resulE = expMax(nbBase, valeurR);
					// Afficher résultat ou message selon valeur de retour
					System.out.println("La valeur la plus près de la valeur recherchée est : " + resulE);
					System.out.println("en utilisant la base = " + resulE + "et l'exposant = ");
					break;
				case '9': // Quitter
					break;
				default:
					System.out.println("Choix invalide");
			}
			System.out.println("-------------------------");
		} while (choix != 9); // Ajouter la condition
		System.out.println("A la prochaine!");
		cl.close();
	}

	/**
	 * Calcul de la moyenne de trois nombres entiers
	 * 
	 * @param nb1 Premier nombre entier
	 * @param nb2 Deuxième nombre entier
	 * @param nb3 Troisième nombre entier
	 * @return Moyenne des trois nombres en point flottant
	 */
	public static float moyenne(int nb1, int nb2, int nb3) {
		// Option 1 : Calcul moyenne
		float moyenne;
		moyenne = (nb1 + nb2 + nb3) / 3.0f;
		return moyenne;
	}

	/**
	 * Fait le calcul d'une note finale pondérée
	 * noteFinale = (noteExamen * pondExamen + noteTravaux * pondTravaux) / 100
	 * 
	 * @param pondEx Pondération des examens [0;100]
	 * @param noteEx Note des examens [0;100]
	 * @param pondTp Pondération des travaux [0;100]
	 * @param noteTp Note des travaux [0;100]
	 * @return Note finale calculée en nombre entier <br>
	 *         -1 si les paramètres ne sont pas entre 0 et 100
	 *         ou que la somme des pondérations != 100
	 */
	public static int notePonderee(int pondEx, int noteEx, int pondTp, int noteTp) {
		// Option 2 : Calcul note pondérée
		int noteFin;
		if (pondEx < 0 || pondEx > 100) {
			noteFin = -1;
		}
		if (pondTp < 0 || pondTp > 100) {
			noteFin = -1;
		}
		if (noteEx < 0 || noteEx > 100) {
			noteFin = -1;
		}
		if (noteTp < 0 || noteTp > 100) {
			noteFin = -1;
		}
		noteFin = (noteEx * pondEx + noteTp * pondTp) / 100;
		return noteFin;
	}

	/**
	 * Convertit une note pouvant comporter une partie
	 * décimale en une lettre selon les valeurs suivantes: <br>
	 * F:[0;50[ - D:[50;60[ - C:[60;75[ - B:[75;90[ - A:[90;100]
	 * 
	 * @param notePct Note entre 0 et 100 en virgule flottante
	 * @return Lettre (A,B,C,D,F) correspondant à la note
	 *         ou X si la note n'est pas entre 0 et 100
	 */
	public static char conversionNote(float notePct) {
		// Option 3 : Conversion note

		if (notePct >= 0 && notePct < 50) {
			System.out.println("F");
		} else if (notePct >= 50 && notePct < 60) {
			System.out.println("D");
		} else if (notePct >= 60 && notePct < 75) {
			System.out.println("C");
		} else if (notePct >= 75 && notePct < 90) {
			System.out.println("B");
		}
		if (notePct >= 90 && notePct < 100) {
			System.out.println("A");
		} else {
			System.out.println("X");
		}
		return '\0';
	}

	/**
	 * Détermine l'ordre des trois nombres entiers reçus en paramètre
	 * et retourne la chaîne correspondante selon le cas: <br>
	 * croissant, décroissant, constant, quelconque
	 * 
	 * @param nb1 Premier nombre entier
	 * @param nb2 Deuxième nombre entier
	 * @param nb3 Troisième nombre entier
	 * @return Chaîne correspondant à l'ordre des nombres
	 */
	public static String ordre(int nb1, int nb2, int nb3) {
		// Option 4 : Détermine ordre<
		if (nb1 < nb2 && nb2 < nb3) {
			System.out.println("Valeurs en ordre croissant");
		} else if (nb1 == nb2 && nb2 == nb3 && nb1 == nb3) {
			System.out.println("Valeurs en ordre constant");
		} else if (nb1 > nb2 && nb2 > nb3) {
			System.out.println("Valeurs en ordre décroissant ");
		} else {
			System.out.println("Valeurs en ordre quelconque");
		}
		return "";
	}

	/**
	 * Calcul la somme d'une suite de nombres entiers entre nbMin
	 * et nbMax avec un pas de progression de pas
	 * 
	 * @param nbMin Premier nombre de la suite >= 0
	 * @param nbMax Nombre final à ne pas dépasser >= nbMin
	 * @param pas   Pas de progression de la suite > 0
	 * @return La somme de la suite <br>
	 *         -1 si nbMax < nbMin ou que pas < 1 ou
	 *         que la somme dépasse Integer.MAX_VALUE
	 */
	public static int sommeSuite(int nbMin, int nbMax, int pas) {
		// Option 5 : Calcul somme suite
		long sommeSuite = 0;
		if (nbMax >= nbMin && pas > 0) {
			for (long i = nbMin; i <= nbMax; i += pas) {
				sommeSuite += i;
			}
		} else if (nbMax < nbMin || pas < 0) {
			sommeSuite = -1;
		} else if (sommeSuite > Integer.MAX_VALUE) {
			sommeSuite = -1;
		}

		return (int) sommeSuite;
	}

	/**
	 * Détermine l'exposant maximal que l'on peut affecter
	 * à base afin d'obtenir la valeur la plus proche de
	 * valMax, sans toutefois la dépasser.
	 * 
	 * @param base   Base en valeur entière > 0
	 * @param valMax Valeur entière recherchée > 0
	 * @return L'exposant qui permet d'obtenir la valeur la plus
	 *         proche de valMax sans la dépasser. <br>
	 *         -1 si base ou valMax sont inférieurs a 1 <br>
	 *         0 si base = 1 ou que valMax < base
	 */
	public static int expMax(int base, int valMax) {
		// Option 6 : Exposant maximal

		int exposant = 0;
		if (base < 1 || valMax < 1) {
			exposant = -1;
		} else if (base == 1 || valMax < base) {
			exposant = 0;
		}
		while (Math.pow(base, exposant + 1) <= valMax) {
			exposant++;
		}
		return exposant;
	}
}
