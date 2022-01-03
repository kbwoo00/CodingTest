package codingTest;

import java.util.Arrays;

public class Knumber {

    //배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
//    예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
//    array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
//  1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
//  2에서 나온 배열의 3번째 숫자는 5입니다.

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
        System.out.println(Arrays.toString(sol.solution(arr,commands)));

    }

    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            int[] newArr;
            for(int i=0; i<commands.length;i++){
                int j, k, l;
                j = commands[i][0] - 1;
                k = commands[i][1];
                l = commands[i][2] - 1;
                newArr = Arrays.copyOfRange(array, j, k);
                Arrays.sort(newArr);
                answer[i] = newArr[l];
            }
            return answer;
        }
    }
}
