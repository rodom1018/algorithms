import java.util.*;

class Solution {
    
    int[] answer = new int[505];
    
    public int solution(int[][] triangle) {
        
        for(int[] now_row : triangle){
            
            int[] temp_answer = new int[505];
            
            for(int i=0; i< now_row.length ; i++){
                
                int left = 0;
                int right = 0;
                
                if(i==0){
                    left = now_row[i];
                    right = answer[i] + now_row[i]; 
                    
                }else{
                    left = answer[i-1] + now_row[i];
                    right = answer[i] + now_row[i];         
                }
                
                temp_answer[i] = Math.max(left,right);
            }
            
            for(int j=0; j < triangle.length ; j++){
                answer[j] = temp_answer[j];
            }
        }
        
        int real_answer = 0;
        for(int i=0; i < triangle.length ; i++){
            if(real_answer < answer[i]){
                real_answer = answer[i];
            }
        }
        
        return real_answer;
    }
}