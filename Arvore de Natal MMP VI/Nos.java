
package ProblemaNatal;

import java.util.LinkedList;
import java.util.List;


public class Nos {

    int id_galho;
    int beleza;
    List<Nos> filhos = new LinkedList<>();

    public Nos(int id_galho, int beleza) {
        this.beleza = beleza;
        this.id_galho = id_galho;
    }
}
