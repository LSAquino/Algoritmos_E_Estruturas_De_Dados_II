package ProblemaCasas;

public class BuscaBinaria {

    public int buscaBinaria(int[] list, int x) {
        int meio, inicio = 0, fim = list.length - 1;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;

            if (list[meio] == x) {
                return meio;
            } else if (list[meio] < x) {
                inicio = meio + 1;
            } else if (list[meio] > x) {
                fim = meio - 1;
            }
        }
        return -1;
    }
}
