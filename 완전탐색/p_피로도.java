class Solution {
    
    static int[] visited;
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        
        visited = new int[dungeons.length + 1];
        
        dfs(dungeons, 0, k);
        
        return answer;
    }
    
    public static void dfs(int[][] dungeons, int temp_answer, int health){
        
        if(temp_answer > answer){
            answer = temp_answer;
        }
        
        for(int i=0; i<dungeons.length; i++){
            if(visited[i] == 0){
                if(health >=dungeons[i][0]){
                    visited[i] = 1;
                    dfs(dungeons, temp_answer + 1, health - dungeons[i][1]);
                    visited[i] = 0;
                }
            }
        }
    }
}