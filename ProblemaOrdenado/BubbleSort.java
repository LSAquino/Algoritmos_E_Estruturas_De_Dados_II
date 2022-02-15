package ProblemaOrdenado;

public class BubbleSort {

    
    public int[] Ordena(int vetor[]) {
        for (int i = 0; i < vetor.length; i= i+2) {
            for (int j = 0; j < i; j = j+2) {
                if (vetor[j] > vetor[i]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = temp;
                }
            }
        }
        return vetor;
    }
    
    public int[] OrdenaAoContrario(int vetor[]) {
        for (int i = 1; i < vetor.length; i= i+2) {
            for (int j = 1; j < i; j = j+2) {
                if (vetor[i] > vetor[j]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = temp;
                }
            }
        }
        return vetor;
    }
}
