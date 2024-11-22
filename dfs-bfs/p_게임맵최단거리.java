import java.util.*;

class Solution {
    
    int[][] visited;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    
    public int solution(int[][] maps) {
        
        int row = maps.length;
        int col = maps[0].length;
        
        visited = new int[row][col];
        
        bfs(maps);
        
        /*
        for(int r=0 ; r<row; r++){
            for(int c=0; c< col; c++){
                System.out.print(visited[r][c] + " ");
            }
            System.out.println();
        }
        */
        
        if(visited[row-1][col-1] == 0){
            return -1;
        }else{
            return visited[row-1][col-1];
        }
        
    }
    
    
    public void bfs(int[][] maps){
        
        int row = maps.length;
        int col = maps[0].length;
        
        visited[0][0] = 1;
        
        Queue<int[]> queue = new LinkedList();
        
        queue.add(new int[]{0,0});
        
        while(queue.size() > 0){
            int[] temp = queue.poll();
            int now_value = visited[temp[0]][temp[1]];
            
            for(int i=0; i<4; i++){
                int temp_x = temp[0] + dx[i];
                int temp_y = temp[1] + dy[i];
                
                // 범위 밖
                if(temp_x < 0 || temp_y < 0 || temp_x >= row || temp_y >= col){
                    continue;
                }
                
                // 이미 방문 했거나, 벽인 경우
                if(visited[temp_x][temp_y] != 0 || maps[temp_x][temp_y] == 0){
                    continue;
                }
                
                visited[temp_x][temp_y] = now_value + 1;
                queue.add(new int[]{temp_x, temp_y});
                
            }  
            
        }
        
    }
    
    
}import java.util.*;

class Solution {
    
    int[][] visited;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    
    public int solution(int[][] maps) {
        
        int row = maps.length;
        int col = maps[0].length;
        
        visited = new int[row][col];
        
        bfs(maps);
        
        /*
        for(int r=0 ; r<row; r++){
            for(int c=0; c< col; c++){
                System.out.print(visited[r][c] + " ");
            }
            System.out.println();
        }
        */
        
        if(visited[row-1][col-1] == 0){
            return -1;
        }else{
            return visited[row-1][col-1];
        }
        
    }
    
    
    public void bfs(int[][] maps){
        
        int row = maps.length;
        int col = maps[0].length;
        
        visited[0][0] = 1;
        
        Queue<int[]> queue = new LinkedList();
        
        queue.add(new int[]{0,0});
        
        while(queue.size() > 0){
            int[] temp = queue.poll();
            int now_value = visited[temp[0]][temp[1]];
            
            for(int i=0; i<4; i++){
                int temp_x = temp[0] + dx[i];
                int temp_y = temp[1] + dy[i];
                
                // 범위 밖
                if(temp_x < 0 || temp_y < 0 || temp_x >= row || temp_y >= col){
                    continue;
                }
                
                // 이미 방문 했거나, 벽인 경우
                if(visited[temp_x][temp_y] != 0 || maps[temp_x][temp_y] == 0){
                    continue;
                }
                
                visited[temp_x][temp_y] = now_value + 1;
                queue.add(new int[]{temp_x, temp_y});
                
            }  
            
        }
        
    }
    
    
}