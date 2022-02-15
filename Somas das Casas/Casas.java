
package ProblemaCasas;

import java.util.Scanner;

public class Casas {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int casas = in.nextInt();
        int[] lista = new int[casas];
        for (int i = 0; i < casas; i++) {
            lista[i] = in.nextInt();
        }
        int soma = in.nextInt();

        BuscaBinaria ord = new BuscaBinaria();

        for (int j = 0; j < lista.length; j++) {
            int casa1 = lista[j];
            if (ord.buscaBinaria(lista, soma - casa1) != -1) {
                System.out.println(casa1 + " " + (soma - casa1));
                break;
            }
        }
    }

}