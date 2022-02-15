

import java.util.Scanner;

public class Aeroporto {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = -1, v = -1, x = 0, y = 0, teste = 1, c = 1, maior = 1, count = 0;

        while (true) {
            a = in.nextInt();
            int aeroportos[] = new int[a + 1];

            v = in.nextInt();
            
            if (a==0 && v==0) {
                break;
            }
            
            for (int i = 0; i < v; i++) {
                c++;
                x = in.nextInt();
                y = in.nextInt();
                aeroportos[x]++;
                aeroportos[y]++;
            }

            for (int i = 1; i < aeroportos.length; i++) {
                //System.out.println(aeroportos[i]);
            }

            for (int i = 1; i < aeroportos.length; i++) {
                if (aeroportos[i] > aeroportos[maior]) {
                    maior = i;
                }
            }
            System.out.println("Teste " + teste);
            for (int i = 1; i < aeroportos.length; i++) {
                if (aeroportos[i] == aeroportos[maior]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println(" ");
            teste++;
            maior=1;
        }

    }
}
