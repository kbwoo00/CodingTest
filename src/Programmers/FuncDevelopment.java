package codingTest;

import java.util.*;

public class FuncDevelopment {

    /*
프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를
return 하도록 solution 함수를 완성하세요.

제한 사항
작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
작업 진도는 100 미만의 자연수입니다.
작업 속도는 100 이하의 자연수입니다.
배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.
예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.

[93, 30, 55]	[1, 30, 5]	[2, 1]
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
     */

    public static void main(String[] args) {
        int[] progress = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(solution(progress, speeds));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> count = new ArrayList<>();
        ArrayList<Integer> period = new ArrayList<>();
        int temp = 0;

        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] != 0)
                period.add((100 - progresses[i]) / speeds[i] + 1);
            else
                period.add((100 - progresses[i]) / speeds[i]);
        }
        // 10 5 5 8 15 3 5 6 7  => 4, 5   /    3 5 1 2 4 10 2 20 1 => 1, 4, 2, 2
        //queue : 5 10 1 1 20 1  =>  1, 3, 2 /  7 3 9  =>  2, 1
        //완성했을때 그 다음 큐가 앞의 날짜들보다 같거나 작으면 같이 뺸다?(빼면서 count++)
        //첫번째 수와 그 다음 수 비교 한다.
        //다음 수와 비교했을 때 전의 수가 더 작으면 1 증가
        //다음 수와 비교했을 떄 전의 수가 같거나 더 크면 다음 다음 수와 비교

        while (period.size() != 0) {
            temp = 0;
            if (period.size() == 1) {
                temp++;
                count.add(temp);
                period.remove(0);
                continue;
            } else if(period.get(0) < period.get(1)){
                period.remove(0);
                temp++;
                count.add(temp);
                continue;
            } else {
                int i= 0;
                // while문에서 period remove를 적정량 해줘야한다.
                //i가 period.size를 넘어가면 안됨.
                while (period.get(0) >= period.get(i+1)){
                    i++;
                    if(i == period.size()-1){
                        temp++;
                        period.remove(0);
                        i--;
                        break;
                    }
                }
                for(int j=0; j<i+1; j++){
                    temp++;
                    period.remove(0);
                }
                count.add(temp);
                continue;
            }
        }

        int[] arr = new int[count.size()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = count.get(i);

        answer = arr;

        return answer;
    }

}

/*
//        for(int i = 0; i< period.size() - 1; i++){ //period size때문에 헷갈린다,,,,, 계속 줄여서 그런가
//            temp = 1; // 초기화 해줘야 함.
//            for(int j=i+1; j<period.size(); j++){
//                if(period.get(i) < period.get(j)){
//                    break;
//                } else {
//                    temp++;
//                }
//            }
//            count.add(temp);
//            i += (temp - 1);
//        }

 */