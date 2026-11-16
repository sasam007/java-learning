package serie07.labo;

class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;

    private final int poids;
    private String couleur;
    private int age;
    private final int esperanceVie;
    private final boolean clonee;

    public Souris(int poids, String couleur, int age, int esperanceVie) {
        this.poids = poids;
        this.couleur = couleur;
        this.age = age;
        this.esperanceVie = esperanceVie;
        this.clonee = false;
        System.out.println("Une nouvelle souris !");
    }

    public Souris(int poids, String couleur, int age) {
        this(poids, couleur, age, ESPERANCE_VIE_DEFAUT);
    }

    public Souris(int poids, String couleur) {
        this(poids, couleur, 0);
    }

    /** Cloning: a clone lives 20% less than the original. */
    public Souris(Souris autre) {
        this.poids = autre.poids;
        this.couleur = autre.couleur;
        this.age = autre.age;
        this.esperanceVie = autre.esperanceVie * 4 / 5;
        this.clonee = true;
        System.out.println("Clonage d'une souris !");
    }

    @Override
    public String toString() {
        String affichage = "Une souris " + couleur;
        if (clonee) {
            affichage += ", clonee,";
        }
        affichage += " de " + age + " mois et pesant " + poids + " grammes";
        return affichage;
    }

    public void vieillir() {
        age++;
        if (clonee && age >= esperanceVie / 2) {
            couleur = "verte";
        }
    }

    public void evolue() {
        age = esperanceVie;
        if (clonee) {
            couleur = "verte";
        }
    }
}

public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2);
        Souris s2 = new Souris(45, "grise");
        Souris s3 = new Souris(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolue();
        s2.evolue();
        s3.evolue();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
