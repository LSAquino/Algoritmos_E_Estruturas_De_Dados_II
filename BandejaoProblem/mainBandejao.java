package BandejaoProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class mainBandejao {

    Vertice[] vertices;

    public mainBandejao(int quantidade) {
        vertices = new Vertice[quantidade];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertice();
        }
    }

    public void add(int origem, int destino, int peso) {
        vertices[origem].arestas.add(new Aresta(vertices[destino], peso));
        vertices[destino].arestas.add(new Aresta(vertices[origem], peso));

    }

    private boolean menorCaminho(int distancia, Vertice menor) {

        if ((menor.contador.peek() % 2) == 0) {
            if (distancia < menor.distancia_par) {
                menor.distancia_par = distancia;
                //menor.distancia_impar = Integer.MAX_VALUE;
                return true;
            }
        } else {
            if (distancia < menor.distancia_impar) {
                menor.distancia_impar = distancia;
                //menor.distancia_par = Integer.MAX_VALUE;
                return true;
            }
        }
        return false;
    }

    public long dijkstra(int destino) {
       int origem = 1;
       
        Queue<Vertice> fila = new LinkedList<>();
        vertices[origem].distancia_par = 0;
        fila.offer(vertices[origem]);
        while (!fila.isEmpty()) {
            Vertice v = fila.poll();
            for (Aresta aresta : v.arestas) {
                if ((v.distancia_par + aresta.peso) < aresta.aponta.distancia_impar) {
                   aresta.aponta.distancia_impar = v.distancia_par + aresta.peso;
                    fila.offer(aresta.aponta);
                }
                if ((v.distancia_impar + aresta.peso) < aresta.aponta.distancia_par) {
                   aresta.aponta.distancia_par = v.distancia_impar + aresta.peso;
                    fila.offer(aresta.aponta);

                }
            }
        }
        return  vertices[destino].distancia_impar;
    }

    private class Vertice {

        //double distancia_ate_origem = 0; // maior caminho
        long distancia_impar = Integer.MAX_VALUE; //menor caminho
        long distancia_par = Integer.MAX_VALUE;
        List<Aresta> arestas = new ArrayList<>();
        Stack<Integer> contador = new Stack<>();

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

                int n = leia.nextInt();
        int m = leia.nextInt();
        mainBandejao bandej = new mainBandejao(n + 1);

        for (int i = 0; i < m; i++) {
            int u = leia.nextInt();
            int v = leia.nextInt();
            int w = leia.nextInt();
            bandej.add(u, v, w);
        }


        long val = bandej.dijkstra(n);

        if (val == Integer.MAX_VALUE) {
            System.out.println(":(");
        } else {
            System.out.print(val);
        }

    }
}
