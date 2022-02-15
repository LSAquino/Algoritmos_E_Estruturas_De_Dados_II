package ProblemaNatal;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Arvore {

    //No raiz = new No(3);
    Nos[] nos;
    List<int[]> naoAdicionados = new LinkedList<>();

    public Arvore(int numeroNos) {
        nos = new Nos[numeroNos];
        nos[0] = new Nos(-1, 0);
    }

    public void add(int id_galho, int idNoA, int idNoB, int beleza) {
        if (nos[idNoA] != null) {
            nos[idNoB] = new Nos(id_galho, beleza);
            nos[idNoA].filhos.add(nos[idNoB]);
        } else if (nos[idNoB] != null) {
            nos[idNoA] = new Nos(id_galho, beleza);
            nos[idNoB].filhos.add(nos[idNoA]);
        } else {
            naoAdicionados.add(new int[]{id_galho, idNoA, idNoB, beleza});
        }
    }

    void inserirResto() {

    }

    void init() {
        
        List<Integer> filhosRetirados = new LinkedList<>();
        while (!naoAdicionados.isEmpty()) {
            int[] dadosNaoAdicionados = naoAdicionados.remove(0);
            add(dadosNaoAdicionados[0], dadosNaoAdicionados[1], dadosNaoAdicionados[2], dadosNaoAdicionados[3]);

        }
        
        System.out.print(corta(nos[0], filhosRetirados) + " ");
        System.out.println(filhosRetirados.size());
        
        Collections.sort(filhosRetirados);
        
        while(!filhosRetirados.isEmpty()){
            System.out.print(filhosRetirados.remove(0)+ " ");
            
        }
        
    }

    int corta(Nos pai, List<Integer> pacote) {
        int belezaTotal = pai.beleza;
        
        while (!pai.filhos.isEmpty()) {
            
            List<Integer> dadosDosFilhos = new LinkedList<>();
            
            Nos filhoRetirado = pai.filhos.remove(0);
            int belezaFilho = corta(filhoRetirado, dadosDosFilhos);
            
            if (belezaFilho > 0) { 
                pacote.addAll(dadosDosFilhos);
                belezaTotal += belezaFilho;
            }else{
                pacote.add(filhoRetirado.id_galho);
            }
        }
        return belezaTotal;
    }
}
