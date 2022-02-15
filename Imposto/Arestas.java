package Imposto;

class Arestas {

    Vertices verticeDeDestino;
    int peso;

    Arestas(Vertices verticeDeDestino, int comprimento) {
        this.verticeDeDestino = verticeDeDestino;
        this.peso = comprimento;
    }
}
