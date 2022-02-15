package MonkProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Monk {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        
        
        int n = sc.nextInt();
        long value, key;

        Long[] element = new Long[n];
        List<Long> array[] = new List[200000];

        for (int i = 0; i < 200000; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            value = sc.nextLong();
            element[i] = value;
        }

        int part = 1;
        while (true) {
            int ind = 0;
            for (int i = 0; i < n; i++) {
                key = (long) (element[i] / Math.pow(10, (5 * (part - 1))));
                key = key % 100000;
                key = key + 100000;
                array[(int) key].add(element[i]);
            }
            if (array[100000].size() == n) {
                break;
            }
            for (int i = 0; i < 200000; i++) {
                while (!array[i].isEmpty()) {
                    element[ind++] = array[i].remove(0);
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(element[i] + " ");
            }
            System.out.println("");
            part++;
        }
        sc.close();
    }
}
