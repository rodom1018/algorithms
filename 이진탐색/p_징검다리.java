import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        int start = 0;
        int end = distance;
        
        while(start <= end){
            int mid = ( start + end ) / 2;
            
            int remove_rock = 0;
            int prev = 0;
            
            for(int rock: rocks){
                if(rock - prev < mid){
                    remove_rock += 1;
                }else{
                    prev = rock;
                }
            }
            
            //끝에서 2번째 돌 ~ 끝 돌 거리 측정 
            if(distance - prev < mid){
                remove_rock += 1;
            }
            
            //System.out.println(mid + " " + remove_rock);
            
            if(remove_rock <= n){
                start = mid + 1;
                answer = mid;
            }else{
                end = mid - 1;
            }
        }
    
        return answer;
    }
}