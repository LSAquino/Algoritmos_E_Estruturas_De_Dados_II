package ProblemaNavalha;

public class Tabuleiro {

    public Tabuleiro() {
        
    }
    
    public int executaAcao(int n, int p, int[] tabuleiro[]) {
        int quantidade = 0, eixox = 0, eixoy = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tabuleiro[i][j] == 1) {
                    for (int k = 0; k < n; k++) {
                        if (tabuleiro[i][k] == 0) {
                            quantidade++;
                            eixox++;
                        } else {
                            if (eixox > 1) {
                                for (int m = eixox; m > 0; m--) {
                                    quantidade++;
                                }
                            }
                            eixox = 0;
                            break;
                        }
                        for (int l = 0; l < 10; l++) {
                            if (tabuleiro[l][j] == 0) {
                                quantidade++;
                                eixoy++;
                            } else {
                                if (eixoy > 1) {
                                    for (int b = eixoy; b > 0; b--) {
                                        quantidade++;
                                    }
                                }
                                eixoy = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return quantidade;
    }
}
