import java.util.*;
import java.io.*;


public class Main{

    static int answer = 0;
    static int[][] robot_map;
    static int robot_x;
    static int robot_y;
    static int robot_d;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        robot_map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        robot_x = Integer.parseInt(st.nextToken());
        robot_y = Integer.parseInt(st.nextToken());
        robot_d = Integer.parseInt(st.nextToken());  

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){
                robot_map[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        while(true){
            //System.out.println(robot_x + " " + robot_y);
            if(!isCurrentClean(robot_x, robot_y)){
                //1.현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다. ( 청소된 칸을 -1 로 하였음)
                answer += 1;
                robot_map[robot_x][robot_y] = -1;
            }

            if(!isNearNotClean(robot_x, robot_y)){
                //2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
                int robot_back_d = robot_d+2;
                if(robot_back_d >=4){
                    robot_back_d -= 4;
                }

                if(robot_map[robot_x + dx[robot_back_d]][robot_y + dy[robot_back_d]] != 1){
                    // 2-1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                    robot_x = robot_x + dx[robot_back_d];
                    robot_y = robot_y + dy[robot_back_d];
                }else{
                    // 2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                    break;
                }
            }else{
                //3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우

                //3-1. 반시계 방향으로 90도 회전한다.
                robot_d -= 1;
                if(robot_d < 0){
                    robot_d +=4;
                }

                //3-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진 
                if(robot_map[robot_x + dx[robot_d]][robot_y + dy[robot_d]] == 0){
                    robot_x = robot_x + dx[robot_d];
                    robot_y = robot_y + dy[robot_d];
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();


    }

    static boolean isNearNotClean(int r, int c){
        for(int i=0; i<4; i++){
            if(robot_map[r+dx[i]][c+dy[i]] == 0){
                return true;
            }
        }
        return false;
    }

    static boolean isCurrentClean(int r, int c){
        if(robot_map[r][c] == 0){
            return false;
        }
        return true;
    }

    static int changeDirection(int d){
        d--;
        if(d<0){
            d=3;
        }

        return d;
    }
}

