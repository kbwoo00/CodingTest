package codingTest;
/*
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고,
이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요
 */

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNum2 {
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] numbers = {0,0,0};

        System.out.println(sol.solution(numbers));
    }

    static class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            String[] arr = new String[numbers.length];
            for(int i=0; i<numbers.length; i++){
                arr[i] = String.valueOf(numbers[i]);
            }
            Arrays.sort(arr, new Comparator<String>(){
                @Override
                public int compare(String x, String y) {
                    return (y+x).compareTo(x+y);
                }
            });

            if(arr[0] == "0")
                return "0";

            for(int i=0; i<arr.length; i++)
                answer += arr[i];

            return answer;
        }

    }
}
