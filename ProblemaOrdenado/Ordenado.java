package ProblemaOrdenado;

import java.util.Scanner;

public class Ordenado {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n;
        n = in.nextInt();
        int vetor[] = new int[n];
        int v;

        if (in.hasNext()) {
            for (int i = 0; i < n; i++) {
                vetor[i] = in.nextInt();
            }
        }

        System.out.print("V = { ");
        for (v = 0; v < vetor.length - 1; v++) {
            System.out.print(vetor[v] + ", ");
        }

        System.out.println(vetor[v] + "}");

        BubbleSort alg = new BubbleSort();
        alg.Ordena(vetor);
        alg.OrdenaAoContrario(vetor);

        System.out.print("O = { ");
        for (v = 0; v < vetor.length - 1; v++) {
            System.out.print(vetor[v] + ", ");
        }

        System.out.println(vetor[v] + "}");

        in.close();
    }
    
}
