//로마 숫자 2개를 입력받아 합을 로마자로 출력
package Final;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q3 {
    public static int transform_roman_numeral_to_number(String roman_numeral) {
        Map<Character, Integer> roman_char_dict = new HashMap<Character, Integer>();
        roman_char_dict.put('I', 1);
        roman_char_dict.put('V', 5);
        roman_char_dict.put('X', 10);
        roman_char_dict.put('L', 50);
        roman_char_dict.put('C', 100);
        roman_char_dict.put('D', 500);
        roman_char_dict.put('M', 1000);
        int res = 0;

        //dict.get(key)하면 key에 해당하는 숫자 받아오기..
        //뒤에나온 로마숫자가 더 크면 앞에 로마숫자는 빼줘야한다..
        //일단 더해주고 만약 뒤에가 앞에거보다 더 작다면 다시 수정하는 방식..
        for (int i = 0; i < roman_numeral.length(); i += 1) {
            //역전 안한 경우 (첫번째 로마숫자 이거나..)
            if (i == 0 || roman_char_dict.get(roman_numeral.charAt(i)) <= roman_char_dict.get(roman_numeral.charAt(i - 1)))
                res += roman_char_dict.get(roman_numeral.charAt(i));
                //역전한 경우
            else
                //전에 거는 두개를 빼줘야 한다.. 그래야 앞에걸 빼준게 되는 셈이다..
                res += roman_char_dict.get(roman_numeral.charAt(i)) - 2 * roman_char_dict.get(roman_numeral.charAt(i - 1));
        }
        //아라비아 숫자 반환
        return res;
    }
    public static String transform_number_to_roman_numeral(int number) {
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        //고정 문자열이 아닌 변동가능한 문자열..
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nums.length; i += 1) {
            while (number >= nums[i]) {
                //nums에서 하나씩 가져온다..
                number -= nums[i];
                res.append(strs[i]);
            }
        }
        //String으로 변환해서 반환..
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String roman_num1 = scanner.nextLine();
        String roman_num2 = scanner.nextLine();

        int arabia_num1 = transform_roman_numeral_to_number(roman_num1);
        int arabia_num2 = transform_roman_numeral_to_number(roman_num2);

        int sum = arabia_num1 + arabia_num2;
        String SumRoman = transform_number_to_roman_numeral(sum);

        System.out.println(SumRoman);
    }
}
