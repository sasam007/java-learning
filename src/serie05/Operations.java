package serie05;

public class Operations {

    public static void main(String[] args) {
        int[] tableau = {3, 7, 1, 9, 2, 8, 9, 1, 2, 5};
        operations(tableau);

        operations(remplir1(5));
        operations(remplir2(10));
        operations(remplir3(5));
    }

    /** Returns an array of nb elements in increasing order from 0 to nb-1. */
    static int[] remplir1(int nb) {
        int[] tableau = new int[nb];
        for (int i = 0; i < nb; i++) {
            tableau[i] = i;
        }
        return tableau;
    }

    /** Returns an array of nb elements in increasing order starting at 5. */
    static int[] remplir2(int nb) {
        int[] tableau = new int[nb];
        for (int i = 0; i < nb; i++) {
            tableau[i] = i + 5;
        }
        return tableau;
    }

    /** Returns an array of nb elements in decreasing order from nb to 1. */
    static int[] remplir3(int nb) {
        int[] tableau = new int[nb];
        for (int i = 0; i < nb; i++) {
            tableau[i] = nb - i;
        }
        return tableau;
    }

    /** Prints the array, then runs operations 1 to 5 on it. */
    static void operations(int[] tableau) {
        afficher(tableau);
        operation1(tableau);
        operation2(tableau);
        operation3(tableau);
        operation4(tableau);
        operation5(tableau);
    }

    /** Prints all elements on one line, separated by two spaces. */
    static void afficher(int[] tableau) {
        for (int valeur : tableau) {
            System.out.print(valeur + "  ");
        }
        System.out.println();
    }

    /** Counts the elements equal to 9. */
    static void operation1(int[] tableau) {
        int nb = 0;
        for (int valeur : tableau) {
            if (valeur == 9) {
                nb++;
            }
        }
        System.out.println("Il y a " + nb + " elements de valeur 9 dans le tableau");
    }

    /** Counts the elements greater than 4 OR smaller than 2. */
    static void operation2(int[] tableau) {
        int nb = 0;
        for (int valeur : tableau) {
            if (valeur > 4 || valeur < 2) {
                nb++;
            }
        }
        System.out.println("Il y a " + nb + " éléments plus grand que 4 ou plus petit que 2");
    }

    /** Sum of all elements. */
    static void operation3(int[] tableau) {
        int somme = 0;
        for (int valeur : tableau) {
            somme += valeur;
        }
        System.out.println("La somme des éléments est " + somme);
    }

    /** Arithmetic mean of all elements. */
    static void operation4(int[] tableau) {
        double somme = 0;
        for (int valeur : tableau) {
            somme += valeur;
        }
        System.out.println("La moyenne arithmétique des éléments est " + somme / tableau.length);
    }

    /** Largest element. */
    static void operation5(int[] tableau) {
        int max = tableau[0];
        for (int valeur : tableau) {
            if (valeur > max) {
                max = valeur;
            }
        }
        System.out.println("Le plus grand élément vaut: " + max);
    }
}
