package VarreArvoreProblem;

import java.util.Scanner;

public class VarreArvore {

    public static void main(String[] args) {
        /*Arvore<Integer> arvore = new Arvore<Integer>();
        arvore.adicionar(8);
        arvore.adicionar(3);
        arvore.adicionar(10);
        arvore.adicionar(14);
        arvore.adicionar(6);
        arvore.adicionar(4);
        arvore.adicionar(13);
        arvore.adicionar(7);
        arvore.adicionar(1);*/

        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        for (int i = 1; i <= c; i++) {
            Arvore<Integer> arvore = new Arvore<Integer>();

            int n = sc.nextInt();

            for (int j = 0; j < n; j++) {
                arvore.adicionar(sc.nextInt());
            }

            System.out.println("Case " + i + ": ");
            System.out.print("Pre.: ");
            arvore.preOrdem(arvore.getRaiz());
            System.out.println("");

            System.out.print("In..: ");
            arvore.emOrdem(arvore.getRaiz());
            System.out.println("");

            System.out.print("Post: ");
            arvore.posOrdem(arvore.getRaiz());
            System.out.println("");
        }
    }
}
