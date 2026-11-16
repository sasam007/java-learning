package serie09.surfaces;

import java.util.ArrayList;

/** Same exercise as serie07, now with an abstract Forme: a Terrain holds any number of shapes. */
public class Surfaces {
    public static void main(String[] args) {
        Terrain terrain = new Terrain();

        terrain.ajouterForme(new Rectangle(100, 100));
        terrain.ajouterForme(new Cercle(50));

        terrain.afficherSurfaceTotale();
    }
}

abstract class Forme {
    public abstract double calculerSurface();
}

class Terrain {
    private final ArrayList<Forme> formes = new ArrayList<>();

    public void ajouterForme(Forme forme) {
        formes.add(forme);
    }

    private double calculerSurfaceTotale() {
        double total = 0;
        for (Forme forme : formes) {
            total += forme.calculerSurface();
        }
        return total;
    }

    public void afficherSurfaceTotale() {
        System.out.println("La surface totale est " + calculerSurfaceTotale());
    }
}

class Rectangle extends Forme {

    private double largeur;
    private double hauteur;

    public Rectangle(double largeur, double hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getHauteur() {
        return hauteur;
    }

    @Override
    public double calculerSurface() {
        return largeur * hauteur;
    }
}

class Cercle extends Forme {

    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    public double getRayon() {
        return rayon;
    }

    @Override
    public double calculerSurface() {
        return Math.PI * rayon * rayon;
    }
}
