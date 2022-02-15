package HashMapProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int n, m, c;
        n = leia.nextInt();

        for (int i = 0; i < 2; i++) {
            m = leia.nextInt();
            c = leia.nextInt();
            List<Integer> vetList[] = new List[m];
            for (int j = 0; j < m; j++) {
                vetList[j] = new ArrayList<>();
            }
            for (int j = 0; j < c; j++) {
                int valor = leia.nextInt();
                int chave = valor % m;
                vetList[chave].add(valor);
            }

            for (int j = 0; j < m; j++) {
                System.out.print(j + " -> ");

                for (int k = 0; k < vetList[j].size(); k++) {
                    System.out.print(vetList[j].get(k) + " -> ");
                }

                System.out.println("\\");
            }
            System.out.println(" ");

        }
    }
}
