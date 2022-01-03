package codingTest;

/*
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고,
이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요
 */


//가능한 배열 모두 만들어서 찾으면 시간이 너무 오래 걸리고 왜인지 런타임 에러가 발생한다.
import java.util.ArrayList;
import java.util.Collections;

public class BiggestNum {


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {6, 10, 2};

        System.out.println(sol.solution(numbers));
    }

    static class Solution {
        public String solution(int[] numbers) {
            ArrayList<Integer> newNumbers = new ArrayList<>();
            String temp = "";

            String answer = "";

            //1. numbers 이용해서 순열로 모든 경우의 숫자배열 만들기
            permutation(numbers, 0,numbers.length, newNumbers, temp);
            Collections.sort(newNumbers, Collections.reverseOrder());
            answer += newNumbers.get(0);
            return answer;
        }

        static void permutation(int[] numbers, int depth, int n, ArrayList<Integer> newNumbers, String temp){ //n은 배열길이
            if(depth == n){
                for(int j = 0; j<n; j++){ //String배열 만들고
                    temp += String.valueOf(numbers[j]); //에러?
                }
                newNumbers.add(Integer.parseInt(temp));
                temp = "";
                return;
            }
            for(int i=depth; i<n; i++){
                swap(numbers, depth, i);
                permutation(numbers, depth+1, n, newNumbers, temp);
                swap(numbers, depth, i);
            }
        }

        static void swap(int[] numbers, int depth, int i){
            int temp = numbers[depth];
            numbers[depth] = numbers[i];
            numbers[i] = temp;
        }


    }
}
