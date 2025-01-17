import java.util.*;

// 시간 초과 버전으로 풀어도 코테에는 지장 없을 듯 함 . 
// 시간 초과 버전에 비해 
// 1. StringBuilder 사용
// 2. 9를 만나면 즉시 loop 를 빠져나온다
// 를 변화 하였음.
class Solution {
    public String solution(String number, int k) {
        
        int pickCount = number.length() - k;
        int nowStart = 0;
        StringBuilder sb = new StringBuilder();
        char looking_char = 9;
        for(int i = pickCount ; i > 0 ; i--){
            
            char temp_max = 0;
            int temp_max_index = -1;
            
            for(int p = nowStart ; p <= number.length() - i ; p++){
                
                if(number.charAt(p) == looking_char){
                    temp_max = number.charAt(p);
                    temp_max_index = p;
                    break;
                }
                
                if(temp_max < number.charAt(p)){
                    temp_max = number.charAt(p);
                    temp_max_index = p;
                }
            }
            
            sb.append(temp_max);
            nowStart = temp_max_index + 1;
        }
        
        return sb.toString();
    }
}