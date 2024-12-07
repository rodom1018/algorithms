import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        //초기화 
        int answer = -1;
        ArrayList<Set<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<9; i++){
            list.add(new HashSet<>());
        }
        
        // 1번~9번 써서 나올수 있는 숫자를 수집
        for(int i=1; i<9; i++){
            
            Set<Integer> curSet = list.get(i);
            
            for(int a=1; a<i ; a++){
                int b = i - a;
                
                Set<Integer> a_set = list.get(a);
                Set<Integer> b_set = list.get(b);
                
                
                for(int now_a : a_set){
                    for(int now_b: b_set){
                        curSet.add(now_a + now_b);
                        curSet.add(now_a - now_b);
                        curSet.add(now_a * now_b);
                        
                        if(now_b != 0){
                            curSet.add(now_a / now_b);
                        }
                    }
                }
            }
            
            
            
            // 5, 55, 555, 5555와 같은 숫자 추가 
            curSet.add(Integer.parseInt(Integer.toString(N).repeat(i)));
            
            if(curSet.contains(number)){
                answer = i;
                break;
            }
            
        }
        return answer;
    }
}