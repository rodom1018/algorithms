import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        //초기화 
        ArrayList<Set<Integer>>[] list = new ArrayList[9];
        
        for(int i=0;i<9; i++){
            list[i] = new HashSet<>();
        }
        
        // 1번~9번 써서 나올수 있는 숫자를 수집
        for(int i=1; i<9; i++){
            for(int a=1; a<i ; a++){
                
            }
            
            
            
            // 5, 55, 555, 5555와 같은 숫자 추가 
            String temp = "";
            for(int t=0 t<=i; t++){
                temp = temp + (String) number;
            }
            
        }
        int answer = 0;
        return answer;
    }
}