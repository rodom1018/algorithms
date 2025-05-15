import java.util.*;
import java.io.*;

class Mulgogi{

    public int num;
    public int direction;

    Mulgogi(int num, int direction){
        this.num = num;
        this.direction = direction;
    }
}

class Shark{

    public int r;
    public int c;
    public int direction;

    Shark(int r, int c, int direction){
        this.r = r;
        this.c = c;
        this.direction = direction;
    }
}
class Main{

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0,-1,-1,-1,0,1,1,1};
    static int real_answer = 0 ;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int first_num = 0;
        int first_direction = 0;
        Mulgogi[][] fish_map = new Mulgogi[4][4];
        int[][] fish_info = new int[17][2];
            
        for(int r=0; r<4; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<4; c++){

                int temp_num = Integer.parseInt(st.nextToken());
                int temp_direction = Integer.parseInt(st.nextToken());

                if(r==0 && c==0){
                    first_num = temp_num;
                    first_direction = temp_direction;
                    fish_info[temp_num][0] = -1;
                    fish_info[temp_num][1] = -1;
                    continue;
                }
                
                fish_map[r][c] = new Mulgogi(temp_num, temp_direction);
                fish_info[temp_num][0] = r;
                fish_info[temp_num][1] = c;
            }
        }

        Shark shark = new Shark(0,0,first_direction);
        
        /*
        for(int r=0; r<4; r++){
            for(int c=0; c<4; c++){
                if(r==0 &&  c==0) continue;
                System.out.println(fish_map[r][c].num + " " + fish_map[r][c].direction);
            }
        }
        */

        /*
        for(int a=1; a<=16;a++){
            System.out.println(fish_info[a][0] + " " + fish_info[a][1]);
        }
        */
        dfs(fish_map, fish_info, shark, 0);

        real_answer += first_num;
        bw.write(String.valueOf(real_answer));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(Mulgogi[][] fish_map, int[][] fish_info, Shark shark, int answer){
        // 0. 현재 상태를 복사
        Mulgogi[][] temp_map = new Mulgogi[4][4];
        int[][] temp_info = new int[17][2];
        Shark temp_shark = new Shark(shark.r, shark.c, shark.direction);

        for(int a=0; a<4; a++){
            for(int b=0; b<4; b++){
                temp_map[a][b] = fish_map[a][b];
            }
        }

        for(int a=1; a<=16; a++){
            for(int b=0; b<2; b++){
                temp_info[a][b] = fish_info[a][b];
            }
        }

        // 1. 물고기가 이동한다.
        for(int a=1; a<=16; a++){
            if(temp_info[a][0] == -1 && temp_info[a][1] == -1) continue;

            int now_r = temp_info[a][0];
            int now_c = temp_info[a][1];
            int now_dir = temp_map[temp_info[a][0]][temp_info[a][1]].direction; //
            //System.out.println(a + "번 물고기 : " + now_r + " " + now_c);

            int count = 0;

            while(now_r + dr[now_dir-1] < 0 || now_r + dr[now_dir-1] >= 4 || 
                now_c + dc[now_dir-1] < 0 || now_c + dc[now_dir-1] >=4 ||
                (now_r + dr[now_dir-1] == temp_shark.r && now_c + dc[now_dir-1] == temp_shark.c)){
                    now_dir +=1;
                    if(now_dir>=9){
                        now_dir -=8;
                    }
                    count++;

                    if(count >= 8){
                        break;
                    }
                }

            if(count < 8){
                if(temp_map[now_r + dr[now_dir-1]][now_c + dc[now_dir-1]] != null){
                    //두 물고기 자리 swap
                    Mulgogi swap_fish = new Mulgogi(temp_map[now_r][now_c].num, now_dir);
                    int swap_fish_num = temp_map[now_r + dr[now_dir-1]][now_c + dc[now_dir-1]].num;

                    temp_map[now_r][now_c] = new Mulgogi(temp_map[now_r + dr[now_dir-1]][now_c + dc[now_dir-1]].num, temp_map[now_r + dr[now_dir-1]][now_c + dc[now_dir-1]].direction);
                    temp_info[swap_fish_num][0] = now_r;
                    temp_info[swap_fish_num][1] = now_c;

                    temp_map[now_r + dr[now_dir-1]][now_c + dc[now_dir-1]] = swap_fish;
                    temp_info[a][0] = now_r + dr[now_dir-1];
                    temp_info[a][1] = now_c + dc[now_dir-1];
                }else{
                    //이번 물고기 자리 움직이기
                    temp_map[now_r + dr[now_dir-1]][now_c + dc[now_dir-1]] = new Mulgogi(temp_map[now_r][now_c].num, now_dir);
                    temp_map[now_r][now_c] = null;
                    temp_info[a][0] = now_r + dr[now_dir-1];
                    temp_info[a][1] = now_c + dc[now_dir-1];
                }
            }
        }


        // 2. 상어의 이동

        int flag = 0;
        while(temp_shark.r + dr[temp_shark.direction-1] >= 0 && temp_shark.r + dr[temp_shark.direction - 1] < 4 
            && temp_shark.c + dc[temp_shark.direction-1] >= 0 && temp_shark.c + dc[temp_shark.direction-1] < 4){
                //그 칸에 물고기가 있으면?
                if(temp_map[temp_shark.r + dr[temp_shark.direction-1]][temp_shark.c + dc[temp_shark.direction-1]] != null){
                    temp_shark.r = temp_shark.r + dr[temp_shark.direction-1];
                    temp_shark.c = temp_shark.c + dc[temp_shark.direction-1];

                    int prev_shark_dir = temp_shark.direction;
                    int prev_num = temp_map[temp_shark.r][temp_shark.c].num;
                    int prev_dir = temp_map[temp_shark.r][temp_shark.c].direction;

                    temp_map[temp_shark.r][temp_shark.c] = null;
                    temp_info[prev_num][0] = -1;
                    temp_info[prev_num][1] = -1;
                    temp_shark.direction = prev_dir;
                    dfs(temp_map, temp_info, temp_shark, answer + prev_num);
                    temp_info[prev_num][0] = temp_shark.r;
                    temp_info[prev_num][1] = temp_shark.c;
                    temp_map[temp_shark.r][temp_shark.c] = new Mulgogi(prev_num, prev_dir);
                    temp_shark.direction = prev_shark_dir;
                    flag = 1;
                }else{
                    temp_shark.r = temp_shark.r + dr[temp_shark.direction-1];
                    temp_shark.c = temp_shark.c + dc[temp_shark.direction-1];                        
                }
        }


        // 3. 상어의 이동이 불가했다면? 
        if(real_answer < answer){
            real_answer = answer;
        }
    }
}