import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        boolean[] lost_bool = new boolean[lost.length];
        boolean[] reserved_bool = new boolean[reserve.length];
        int weared = 0;
        
        for(int i=0; i < lost.length ;i++){
            for(int j=0; j < reserve.length ; j++){
                if(lost[i] == reserve[j]){
                    lost_bool[i] = true;
                    reserved_bool[j] = true;
                    weared += 1;
                }
            }
        }
        
        for(int i=0 ; i < lost.length ;i++){
            
            if(lost_bool[i] == true){
                continue;
            }
            
            for(int j=0; j < reserve.length ; j++){
                
                if(reserved_bool[j] == true){
                    continue;
                }
                
                int nowLost = lost[i];
                int nowReserve = reserve[j];
                
                if(nowLost -1 == nowReserve || nowLost + 1 == nowReserve){
                    weared += 1;
                    lost_bool[i] = true;
                    reserved_bool[j] = true;
                    break;    
                }
            } 
            
        }
        
        int answer = n - lost.length + weared;
        return answer;
    }
}