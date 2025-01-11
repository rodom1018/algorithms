import java.util.*;

class Solution {
    
    //계산한 값은 기록하는 배열(dp)
    //boolean 은 기록 된 값인지를 기록하기 위함 
    int[][] maxDp = new int[202][202];
    boolean[][] maxDpBool = new boolean[202][202];
    
    int[][] minDp = new int[202][202];
    boolean[][] minDpBool = new boolean[202][202];
    
    
    //해당 방정식에서 최대 값을 찾는다 
    public int dfsMax(String[] arr, int start, int end){
        
        int maxValue = -98765432;
        
        // dp에 저장된 값이면 반환 (다시 계산할 필요가 없음)
        if(maxDpBool[start][end] == true){
            return maxDp[start][end];
        }
        
        // 배열 크기가 1이면 그대로 숫자를 반환
        if(start + 1  == end){
            int temp = Integer.parseInt(arr[start]);
            
            //System.out.println(start + " " + end + " " + temp);
            
            maxDp[start][end] = temp;
            maxDpBool[start][end] = true;
            minDp[start][end] = temp;
            minDpBool[start][end] = true;
            
            return temp;
        }
        
        for(int i=start+1; i<end; i+=2){
            if(arr[i].equals("+")){
                int temp = dfsMax(arr, start, i) + dfsMax(arr, i+1, end);
                
                //System.out.println("dfsMax 덧셈 " + start + " " + end + " " + temp);
                
                if(maxValue < temp){
                    maxValue = temp;
                }
            }else{
                int temp = dfsMax(arr, start, i) - dfsMin(arr, i+1, end);
                
                //System.out.println("dfsMax 뺄셈 " +start + " " + end + " " + temp);
                
                if(maxValue < temp){
                    maxValue = temp;
                }
            }
        }
        
        maxDp[start][end] = maxValue;
        maxDpBool[start][end] = true;
        
        return maxValue;
    }
    
    //해당 방정식에서 최소 값을 찾는다
    public int dfsMin(String[] arr, int start, int end){
        
        int minValue = 98765432;
        
        // dp에 저장된 값이면 반환 (다시 계산할 필요가 없음)
        if(minDpBool[start][end] == true){
            return minDp[start][end];
        }
        
        // 배열 크기가 1이면 그대로 숫자를 반환
        if(start + 1  == end){
            int temp = Integer.parseInt(arr[start]);
            
            //System.out.println(start + " " + end + " " + temp);
            
            maxDp[start][end] = temp;
            maxDpBool[start][end] = true;
            minDp[start][end] = temp;
            minDpBool[start][end] = true;
            
            return temp;
        }
        
        for(int i=start+1; i<end; i+=2){
            if(arr[i].equals("+")){
                int temp = dfsMin(arr, start, i) + dfsMin(arr, i+1, end);
                
                //System.out.println("dfsMin 덧셈 " + start + " " + end + " " + temp);
                
                if(minValue > temp){
                    minValue = temp;
                }
            }else{
                int temp = dfsMin(arr, start, i) - dfsMax(arr, i+1, end);
                
                //System.out.println("dfsMin 뺄셈 " + start + " " + end + " " + temp);
                
                if(minValue > temp){
                    minValue = temp;
                }
            }
        }
        
        minDp[start][end] = minValue;
        minDpBool[start][end] = true;
        
        return minValue;
    }
    
    public int solution(String arr[]) {
        dfsMax(arr, 0, arr.length);
        return maxDp[0][arr.length];
    }
}