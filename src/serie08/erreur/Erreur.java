package serie08.erreur;

/**
 * Inheritance quiz: which fields can each object reach?
 * Every subclass inherits the fields of all its ancestors, so all five lines are valid.
 */
public class Erreur {

    public static void main(String[] args) {
        E4 v = new E4();
        E1 x = new E1();
        E2 y = new E2();
        E3 z = new E3();
        E5 w = new E5();
        System.out.println(x.a); // valid: a is declared in E1
        System.out.println(y.b); // valid: b is declared in E2
        System.out.println(z.b); // valid: E3 inherits b from E2
        System.out.println(v.c); // valid: E4 inherits c from E3
        System.out.println(w.a); // valid: E5 inherits a from E1
    }
}

class E1 {
    int a = 1;
}

class E2 extends E1 {
    int b = 2;
}

class E3 extends E2 {
    int c = 3;
}

class E4 extends E3 {
    int d = 4;
}

class E5 extends E4 {
    int e = 5;
}
