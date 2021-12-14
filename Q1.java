//주어진 정수문자열에서 제일 많이 나오는 정수와 나온 횟수를 구하기
package Final;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        //문자열 입력받아서
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //문자열을 돌아가면서 정수로 바꾸고 리스트에 추가
        int digit;

        List<Integer> a = new ArrayList<>();
        for (int i = 0; i<str.length(); i++){
            digit = str.charAt(i) - '0';
            a.add(digit);
        }
        Map<Integer, Integer> c = new HashMap<>();//뭐가 몇번 나왔는지..
        Set<Integer> b = new HashSet<>(a); //어떤 종류가 있는지..
        for (Integer target : b){
            int digitcnt=0;
            for (Integer i : a){
                if (target == i){
                    digitcnt++;
                }
            }
            c.put(target, digitcnt);
        }
        //System.out.println(c);
        //최고횟수..
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        };
        // Max Value의 key, value
        Map.Entry<Integer, Integer> maxEntry = Collections.max(c.entrySet(), comparator);
        System.out.println(maxEntry.getKey());
        System.out.println(maxEntry.getValue());
    }
}