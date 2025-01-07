class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] school_map = new int[n+1][m+1];
        
        school_map[1][1] = 1;
        
        for(int[] now_puddle : puddles){
            school_map[now_puddle[1]][now_puddle[0]] = -1;
        }
        
        for(int r=1; r<=n; r++){
            for(int c=1; c<=m; c++){
                
                if(r==1 && c==1) continue;
                if(school_map[r][c] == -1) continue;
                
                int a = school_map[r-1][c];
                int b = school_map[r][c-1];
                
                if(a == -1) a = 0;
                if(b == -1) b = 0;
                
                school_map[r][c] = (a + b) % 1000000007;
            }
        }
        
        /*
        for(int r=1; r<=n ;r++){
            for(int c=1; c<=m; c++){
                System.out.print(school_map[r][c] + " ");
            }
            System.out.println();
        }
        */
        
        return school_map[n][m];
    }
}