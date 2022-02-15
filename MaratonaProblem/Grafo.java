package MaratonaProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Grafo {

    Vertice[] vertices;

    public Grafo(int quantidade) {
        vertices = new Vertice[quantidade];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertice();
        }
    }

    public void add(int origem, int destino) {
        vertices[origem].arestas.add(new Aresta(vertices[destino]));
        vertices[destino].arestas.add(new Aresta(vertices[origem]));
    }

    public void buscaEmLargura(Vertice vertice) {
        Queue<Vertice> lista = new LinkedList<>();
        lista.offer(vertice);
        while (!lista.isEmpty()) {
            Vertice v = lista.poll();
            v.semTime = false;
            for (Aresta aresta : v.arestas) {
                if (aresta.aponta.semTime) {
                    aresta.aponta.semTime = false;
                    lista.offer(aresta.aponta);
                }
            }
        }
    }

    public int quantidade() {
        int count = 0;
        for (Vertice vertice : vertices) {
            if (vertice.semTime) {
                count++;
                buscaEmLargura(vertice);
            }
        }
        return count;
    }

    private class Vertice {
        boolean semTime = true;
        List<Aresta> arestas = new ArrayList<>();
    }

    private class Aresta {
        Vertice aponta;
        public Aresta(Vertice aponta) {
            this.aponta = aponta;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n, m, i, j;

        n = in.nextInt();
        m = in.nextInt();

        Grafo grafo = new Grafo(n + 1);

        for (int k = 0; k < m; k++) {
            i = in.nextInt();
            j = in.nextInt();
            grafo.add(i, j);
        }

        int numero = grafo.quantidade();

        System.out.println(numero - 1);
    }
}
