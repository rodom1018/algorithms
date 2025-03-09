import java.util.*;
import java.io.*;

class Main{

    static int N;
    static String[] lines;
    static int[][][][][][] dp;

    static int[] dr = {0,-1,0,1};
    static int[] dc = {1,0,-1,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        lines = new String[N];
        dp = new int[N][N][4][N][N][4];

        for(int i=0; i<N; i++){
            lines[i] = br.readLine();
        }

        bfs(N-1, 0, 0, N-1, 0, 1, 1);

        int answer = Integer.MAX_VALUE;

        for(int d1 = 0; d1 < 4 ; d1++){
            for(int d2 = 0; d2 < 4; d2++){
                if(dp[0][N-1][d1][0][N-1][d2] != 0 && dp[0][N-1][d1][0][N-1][d2] < answer){
                    answer = dp[0][N-1][d1][0][N-1][d2];
                }
            }
        }
        bw.write(String.valueOf(answer -1));
        bw.flush();
        bw.close();
        br.close();
    }


    public static void bfs(int r_1, int c_1, int d_1, int r_2, int c_2, int d_2, int cost_init){

        Queue<int[]> queue = new LinkedList();

        queue.add(new int[]{r_1, c_1, d_1, r_2, c_2, d_2, cost_init}); 

        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            int r1 = temp[0];
            int c1 = temp[1];
            int d1 = temp[2];
            int r2 = temp[3];
            int c2 = temp[4];
            int d2 = temp[5];
            int cost = temp[6];

            //이미 최적해 발견해서 종료
            if(dp[r1][c1][d1][r2][c2][d2] != 0 && dp[r1][c1][d1][r2][c2][d2] <= cost){
                continue;
            }

            dp[r1][c1][d1][r2][c2][d2] = cost;

            //전진
            int nr1 = r1 + dr[d1];
            int nc1 = c1 + dc[d1];
            if(nr1 < 0 || nr1 >= N || nc1 < 0 || nc1 >= N || lines[nr1].charAt(nc1)=='H' || (r1 == 0 && c1 == N-1)){
                nr1 = r1;
                nc1 = c1;
            }

            int nr2 = r2 + dr[d2];
            int nc2 = c2 + dc[d2];
            if(nr2 < 0 || nr2 >= N || nc2 < 0 || nc2 >= N || lines[nr2].charAt(nc2)=='H' || (r2 == 0 && c2 == N-1)){
                nr2 = r2;
                nc2 = c2;
            }
            queue.add(new int[]{nr1, nc1, d1, nr2, nc2, d2, cost + 1});
            //좌회전 
            int d1_left;
            int d2_left;

            if(r1 == 0 && c1 == N-1){
                d1_left = d1;
            }else{
                d1_left = (d1+1)%4;
            }

            if(r2 == 0 && c2 == N-1){
                d2_left = d2;
            }else{
                d2_left = (d2+1) % 4;
            }
            queue.add(new int[]{r1, c1, d1_left, r2, c2, d2_left, cost+1});
            //우회전
            int d1_right;
            int d2_right;

            if(r1 == 0 && c1 == N-1){
                d1_right = d1;
            }else{
                d1_right = (d1+3)%4;
            }

            if(r2 == 0 && c2 == N-1){
                d2_right = d2;
            }else{
                d2_right = (d2+3)%4;
            }

            queue.add(new int[]{r1, c1, d1_right, r2, c2, d2_right, cost+1});

        }
    }
}