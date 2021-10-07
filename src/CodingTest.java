import java.lang.reflect.Array;
import java.util.*;

public class CodingTest {
    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0,1}, {1,1,0,0,0}, {0,0,1,1,0}, {0,0,1,1,0},{1,0,0,0,1}};
        Solution sol = new Solution();
        System.out.println(sol.solution(5, arr));

    }

    static class Solution {
        //컴퓨터 개수 n (1이상 200 이하 자연수)
        //각 컴퓨터는 0부터 n-1인 정수로 표현
        //i번 컴퓨터와 j번 컴퓨터 연결되어 있으면 computers[i][j]를 1로 표현
        //computer[i][j]는 항상 1
        //연결에 대한 정보가 담김 2차원 배열 computers
        //네트워크 개수 return
        //
        public int solution(int n, int[][] computers) {
            int answer = 0;

            Integer startNode = 0;
            HashMap<Integer, int[]> netWork = new HashMap<>();

            for(int i=0; i<n; i++){
                netWork.put(i, computers[i]);
            }

            //방문했던 리스트와 방문할 list 생성
            ArrayList<Integer> visited = new ArrayList<>();
            Stack<Integer> needVisit = new Stack<>();

//        visited사이즈가 n보다 크면 반복문종료
           while(visited.size()<n){

               needVisit.push(startNode);

               //needVisit.size가 0이 되면 반복문 종료(DFS) 구현
               while(needVisit.size() > 0){
                   Integer node = needVisit.pop();

                   if (!visited.contains(node)){
                       visited.add(node);
                   } else{
                       continue;
                   }

                   for (int i=0; i<n; i++){
                       if (netWork.get(node)[i] == 1){
                           needVisit.push(i);
                       }
                   }
               }

               //startNode를 변화시켜주자
               //만약 visited에 원하는 컴퓨터 번호가 없으면 start노드를 변화시켜줌.
               for (int i=0; i<n; i++){
                   if(!visited.contains(i)){
                       startNode = i;
                       break;
                       //쓸데없는 반복 방지.
                   }
               }

               //한개 네트워크 종료
               answer += 1;
           }

            return answer;
        }
    }
}
