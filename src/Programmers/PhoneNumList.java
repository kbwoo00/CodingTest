package codingTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumList {
    /*
    전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록
solution 함수를 작성해주세요.
["119", "97674223", "1195524421"]	false
["123","456","789"]	true
["12","123","1235","567","88"]	false
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] phone_book = {"123","456","789"};
        System.out.println(sol.solution(phone_book));
    }

    static class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            HashMap<String, Integer> map = new HashMap<>();

            for (String phoneNum : phone_book) {
                map.put(phoneNum, 0);
            }
//            Arrays.sort(phone_book);




//            Object[] mapkey = map.keySet().toArray();
//            Arrays.sort(mapkey);

            for (String phoneNum : phone_book){
                for(int i=0; i<=phoneNum.length(); i++){
                    String split = phoneNum.substring(0, i);
                    if(map.containsKey(split)){
                        answer = false;
                        break;
                    }
                }
            }


//            for (String key : map.keySet()) {  //startswith 쓰지말자!
//                for (String phoneNum : phone_book) {
//                    if (key.startsWith(phoneNum) && !key.equals(phoneNum)) {
//                        map.put(key, 1);
//                        answer = false;
//                        break;
//                    }
//                }
//                if (map.get(key) == 1) {
//                    answer = false;
//                    break;
//                }
//            }
            return answer;

            //phone_book 배열 String,Integer Map에 넣기. Integer는 기본값 0;

//            for(String phoneNum : phone_book){
//                map.put(phoneNum, 0);
//                for(String phoneNum2 : phone_book){
//                    if(phoneNum.startsWith(phoneNum2) && phoneNum.equals(phoneNum2)){
//                        answer = false;
//                        break;
//                    }
//                }
//            }

            //배열순회? 맵순회? 하면서 key값의 startswith사용해서 value값 + 1 하기.

//            for(Map.Entry<String, Integer> entry : map.entrySet()){ // 개선해보자
//                String key = entry.getKey();
//                Integer value = entry.getValue();
//                for(String phoneNum : phone_book){
//                    if(key.startsWith(phoneNum) && !key.equals(phoneNum)){
//                        map.put(key, value+1);
//                        answer = false;
//                        break;
//                    }
//                }
//                if(value >= 1){
//                    answer = false;
//                    break;
//                }
//            }

            //value값이 2이상이면 접두어를 가지고 있다는 것!! => answer를 false로 바꾸기


        }
    }

}
