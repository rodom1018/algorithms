import java.io.*;
import java.util.*;

class Main{
    static int N;
    static int M;
    static int[][] my_map;
    static int[][] dp;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        my_map = new int[N][M];
        dp = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                dp[i][j] = -1;
            }
        }
        dp[N-1][M-1] = 1;

        for(int a=0; a<N; a++){
            st = new StringTokenizer(br.readLine());
            for(int b=0; b<M; b++){
                my_map[a][b] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        bw.write(String.valueOf(dp[0][0]));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int n, int m){

        //이미 계산한 연산값
        if(dp[n][m] != -1){
            return dp[n][m];
        }

        dp[n][m] = 0;

        for(int i=0; i<4; i++){
            int temp_n = n + dx[i];
            int temp_m = m + dy[i];


            if(temp_n <0 || temp_n >= N || temp_m <0 || temp_m >= M){
                continue;
            }

            if(my_map[n][m] > my_map[temp_n][temp_m]){
                dp[n][m] += dfs(temp_n, temp_m);
            }
        }

        return dp[n][m];
    }


}