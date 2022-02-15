package ProblemaNavalha;

import java.util.Locale;
import java.util.Scanner;

public class Navalha {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        int n, q, x, y;

        n = sc.nextInt();
        q = sc.nextInt();

        int tabuleiro[][] = new int[n][n];

        for (int i = 0; i < q; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            tabuleiro[x - 1][y - 1]++;
        }
        
        Tabuleiro t = new Tabuleiro();
        int resultado = t.executaAcao(n, q, tabuleiro);

        System.out.println(resultado);
        sc.close();
    }

}
