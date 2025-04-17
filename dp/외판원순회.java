import java.io.*;
import java.util.*;

class Main{

    static int N;
    static int[][] cost_map;
    static int[][] dp = new int[16][1<<17];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost_map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                cost_map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<16; i++){
            for(int j=0; j<(1<<17); j++){
                dp[i][j] = Integer.MAX_VALUE - 1000001; // 오버플로우 조심!!! (여기서 해맸다)
            }
        }

        //시작점을 0 이라 가정합니다
        dp[0][1] = 0;
        bfs(0, 1);

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            if(cost_map[i][0] != 0){
                if(answer > dp[i][(1<<N)-1] + cost_map[i][0]){
                    answer = dp[i][(1<<N)-1] + cost_map[i][0];
                }
            }
        }

        
        /*
        for(int i=0; i<4; i++){
            for(int j=0; j<16; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        */

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

        
    }

    public static void bfs(int start, int visited){

        LinkedList<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start, visited});

        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            int now_start = temp[0];
            int now_visited = temp[1];

            //현재 지점인 now_start 에서 i로 가는 경우를 계산
            for(int i=0; i<N; i++){
                //이미 방문했음
                if((1<<i & now_visited) != 0){
                    continue;
                }

                // 이어지지 않았음
                if(cost_map[now_start][i] == 0){
                    continue;
                }

                int temp_cost = dp[now_start][now_visited] + cost_map[now_start][i];
                int after_visited = now_visited | (1<<i);

                //더 낮은 값으로 갱신됨 . 그때는 queue에 넣는다
                if(temp_cost < dp[i][after_visited]){
                    dp[i][after_visited] = temp_cost;
                    queue.add(new int[]{i, after_visited});
                }
            }
        }
    }
}