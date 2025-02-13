import java.util.*;
import java.io.*;

class Main{
    static int R; // 행
    static int C; // 열
    static int K; // 온도
    static int W; // 벽 개수 

    static int[][] my_home;
    static int[][] home_temperature;
    static boolean[][][][] wall_memo;

    static int chocolate;

    public static void main(String[] args) throws IOException{

        // 입출력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        my_home = new int[R+1][C+1];
        home_temperature = new int[R+1][C+1];
        wall_memo = new boolean[R+1][C+1][R+1][C+1];

        for(int r=1 ; r<=R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=1; c<=C; c++){
                my_home[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        W = Integer.parseInt(br.readLine());

        for(int i=0; i<W ; i++){
            st = new StringTokenizer(br.readLine());
            int temp_r = Integer.parseInt(st.nextToken());
            int temp_c = Integer.parseInt(st.nextToken());
            int temp_t = Integer.parseInt(st.nextToken());

            int temp_r2;
            int temp_c2;
            if(temp_t == 0){
                temp_r2 = temp_r - 1;
                temp_c2 = temp_c;
            }else{
                temp_r2 = temp_r;
                temp_c2 = temp_c + 1;
            }

            wall_memo[temp_r][temp_c][temp_r2][temp_c2] = true;
            wall_memo[temp_r2][temp_c2][temp_r][temp_c] = true;
        }


        while(true){
            //1. 집에 있는 모든 온풍기에서 바람이 한 번 나옴
            for(int r=1; r<=R; r++){
                for(int c=1; c<=C; c++){
                    if(my_home[r][c] == 1 || my_home[r][c] == 2 || my_home[r][c] == 3 || my_home[r][c] == 4){
                        int[][] wind_array = wind_spread(r,c,my_home[r][c]);
                        home_temperature = add_wind_spread(home_temperature, wind_array);
                    }
                }
            }

            //2. 온도가 조절됨
            int[][] temp_change = wind_adjust(home_temperature);
            home_temperature = add_wind_spread(home_temperature, temp_change);

            //3. 온도가 1 이상인 가장 바깥쪽 칸의 온도가 1씩 감소
            decrease_temp(home_temperature);
            //4. 초콜릿을 하나 먹는다
            chocolate++;

            //디버깅
            //print_temp();

            //5. 조사하는 모든 칸의 온도가 k 이상이 되었는지 검사
            if(check()){
                break;
            }

            if(chocolate>=101){
                break;
            }
        }

        bw.write(String.valueOf(chocolate));
        bw.flush();
        bw.close();
        br.close();
    }

    // 디버깅용
    public static void print_temp(){
        for(int r=1; r<=R ;r++){
            System.out.println();
            for(int c=1; c<=C; c++){
                System.out.print(home_temperature[r][c] + " ");
            }
        }

        System.out.println("=-======");
    }
    // 조사하는 모든 칸의 온도 k 이상인지 검사
    public static boolean check(){
        for(int r=1; r<=R; r++){
            for(int c=1; c<=C; c++){
                if(my_home[r][c] == 5){
                    if(home_temperature[r][c] < K){
                        return false;
                    }
                }
            }
        }

        return true;
    }
    // 바깥쪽 칸 온도 -1 씩
    public static void decrease_temp(int [][] a){
        for(int r=1; r<=R; r++){
            for(int c=1; c<=C; c++){
                if(r==1 || r==R || c==1 || c==C){
                    if(a[r][c] != 0){
                        a[r][c] -= 1;
                    }
                }
            }
        }
    }

    // 온도 조절 메서드
    public static int[][] wind_adjust(int[][] a){

        int[][] temp_change = new int[R+1][C+1];
        for(int r=1; r<=R; r++){
            for(int c=1; c<=C; c++){
                if(is_home_range(r+1, c) && !wall_memo[r][c][r+1][c]){
                    if(a[r][c] >= a[r+1][c]){
                        int diff = (a[r][c] - a[r+1][c])/4;
                        temp_change[r][c] -= diff;
                        temp_change[r+1][c] += diff;
                    }else{
                        int diff = (a[r+1][c] - a[r][c])/4;
                        temp_change[r][c] += diff;
                        temp_change[r+1][c] -= diff;
                    }
                }

                if(is_home_range(r, c+1) && !wall_memo[r][c][r][c+1]){
                    if(a[r][c] >= a[r][c+1]){
                        int diff = (a[r][c] - a[r][c+1]) / 4;
                        temp_change[r][c] -= diff;
                        temp_change[r][c+1] += diff;
                    }else{
                        int diff = (a[r][c+1] - a[r][c]) / 4;
                        temp_change[r][c] += diff;
                        temp_change[r][c+1] -= diff;            
                    }
                }
            }
        }

        return temp_change;
    }
    // 온도값 더해주는 메서드
    public static int[][] add_wind_spread(int[][] a, int[][] b){
        int[][] c = new int[R+1][C+1];

        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        return c;
    }
    //해당 칸이 범위 안에 있는 칸이긴 한가? 
    public static boolean is_home_range(int r, int c){
        if(r<=0 || r>R || c<=0 || c>C){
            return false;
        }
        return true;
    }

    //온풍기 1개의 바람 불고나서의 값을 
    public static int[][] wind_spread(int r, int c, int d){

        int[][] wind_array_temp = new int[R+1][C+1];

        if(d == 1){
            //오른쪽 방향 온풍기
            wind_array_temp[r][c+1] = 5;
        
            int pok = 0;
            for(int tc=c+1; tc<c+5; tc++){
                for(int tr=r-pok; tr <=r+pok; tr++){
                    //바람 퍼지기
                    if(!is_home_range(tr,tc) || wind_array_temp[tr][tc] == 0) continue;

                    // (tr, tc) -> (tr-1, tc+1)
                    if(is_home_range(tr-1, tc+1)){
                        if(!wall_memo[tr][tc][tr-1][tc] && !wall_memo[tr-1][tc][tr-1][tc+1]){
                            wind_array_temp[tr-1][tc+1] = wind_array_temp[tr][tc] - 1;
                        }
                    }
                    // (tr, tc) -> (tr, tc+1)
                    if(is_home_range(tr, tc+1)){
                        if(!wall_memo[tr][tc][tr][tc+1]){
                            wind_array_temp[tr][tc+1] = wind_array_temp[tr][tc] - 1;
                        }
                    }
                    // (tr, temp+col) -> (temp+row+1, tc+1)
                    if(is_home_range(tr+1, tc+1)){
                        if(!wall_memo[tr+1][tc][tr+1][tc+1] && !wall_memo[tr+1][tc][tr][tc]){
                            wind_array_temp[tr+1][tc+1] = wind_array_temp[tr][tc] - 1;
                        }
                    }
                }
                pok++;
            }
        }else if(d==2){
            //왼쪽 방향 온풍기
            wind_array_temp[r][c-1] = 5;
        
            int pok = 0;
            for(int tc=c-1; tc>c-5; tc--){
                for(int tr=r-pok; tr <=r+pok; tr++){

                    if(!is_home_range(tr,tc) || wind_array_temp[tr][tc] == 0) continue;

                    //[temp_r, temp_c] -> [temp_r-1, temp_c-1]
                    if(is_home_range(tr-1, tc-1)){
                        if(!wall_memo[tr-1][tc][tr-1][tc-1] && !wall_memo[tr][tc][tr-1][tc]){
                            wind_array_temp[tr-1][tc-1] = wind_array_temp[tr][tc] - 1;
                        }
                    }
                    //[temp_r, temp_c] -> [temp_r, temp_c-1]
                    if(is_home_range(tr, tc-1)){
                        if(!wall_memo[tr][tc][tr][tc-1]){
                            wind_array_temp[tr][tc-1]= wind_array_temp[tr][tc] - 1;
                        }
                    }
                    //[temp_r, temp_c] -> [temp_r+1, temp_c-1]
                    if(is_home_range(tr+1, tc-1)){
                        if(!wall_memo[tr+1][tc][tr][tc] && !wall_memo[tr+1][tc][tr+1][tc-1]){
                            wind_array_temp[tr+1][tc-1]= wind_array_temp[tr][tc] - 1;
                        }
                    }
                }
                pok++;
            }

        }else if(d==3){
            //위쪽 방향 온풍기
            wind_array_temp[r-1][c] = 5;

            int pok = 0;
            for(int tr=r-1; tr>r-5; tr--){
                for(int tc=c-pok; tc<=c+pok; tc++){

                    if(!is_home_range(tr,tc) || wind_array_temp[tr][tc] == 0) continue;

                    //[tr, tc] -> [tr-1, tc-1]
                    if(is_home_range(tr-1, tc-1)){
                        if(!wall_memo[tr-1][tc-1][tr][tc-1] && !wall_memo[tr][tc][tr][tc-1]){
                            wind_array_temp[tr-1][tc-1] = wind_array_temp[tr][tc] - 1;
                        }
                    }
                    //[tr, tc] -> [tr-1, tc]
                    if(is_home_range(tr-1, tc)){
                        if(!wall_memo[tr][tc][tr-1][tc]){
                            wind_array_temp[tr-1][tc] = wind_array_temp[tr][tc] - 1;
                        }
                    }
                    //[tr, tc] -> [tr-1, tc+1]
                    if(is_home_range(tr-1, tc+1)){
                        if(!wall_memo[tr][tc][tr][tc+1] && !wall_memo[tr][tc+1][tr-1][tc+1]){
                            wind_array_temp[tr-1][tc+1] = wind_array_temp[tr][tc] - 1;
                        }
                    }
                }
                pok++;
            }
        }else if(d==4){
            //아래쪽 방향 온풍기
            wind_array_temp[r+1][c] = 5;

            int pok = 0;
            for(int tr=r+1; tr<r+5; tr++){
                for(int tc=c-pok; tc<=c+pok; tc++){

                    if(!is_home_range(tr,tc) || wind_array_temp[tr][tc] == 0) continue;

                    //[tr,tc] -> [tr+1, tc-1]
                    if(is_home_range(tr+1, tc-1)){
                        if(!wall_memo[tr][tc-1][tr+1][tc-1] && !wall_memo[tr][tc-1][tr][tc]){
                            wind_array_temp[tr+1][tc-1] = wind_array_temp[tr][tc] - 1;
                        }
                    }
                    //[tr,tc] -> [tr+1, tc]
                    if(is_home_range(tr+1, tc)){
                        if(!wall_memo[tr][tc][tr+1][tc]){
                            wind_array_temp[tr+1][tc] = wind_array_temp[tr][tc] - 1;
                        }
                    }
                    //[tr,tc] -> [tr+1, tc+1]
                    if(is_home_range(tr+1, tc+1)){
                        if(!wall_memo[tr][tc+1][tr+1][tc+1] && !wall_memo[tr][tc+1][tr][tc]){
                            wind_array_temp[tr+1][tc+1] = wind_array_temp[tr][tc] - 1;
                        }
                    }
                }
                pok++;
            }
        }
        /*
        for(int a=1; a<=R; a++){
            System.out.println();
            for(int b=1; b<=C; b++){
                System.out.print(wind_array_temp[a][b] + " ");
            }
        }
        System.out.println("~~~");
        */
        return wind_array_temp;
    }
}