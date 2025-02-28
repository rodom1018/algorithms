import java.util.*;
import java.io.*;

class Main{

    static int N;
    static int[] songs;
    static int[][] dp;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        songs = new int[N+1];
        dp = new int[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            songs[i] = Integer.parseInt(st.nextToken());
        }

        for(int a=0; a<=N; a++){
            for(int b=0; b<=N; b++){
                dp[a][b] = Integer.MAX_VALUE;
            }
        }

        dp[0][1] = 0;
        dp[1][0] = 0;

        for(int s=1; s<N; s++){
            //전 곡을 a가 부른 경우
            for(int i=0; i<s; i++){
                //이번곡을 a가 부르는 경우
                dp[s+1][i] = Math.min(dp[s+1][i], dp[s][i] + Math.abs(songs[s+1] - songs[s]));

                //이번곡을 b가 부르는 경우
                if(i==0){
                    dp[s][s+1] = Math.min(dp[s][s+1], dp[s][i]);
                }else{
                    dp[s][s+1] = Math.min(dp[s][s+1], dp[s][i] + Math.abs(songs[s+1] - songs[i]));
                }
            }

            //전 곡을 b가 부른 경우
            for(int i=0; i<s; i++){
                //이번곡을 a가 부르는 경우
                if(i==0){
                    dp[s+1][s] = Math.min(dp[s+1][s], dp[i][s]);
                }else{
                    dp[s+1][s] = Math.min(dp[s+1][s], dp[i][s] + Math.abs(songs[s+1] - songs[i]));
                }

                //이번곡을 b가 부르는 경우
                dp[i][s+1] = Math.min(dp[i][s+1], dp[i][s] + Math.abs(songs[s+1] - songs[s]));

            }

            /*
            for(int a=0; a<=N; a++){
                for(int b=0; b<=N; b++){
                    System.out.print(dp[a][b] + " ");
                }
                System.out.println();
            }
            System.out.println();
            */
        }

        //마지막곡이 a인 경우
        for(int i=0; i<N; i++){
            answer = Math.min(answer, dp[N][i]);
        }

        //마지막곡이 b인 경우
        for(int i=0; i<N; i++){
            answer = Math.min(answer, dp[i][N]);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }
}