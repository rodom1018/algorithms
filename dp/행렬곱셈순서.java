import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] r = new int[505];
        int[] c = new int[505];
        int[] answer = new int[505];

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        //[start - end] 까지 행렬 곱셈하는데 필요한 곱셈 연산의 최솟값을 구한다.
        int dp[][] = new int[505][505];

        //거리차 1인 거부터 ~ N-1까지 정복
        for(int diff=1; diff<=N-1; diff++){
            // [1-1+diff], [2-2+diff], [3-3+diff] ....에 필요한 연산 구함
            for(int start=0; start+diff<N; start++){
                if(diff == 1){
                    dp[start][start+diff] = r[start] * c[start] * c[start+diff];
                }else{
                    int now_min = Integer.MAX_VALUE;

                    for(int mid=start; mid<start+diff; mid++){
                        int temp = dp[start][mid] + dp[mid+1][start+diff] + r[start] * c[mid] * c[start+diff];

                        if(temp < now_min){
                            now_min = temp;
                        }
                    }

                    dp[start][start+diff] = now_min;
                }
            }
        }

        bw.write(String.valueOf(dp[0][N-1]));
        bw.flush();
        bw.close();
        br.close();
    }
}