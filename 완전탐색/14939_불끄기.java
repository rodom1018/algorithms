import java.util.*;
import java.io.*;

class Main{

    static char[][] my_map = new char[10][10];
    static int[] dr = {-1,0,1,0,0};
    static int[] dc = {0,-1,0,1,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int answer = Integer.MAX_VALUE;
        //초기화
        for(int a=0; a<10; a++){
            String temp = br.readLine();
            
            for(int b=0; b<10; b++){
                my_map[a][b] = temp.charAt(b);
            }
        }

        //맨 윗줄(10칸)에 대한 완탐
        for(int now_case=0; now_case<(1<<10); now_case++){
            char[][] now_map = my_deep_copy();
            int now_answer = 0;

            //1.첫번째 줄 10개를 경우에 따라누른다/안누른다
            for(int c=0; c<10; c++){
                if((now_case & (1<<c)) >= 1){
                    click(now_map, 0, c);
                    now_answer++;
                }
            }

            //2. 나머지 9줄은 윗칸이 눌려있으면 무조건 꺼야하니까 눌러야함
            for(int r=1; r<10; r++){
                for(int c=0 ; c<10; c++){
                    if(haveToClick(now_map, r,c)){
                        click(now_map, r, c);
                        now_answer++;
                    }
                }
            }

            if(isGoodStatus(now_map) && now_answer < answer){
                answer = now_answer;
            }
        }

        //System.out.println(answer);

        if(answer != Integer.MAX_VALUE){
            bw.write(String.valueOf(answer));
        }else{
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();


    }

    public static void click(char[][] now_map, int r, int c){
        for(int i=0; i<5; i++){
            int now_r = r + dr[i];
            int now_c = c + dc[i];

            if(now_r < 0 || now_r >= 10 || now_c < 0 || now_c >= 10) continue;

            if(now_map[now_r][now_c] == 'O'){
                now_map[now_r][now_c] = '#';
            }else{
                now_map[now_r][now_c] = 'O';
            }
        }        
    }

    public static boolean haveToClick(char[][] now_map, int r, int c){
        if(r-1 >=0){
            if(now_map[r-1][c] == 'O'){
                return true;
            }
        }

        return false;
    }

    public static boolean isGoodStatus(char[][] now_map){
        for(int r=0; r<10; r++){
            for(int c=0; c<10; c++){
                if(now_map[r][c] == 'O'){
                    return false;
                }
            }
        }

        return true;
    }

    public static char[][] my_deep_copy(){

        char[][] temp = new char[10][10];

        for(int a=0; a<10; a++){
            for(int b=0; b<10; b++){
                temp[a][b] = my_map[a][b];
            }
        }

        return temp;
    }
}