//콜라츠수열을 오름차순 정렬 후 출력
package Final;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//짝수면 2로 나누고 홀수면 3곱해서 1더한다
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> colatz = new ArrayList<>();

        colatz.add(N);
        while (N != 1){
            if (N%2 == 0){
                N = (int)(N/2);
                colatz.add(N);
            }
            else{
                N = 3*N + 1;
                colatz.add(N);
            }
        }
        Collections.sort(colatz);

        System.out.println(colatz.size());
        for (Integer i:colatz)
            System.out.println(i);
    }
}
