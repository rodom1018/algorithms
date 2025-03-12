import java.util.*;
import java.io.*;

class Main{

    static int answer = 0;
    static int N;
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[][] now_map = new int[N][N];

        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                now_map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(now_map, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int[][] now_map, int time){
        if(time ==5){
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(answer < now_map[r][c]){
                        answer = now_map[r][c];
                    }
                }
            }
            return;
        }
        //상
        int[][] new_map = up(clone_map(now_map)); // (주의!) 깊은 참조와 얕은 참조를 주의하자
        dfs(new_map, time+1);
        //하
        new_map = down(clone_map(now_map));
        dfs(new_map, time+1);
        //좌
        new_map = left(clone_map(now_map));
        dfs(new_map, time+1);
        //우
        new_map = right(clone_map(now_map));
        dfs(new_map, time+1);
    }

    public static int[][] clone_map(int[][] now_map){
        int[][] clone_map = new int[N][N];

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                clone_map[r][c] = now_map[r][c];
            }
        }

        return clone_map;
    }

    public static int[][] up(int[][] now_map){
        move(now_map);
        return now_map;
    }

    public static int[][] left(int[][] now_map){
        int[][] new_map;
        
        new_map = rotate_clock(now_map);
        move(new_map);
        new_map = rotate_clock(new_map);
        new_map = rotate_clock(new_map);
        new_map = rotate_clock(new_map);

        return new_map;
    }

    public static int[][] down(int[][] now_map){
        int[][] new_map;

        new_map = rotate_clock(now_map);
        new_map = rotate_clock(new_map);      
        move(new_map);
        new_map = rotate_clock(new_map);
        new_map = rotate_clock(new_map);

        return new_map;
    }

    public static int[][] right(int[][] now_map){
        int[][] new_map;

        new_map = rotate_clock(now_map);
        new_map = rotate_clock(new_map);
        new_map = rotate_clock(new_map);
        move(new_map);
        new_map = rotate_clock(new_map);

        return new_map;        
    }

    public static int[][] rotate_clock(int[][] now_map){
        int[][] new_map = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                new_map[j][N-1-i] = now_map[i][j];
            }
        }
        return new_map;
    }

    public static void block_move(int[][] now_map){
        for(int c=0; c<N; c++){
            int index = 0;
            for(int r=0; r<N; r++){
                if(now_map[r][c] != 0){
                    now_map[index][c] = now_map[r][c];

                    if(r != index){
                        now_map[r][c] = 0;
                    }

                    index++;
                }
            }
        }
    }

    public static void block_add(int[][] now_map, int r1, int c1, int r2, int c2){
        now_map[r1][c1] *= 2;
        now_map[r2][c2] = 0;
    }

    public static void move(int[][] now_map){
        
        //윗 방향으로 이동
        block_move(now_map);

        for(int r=0; r<N-1; r++){
            for(int c=0; c<N; c++){
                if(now_map[r][c] == now_map[r+1][c]){
                    block_add(now_map, r, c, r+1, c);
                }
            }
        }

        block_move(now_map);

    }
}