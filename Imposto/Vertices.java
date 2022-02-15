package Imposto;

import java.util.ArrayList;

class Vertices {

    double imposto;
    ArrayList<Arestas> arestas;

    public Vertices(int imposto) {
        this.imposto = imposto;
        this.arestas = new ArrayList<>();
    }

    public void adicionarCaminho(Vertices verticeDeDestino, int comprimento) {
        Arestas ligar = new Arestas(verticeDeDestino, comprimento);
        arestas.add(ligar);
    }

    public int calcularDistancia(Vertices cidadeAnterior, int cargaMax) {
        int distanciaTotal = 0;
        int voltas = 0;

        for (int i = 0; i < arestas.size(); i++) {
            Arestas aresta = arestas.get(i);
            if (aresta.verticeDeDestino == cidadeAnterior) {
                continue;
            }

            distanciaTotal += aresta.verticeDeDestino.calcularDistancia(this, cargaMax);
            voltas = (int) Math.ceil(aresta.verticeDeDestino.imposto / cargaMax) * 2;
            distanciaTotal += voltas * aresta.peso;
            this.imposto += aresta.verticeDeDestino.imposto;
        }
        return distanciaTotal;
    }
}
