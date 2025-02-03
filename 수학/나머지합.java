import java.util.*;
import java.io.*;

public class Main{

    //answer과 경우의 수 곱할 때 long 형으로 다뤄야 함을 주의!!
    // 10^6 * 10^6 하면 오버플로우가 발생한다.
    public static void main(String[] args) throws IOException{
        
        int[] memo = new int[1010];

        //answer long 형 주의 
        long answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int prev = 0;
        memo[prev] += 1;

        for(int i=0; i<N ; i++){
            prev = (int) ((prev + Integer.parseInt(st.nextToken())) % M);
            memo[prev] += 1;
        }

        for(int i=0; i<M; i++){       
            if(memo[i] >= 2){
                //long 형 주의 
                answer += ((long)memo[i] * (memo[i] - 1)) / 2;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();

        bw.close();
        br.close();

    }
}