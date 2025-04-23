import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> distance = new ArrayList<>();
        int max_distance = 0;
        for(int a=0; a<=n; a++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int a=0; a<50005; a++){
            distance.add(new ArrayList<Integer>());
        }
        
        for(int a=0; a<edge.length; a++){
            graph.get(edge[a][0]).add(edge[a][1]);
            graph.get(edge[a][1]).add(edge[a][0]);
        }
        
        LinkedList<int[]> q = new LinkedList<int[]>();
        int[] visited = new int[n+1];
        
        q.add(new int[]{1,0});
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int now_v = temp[0];
            int now_d = temp[1];
            
            if(visited[now_v] == 1) continue;
            
            visited[now_v] = 1;
            
            if(now_d > max_distance){
                max_distance = now_d;
            }
            
            distance.get(now_d).add(now_v);
            
            for(int i=0; i<graph.get(now_v).size(); i++){
                q.add(new int[]{graph.get(now_v).get(i), now_d + 1});
            }
        }
        
        
        return distance.get(max_distance).size();
    }
}