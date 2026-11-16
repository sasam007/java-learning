package serie07.geometrie;

import java.util.Scanner;

public class Geometrie {
    private static final Scanner KEYB = new Scanner(System.in);

    public static void main(String[] args) {
        Triangle triangle = new Triangle(KEYB);
        triangle.afficherPerimetre();
        triangle.afficherSiIsocele();
    }
}

class Point {
    private final double x;
    private final double y;

    public Point(Scanner keyb) {
        System.out.println("Construction d'un nouveau point : ");
        System.out.print("       Donnez la coordonnée en x : ");
        this.x = keyb.nextDouble();
        System.out.print("       Donnez la coordonnée en y : ");
        this.y = keyb.nextDouble();
    }

    public double distance(Point autre) {
        return Math.hypot(autre.x - x, autre.y - y);
    }
}

class Triangle {
    // Tolerance used to compare side lengths (doubles are rarely exactly equal)
    private static final double EPSILON = 1e-9;

    private final double cote1;
    private final double cote2;
    private final double cote3;

    public Triangle(Scanner keyb) {
        Point p1 = new Point(keyb);
        Point p2 = new Point(keyb);
        Point p3 = new Point(keyb);
        this.cote1 = p1.distance(p2);
        this.cote2 = p2.distance(p3);
        this.cote3 = p3.distance(p1);
    }

    public double perimetre() {
        return cote1 + cote2 + cote3;
    }

    public boolean estIsocele() {
        return egal(cote1, cote2) || egal(cote2, cote3) || egal(cote3, cote1);
    }

    private static boolean egal(double a, double b) {
        return Math.abs(a - b) < EPSILON;
    }

    public void afficherPerimetre() {
        System.out.println("Le perimètre est " + perimetre());
    }

    public void afficherSiIsocele() {
        if (estIsocele()) {
            System.out.println("Triangle isocèle");
        }
    }
}
