package Programmers;

/*
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

 [1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
 */

import java.util.ArrayList;
import java.util.Arrays;

public class MockExam {
    public static void main(String[] args) {
        int[] answer = {1,2,3,4,5};
        System.out.println(solution(answer).toString());

    }

    public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] count = new int[3];

        //1번, 2번, 3번 모두 배열의 길이는 answers의 길이와 같음
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> arr3 = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for(int i = 1; i<= answers.length; i++){
            if(i % 5 != 0)
                arr1.add(i % 5);
            else
                arr1.add(5);
        }

        for(int i = 1; i<= answers.length; i++){
            if(i%2==1)
                arr2.add(2);
            else {
                if(i % 8 == 0){
                    arr2.add(5);
                } else if(i % 8 == 6){
                    arr2.add(4);
                } else if(i % 8 == 4){
                    arr2.add(3);
                } else{
                    arr2.add(1);
                }
            }
        }

        for(int i = 1; i<= answers.length; i++){
            if(i % 10 == 1 || i % 10 == 2){
                arr3.add(3);
            } else if(i % 10 == 3 || i % 10 == 4){
                arr3.add(1);
            } else if(i % 10 == 5 || i % 10 == 6){
                arr3.add(2);
            } else if(i % 10 == 7 || i % 10 == 8){
                arr3.add(4);
            } else {
                arr3.add(5);
            }
        }

        //각 배열과 answers 비교해서 같으면 count 1씩 올리기
        for(int i=0; i<answers.length; i++){
            if(answers[i] == arr1.get(i))
                count1++;
            if(answers[i] == arr2.get(i))
                count2++;
            if(answers[i] == arr3.get(i))
                count3++;
        }
        count[0] = count1;
        count[1] = count2;
        count[2] = count3;

        if(count1 == count2 && count2 == count3){
            int[] newArr = new int[3];
            newArr[0] = 1;
            newArr[1] = 2;
            newArr[2] = 3;
            answer = newArr;
        } else if(count1 == count2 && count1 > count3){
            int[] newArr = new int[2];
            newArr[0] = 1;
            newArr[1] = 2;
            answer = newArr;
        } else if(count2 == count3 && count2 > count1){
            int[] newArr = new int[2];
            newArr[0] = 2;
            newArr[1] = 3;
            answer = newArr;
        } else if(count1 == count3 && count1 > count2){
            int[] newArr = new int[2];
            newArr[0] = 1;
            newArr[1] = 3;
            answer = newArr;
        } else if(count1 > count2 && count1 > count3){
            int[] newArr = {1};
            answer = newArr;
        } else if(count2 > count1 && count2 > count3){
            int[] newArr = {2};
            answer = newArr;
        } else if(count3 > count2 && count3 > count1){
            int[] newArr = {3};
            answer = newArr;
        }



        //count들 비교해서 높은 것 찾기, 리턴, 같으면 다 리턴(여럿일 경우 오름차순해서)


        return answer;
    }
}
