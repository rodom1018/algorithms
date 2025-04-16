import java.util.*;
import java.io.*;

class Main{

    static int N;
    static int M;
    static int k;
    static int[][][] memo;
    static int[][][] shark_info;
    static int[] dr = {0,-1,1,0,0};
    static int[] dc = {0,0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        memo = new int[N][N][3];
        shark_info = new int[M+1][5][4];

        int[][] temp = new int[M+1][2];

        for(int a=0; a<N; a++){
            st = new StringTokenizer(br.readLine());
            for(int b=0; b<N; b++){
                memo[a][b][0] = Integer.parseInt(st.nextToken());
                if(memo[a][b][0] != 0){
                    memo[a][b][2] = k;
                    temp[memo[a][b][0]][0] = a;
                    temp[memo[a][b][0]][1] = b;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int a=1; a<=M; a++){
            memo[temp[a][0]][temp[a][1]][1] = Integer.parseInt(st.nextToken());
        }

        for(int a=1; a<=M; a++){
            for(int b=1; b<5; b++){
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<4; c++){
                    shark_info[a][b][c] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int time = 1;

        while(time<=1000){

            int[][][] new_memo = new int[N][N][3];

            //1. 상어들을 한번씩 움직인다
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    //상어 인 경우
                    if(memo[r][c][2] == k){
                        int now_direction = next_direction(r, c);
                        //System.out.println(r);
                        //System.out.println(c);
                        //System.out.println(now_direction);
                        //System.out.println("====");

                        //더 어른 상어가 있으면 격자 밖으로 나가버리기
                        if(new_memo[r+dr[now_direction]][c+dc[now_direction]][0] != 0){
                            if(new_memo[r+dr[now_direction]][c+dc[now_direction]][0] < memo[r][c][0]){
                                continue;
                            }
                        }
                        new_memo[r+dr[now_direction]][c+dc[now_direction]][0] = memo[r][c][0];
                        new_memo[r+dr[now_direction]][c+dc[now_direction]][1] = now_direction;
                        new_memo[r+dr[now_direction]][c+dc[now_direction]][2] = k;
                    }
                }
            }

            //2. 냄새를 1씩 감소시켜서 옮긴다
            movenamsae(new_memo);
            memo = new_memo;

            //3. 1번 상어만 있나요??

            if(isOnlyOneShark()){
                break;
            }

            time++;
        }

        if(time > 1000){
            bw.write("-1");
        }else{
            bw.write(String.valueOf(time));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int next_direction(int r, int c){
        int now_shark = memo[r][c][0];
        int now_shark_dir = memo[r][c][1];
        int answer = -1;

        //아무 냄새가 없는 칸 발굴
        for(int i=0; i<4; i++){
            int temp_direction = shark_info[now_shark][now_shark_dir][i];
            int temp_r = r + dr[temp_direction];
            int temp_c = c + dc[temp_direction];

            if(temp_r < 0 || temp_r >= N || temp_c <0 || temp_c >= N) continue;
            
            if(memo[temp_r][temp_c][0] == 0){
                answer = temp_direction;
                return answer;
            }
        }

        //자신의 냄새가 있는 칸 발굴
        for(int i=0; i<4 ; i++){
            int temp_direction = shark_info[now_shark][now_shark_dir][i];
            int temp_r = r + dr[temp_direction];
            int temp_c = c + dc[temp_direction];

            if(temp_r < 0 || temp_r >= N || temp_c <0 || temp_c >= N) continue;

            if(memo[temp_r][temp_c][0] == now_shark){
                answer = temp_direction;
                return answer;
            }
        }

        //여기까지 오면 안됨!
        return answer;
    }

    static void movenamsae(int[][][] new_memo){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(memo[r][c][2] >1){
                    //k인 칸은 상어가 방금 옮긴 칸임
                    if(new_memo[r][c][2] !=k){
                        new_memo[r][c][0] = memo[r][c][0];
                        new_memo[r][c][2] = memo[r][c][2] - 1;
                    }
                }
            }
        }
    }

    static boolean isOnlyOneShark(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if((memo[r][c][0] != 1 && memo[r][c][0] != 0) && memo[r][c][2] == k){
                    return false;
                }
            }
        }
        
        return true;
    }
}