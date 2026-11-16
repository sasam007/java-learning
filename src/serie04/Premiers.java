package serie04;

import java.util.ArrayList;

public class Premiers {
    public static void main(String[] args) {
        ArrayList<Integer> premiers = new ArrayList<>();

        for (int n = 2; n <= 100; n++) {
            if (estPremier(n)) {
                premiers.add(n);
            }
        }

        for (int premier : premiers) {
            System.out.println(premier);
        }
    }

    static boolean estPremier(int n) {
        if (n % 2 == 0) {
            return n == 2;
        }
        for (int d = 3; d * d <= n; d += 2) {
            if (n % d == 0) {
                return false;
            }
        }
        return true;
    }
}
