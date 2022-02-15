package Imposto;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, c;

        n = in.nextInt();
        c = in.nextInt();
        
        int cargaMax = c;

        ArrayList<Vertices> cidades = new ArrayList<>();
        ArrayList<Integer> Imposto = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Imposto.add(in.nextInt());
            Vertices cidade = new Vertices(Imposto.get(i));
            cidades.add(cidade);
        }

        int cidadeA, cidadeB, comprimento;

        for (int i = 0; i < Imposto.size() - 1; ++i) {

            cidadeA = (in.nextInt() - 1);
            cidadeB = (in.nextInt() - 1);
            comprimento = in.nextInt();

            cidades.get(cidadeA).adicionarCaminho(cidades.get(cidadeB), comprimento);
            cidades.get(cidadeB).adicionarCaminho(cidades.get(cidadeA), comprimento);

        }
        int menorDistancia = cidades.get(0).calcularDistancia(null, cargaMax);
        System.out.println(menorDistancia);
    }
}
