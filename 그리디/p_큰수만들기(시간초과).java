import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        int pickCount = number.length() - k ;
        int nowStart = 0;
        String answer = "";
        
        for(int i = pickCount ; i > 0 ; i--){
            
            int temp_max = -1;
            int temp_max_index = -1;
            
            for(int p = nowStart ; p <= number.length() - i ; p++){
                if(temp_max < (int) number.charAt(p)){
                    temp_max = (int) number.charAt(p);
                    temp_max_index = p;
                }
            }
            
            answer += number.charAt(temp_max_index);
            nowStart = temp_max_index + 1;
        }
        
        return answer;
    }
}