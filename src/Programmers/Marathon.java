package codingTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Marathon {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        String[] participant = {"mislav", "stanko", "mislav", "ana"};
//        String[] completion = {"stanko", "ana", "mislav"};

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

//        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(sol.solution(participant, completion));

    }

    static class Solution{
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            //시간 초과...
//            List<String> list = new ArrayList<String>(Arrays.asList(participant));
//            for(int i=0; i<completion.length; i++){
//                list.remove(completion[i]);
//            }
//            answer = list.get(0);

            HashMap<String, Integer> map = new HashMap<>();
            for(int i=0; i<participant.length; i++){
                if(map.containsKey(participant[i]))
                    map.put(participant[i], map.get(participant[i])-1);
                else
                    map.put(participant[i],0);
            }
            for(int i=0; i<completion.length; i++){ //여기서 문제
                //참가선수중에 완주한 선수 체크
                if(map.containsKey(completion[i]))
                    map.put(completion[i], map.get(completion[i]) + 1);
            }
            //동명이인 체크해서 answer를 바꾸기
            for(Map.Entry<String, Integer> entry: map.entrySet()){
                String key = entry.getKey();
                Integer value = entry.getValue();
                if(value == Integer.valueOf(0))
                    answer = key;
            }


            return answer;
        }
    }
}
