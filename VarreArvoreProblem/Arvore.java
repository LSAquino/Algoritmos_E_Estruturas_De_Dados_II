package VarreArvoreProblem;

public class Arvore<TIPO extends Comparable> {

    private Elemento<TIPO> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void adicionar(TIPO valor) {
        Elemento<TIPO> novoElemento = new Elemento<TIPO>(valor);
        if (raiz == null) {
            this.raiz = novoElemento;
        } else {
            Elemento<TIPO> atual = this.raiz;
            while (true) {
                if (novoElemento.getValor().compareTo(atual.getValor()) == -1) {
                    if (atual.getEsquerda() == null) {
                        atual.setEsquerda(novoElemento);
                        break;

                    } else {
                        atual = atual.getEsquerda();
                    }
                } else { // if maior ou igual
                    if (atual.getDireita() == null) {
                        atual.setDireita(novoElemento);
                        break;
                    } else {
                        atual = atual.getDireita();
                    }
                }
            }
        }
    }

    public Elemento<TIPO> getRaiz() {
        return raiz;
    }

    public void emOrdem(Elemento<TIPO> atual) {
        if (atual != null) {
            emOrdem(atual.getEsquerda());
            System.out.print(atual.getValor() + " ");
            emOrdem(atual.getDireita());
        }
    }

    public void preOrdem(Elemento<TIPO> atual) {
        if (atual != null) {
            System.out.print(atual.getValor() + " ");
            preOrdem(atual.getEsquerda());
            preOrdem(atual.getDireita());
        }
    }

    public void posOrdem(Elemento<TIPO> atual) {
        if (atual != null) {
            posOrdem(atual.getEsquerda());
            posOrdem(atual.getDireita());
            System.out.print(atual.getValor() + " ");
        }
    }

}
