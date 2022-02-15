package ProblemaNatal;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int numeroNos = in.nextInt();        
        Arvore arvore = new Arvore(numeroNos);
        
        for (int i = 0; i < numeroNos-1; i++) {
            
            int id_galho = in.nextInt();
            int idDoNoA = in.nextInt();
            int idDoNoB = in.nextInt();
            int beleza = in.nextInt();
            
            arvore.add(id_galho,idDoNoA,idDoNoB,beleza);
        }
        
        arvore.init();
        
    }
}
