class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long start = 0;
        long end = 1000000000000000000L;
        
        while(start <= end){
            long mid = ( start + end ) / 2;
            
            long temp = 0;
            
            for(int i=0; i<times.length ; i++){
                temp += (mid / times[i]);
            }
            //System.out.println(mid + " " + temp);
            
            if(temp >= n){
                answer = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return answer;
    }
}