class Solution {
    public int solution(String name) {
        
        int answer = 0;
        int move = name.length() - 1;
        // 'A' 와의 차이와  'Z' 와의 차이 + 1 중 작은 것을 선택한다.
        for(int i=0 ; i< name.length() ; i++){
            //System.out.println(Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1));
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int temp_index = i+1;
            while(temp_index < name.length() && name.charAt(temp_index) == 'A'){
                temp_index += 1;
            }
            
            // (가)'AAA(A뭉탱이)'(나) 가 있을 때 최솟값 구하기 - 3가지 경우중
            // 1) 그냥 일반적으로 순회하는 경우
            // 2) (가) * 2 + (나)
            move = Math.min(move, (i*2) + name.length() - temp_index);
            // 3) (가) + (나) * 2
            move = Math.min(move, i + (name.length() - temp_index) * 2);
            
        }
        
        //System.out.println(move);
        answer += move;
        
        return answer;
    }
}