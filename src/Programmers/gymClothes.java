package codingTest;

import java.util.Arrays;
/*
점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

 제한사항
전체 학생의 수는 2명 이상 30명 이하입니다.
체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.

** 예외 케이스 발생...
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며,
남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 */
public class gymClothes {
    public static void main(String[] args) {

        /*
        n	lost	    reserve	    return
        5	[2, 4]	    [1, 3, 5]	5
        5	[2, 4]	    [3]	        4
        3	[3]	        [1]	        2
         */

        int n = 3;
        int[] lost = {3};
        int[] reverse = {1};

        int answer = solution(n,lost,reverse);
        System.out.println(answer);

    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int minus = 0;
        int plus = 0;
        int cnt = 0;
        int stillLost = lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // lost 배열에서 값들 각각 순차적으로 -1을 했을 때 reverse에 그 값이 있는지 확인
        /*
    while문으로 reverse 사라지거나 또는 lost가 사라지거나 둘 중 하나
    앞 뒤 사람을 체크해서 lost의 사람(이 사람은 굳이 제거할 필요 없을듯)과
    reverse의 사람을 하나씩 제거해줘야하는데(중복되면 안되기 때문에) 아니다 제거할 필요 없다. => 값을 0으로 만들어 버리자.
    0으로 만들때 마다 카운트 올리기
     */
        for(int i=0; i<lost.length;i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    reserve[j] = 0;
                    lost[i] = -2;
                    stillLost--;
                    break;
                }
            }
        }
        for(int i=0; i<lost.length; i++){
            minus = lost[i] - 1;
            plus = lost[i] + 1;
            // 앞사람이 없는 경우(1번 학생)
            // plus 로직만 수행
            if(minus == 0){
                for(int j=0; j< reserve.length; j++){
                    if(reserve[j] == plus){
                        reserve[j] = 0;
                        cnt++;
                        break;
                    }
                }
            } else if(plus == n + 1) {
                for(int j=0; j<reserve.length; j++){
                    if(reserve[j] == minus){
                        reserve[j] = 0;
                        cnt++;
                        break;
                    }
                }
            } else{
                for(int j=0; j<reserve.length; j++){
                    if(reserve[j] == minus){
                        reserve[j] = 0;
                        cnt++;
                        break;
                    } else if (reserve[j] == plus){
                        reserve[j] = 0;
                        cnt++;
                        break;
                    } else {
                        continue;
                    }
                }
            }
        }
        // answer의 값은 결국 n - lost배열 크기 + count 횟수
        answer = n - stillLost + cnt;
        return answer;
    }
}
