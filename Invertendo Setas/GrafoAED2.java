package SetasProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GrafoAED2 {

    Vertice[] vertices;

    public GrafoAED2(int quantidade) {
        vertices = new Vertice[quantidade];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertice();
        }
    }

    public void add(int origem, int destino) {
        vertices[origem].arestas.add(new Aresta(vertices[destino], 0));
        vertices[destino].arestas.add(new Aresta(vertices[origem], 1));

    }

    private boolean maiorCaminho(double distancia, Vertice maior) {
        if (distancia > maior.distancia_ate_origem) {
            maior.distancia_ate_origem = distancia;
            return true;
        }
        return false;
    }

    private boolean menorCaminho(double distancia, Vertice menor) {
        if (distancia < menor.distancia_ate_origem) {
            menor.distancia_ate_origem = distancia;
            return true;
        }
        return false;
    }

    public int dijkstra(int origem, int destino) {
        Queue<Vertice> fila = new LinkedList<>();
        vertices[origem].distancia_ate_origem = 0;
        fila.offer(vertices[origem]);
        while (!fila.isEmpty()) {
            Vertice v = fila.poll();
            for (Aresta aresta : v.arestas) {
                if (!aresta.aponta.equals(vertices[origem]) && menorCaminho(v.distancia_ate_origem + aresta.peso, aresta.aponta)) {
                    if (!aresta.aponta.equals(vertices[destino])) {
                        fila.offer(aresta.aponta);
                    }
                }
            }
        }
        return (int) vertices[destino].distancia_ate_origem;
    }

    private class Vertice {

        //double distancia_ate_origem = 0; // maior caminho
        double distancia_ate_origem = Double.MAX_VALUE; //menor caminho
        List<Aresta> arestas = new ArrayList<>();

    }

    private class Aresta {

        Vertice aponta;
        int peso;

        public Aresta(Vertice aponta, int peso) {
            this.aponta = aponta;
            this.peso = peso;
        }
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        int c = leia.nextInt();
        GrafoAED2 grafoVai = new GrafoAED2(c + 1);
        GrafoAED2 grafoVolta = new GrafoAED2(c + 1);

        int s = leia.nextInt();

        int a = leia.nextInt();
        int b = leia.nextInt();
        int aContrario = b;
        int bContrario = a;

        int origem, destino;
        for (int i = 0; i < s; i++) {

            origem = leia.nextInt();
            destino = leia.nextInt();

            grafoVai.add(origem, destino);
            grafoVolta.add(origem, destino);
        }

        int bibi = grafoVai.dijkstra(a, b);

        int bibika = grafoVolta.dijkstra(aContrario, bContrario);

        if (bibi < bibika) {
            System.out.println("Bibi: " + bibi);

        } else if (bibi > bibika) {
            System.out.println("Bibika: " + bibika);

        } else {
            System.out.println("Bibibibika");
        }
    }
}