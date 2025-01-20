import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        //이진 탐색을 위해 정렬
        Arrays.sort(people);
        int start_index = 0;
        int end_index = people.length - 1;      
            
        while(start_index <= end_index){
            
            if(people[start_index] + people[end_index] <= limit){
                start_index++;
                end_index--;
            }else{
                end_index--;
            }
            
            answer += 1;
        }
        return answer;
    }
}