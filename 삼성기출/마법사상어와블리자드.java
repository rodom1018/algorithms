import java.util.*;
import java.io.*;

public class Main{

    static int N;
    static int M;
    static int answer = 0;

    static int[][] shark_temp;
    static int[][] magic_direction = new int[5][24];
    static ArrayList<Integer> shark_map = new ArrayList<>();

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        shark_temp = new int[N+1][N+1];

        for(int i=1 ; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=N ; j++){
                shark_temp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /* convertToArray() 확인용
        for(Integer element: shark_map){
            System.out.print(element+ " ");
        }
        */
        magicDirectionInit();
        convertToArray();

        for(int a=0; a<M; a++){
            st = new StringTokenizer(br.readLine());
            int now_d = Integer.parseInt(st.nextToken());
            int now_s = Integer.parseInt(st.nextToken());

            // 1. 상어가 마법을 쓰면 해당 칸 구슬을 파괴 
            for(int s = now_s-1; s>=0; s--){
                if(shark_map.size() > magic_direction[now_d][s]){
                    shark_map.remove(magic_direction[now_d][s]);
                }
            }

            // 2. 구슬이 폭발하는 단계
            boolean flag = true;
            while(flag){
                flag = false;

                if(shark_map.size() < 4){
                    break;
                }

                int prev = shark_map.get(shark_map.size() - 1);
                int prev_index = shark_map.size() - 1;
                int combo = 0;

                for(int i = shark_map.size() - 2; i>=0; i--){
                    int temp = shark_map.get(i);
                    

                    if(shark_map.get(i) == prev){
                        combo += 1;
                    }else{
                        if(combo >= 3){
                            answer += (combo + 1) * prev;
                            shark_map.subList(i+1, i+1+combo+1).clear();
                            flag = true;
                        }
                        prev = shark_map.get(i);
                        prev_index = i;
                        combo = 0;
                    }
                }

                // 혹시 처음 부분이 콤보 일 때 대비
                if(combo>=3){
                    answer += (combo + 1) * prev;
                    shark_map.subList(0, combo+1).clear();
                    flag = true;
                }
                
            }

            // 3. 구슬이 변화하는 단계 
            ArrayList<Integer> new_shark_map = new ArrayList<>();

            int prev = -1;
            int combo = 0;

            for(int i=0; i<shark_map.size(); i++){
                if(shark_map.get(i) == prev){
                    combo += 1;
                }else{
                    if(prev != -1){
                        new_shark_map.add(combo+1);
                        new_shark_map.add(prev);
                    }
                    prev= shark_map.get(i);
                    combo = 0;
                }
            }
            
            if(prev != -1){
                new_shark_map.add(combo+1);
                new_shark_map.add(prev);
            }

            //넘친건 사라짐
            if(new_shark_map.size() >= N*N){
                new_shark_map.subList(N*N - 1, new_shark_map.size()).clear();
            }
            shark_map = new_shark_map;

            /*
            System.out.println("마법 1번 완료~~");
            for(Integer element: shark_map){
                System.out.print(element+ " ");
            }
            System.out.println();
            */
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }

    public static void magicDirectionInit(){
        //상어가 마법부릴 때 어떤 칸이 지워지는지 미리 기록 해 둔다.
        magic_direction[1][0] = 6;
        magic_direction[1][1] = 21;

        magic_direction[2][0] = 2;
        magic_direction[2][1] = 13;

        magic_direction[3][0] = 0;
        magic_direction[3][1] = 9;

        magic_direction[4][0] = 4;
        magic_direction[4][1] = 17;

        for(int i=2; i<=23; i++){
            for(int j=1; j<=4 ;j++){
                magic_direction[j][i] = magic_direction[j][i-1] + ( magic_direction[j][i-1] - magic_direction[j][i-2] + 8 );
            }
        }
    }


    public static void convertToArray(){
        int mid = (N+1) / 2;
        int now_r = mid;
        int now_c = mid-1;

        while(true){
            if(now_r == 0 || now_c ==0){
                break;
            }

            shark_map.add(shark_temp[now_r][now_c]);

            int max_d = Math.max(Math.abs(now_r - mid), Math.abs(now_c - mid));
            
            //왼쪽 아래 모서리
            if(now_r - mid == max_d && now_c - mid == -max_d){
                now_c += 1;
                continue;
            }

            //오른쪽 아래 모서리
            if(now_r - mid == max_d && now_c - mid == max_d){
                now_r -= 1;
                continue;
            }

            //오른쪽 위 모서리
            if(now_r - mid == -max_d && now_c - mid == max_d){
                now_c -= 1;
                continue;
            }

            //왼쪽 위 모서리
            if(now_r - mid == -max_d + 1 && now_c - mid == -max_d){
                now_r += 1;
                continue;
            }

            //모서리가 아닌 일반적인 경우
            if(now_r - mid == max_d){
                now_c += 1;
                continue;
            }

            if(now_r - mid == -max_d){
                now_c -= 1;
                continue;
            }

            if(now_c - mid == max_d){
                now_r -= 1;
                continue;
            }

            if(now_c - mid == -max_d){
                now_r += 1;
                continue;
            }
        }

    }
}