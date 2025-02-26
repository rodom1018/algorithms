import java.io.*;
import java.util.*;

class Main{

    static int[][][] dp = new int[101][11][1024];
    static int N;
    static ArrayList<Integer> target_bitmask = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());

        init();

        for(int n=2; n<=100; n++){
            for(int e=0; e<10; e++){
                for(int b=1; b<1024; b++){
                    if(e-1 >=0){
                        if(dp[n-1][e-1][b] > 0){
                            dp[n][e][b | 1<<e] =  (dp[n][e][b | 1<<e] + dp[n-1][e-1][b]) % 1000000000;
                        }
                    }

                    if(e+1 <10){
                        if(dp[n-1][e+1][b] > 0){
                            dp[n][e][b | 1<<e] =  (dp[n][e][b | 1<<e] + dp[n-1][e+1][b]) % 1000000000;
                        }
                    }
                }
            }
        }

        int answer = 0;

        for(int e=0; e<10; e++){
            answer = (answer + dp[N][e][1023]) % 1000000000;
        }
        
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    public static void init(){
        for(int i=1; i<=9; i++){
            dp[1][i][1<<i] = 1;
        }
    }
}