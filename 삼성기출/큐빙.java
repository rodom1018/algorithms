import java.util.*;
import java.io.*;

class Main{

    static char[][][] cube = new char[6][3][3];

    public static void main(String[] args) throws IOException{

        //실험
        /*
        forDebug();
        cube = turnBack(cube);
        forDebug();
        cube = turnNext(cube);
        forDebug();
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int n=0; n<N; n++){
            init();
            int M = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                String temp = st.nextToken();

                if(temp.charAt(0) =='U'){
                    doligi(temp.charAt(1));
                }else if(temp.charAt(0) == 'D'){
                    turnBack();
                    turnBack();

                    doligi(temp.charAt(1));

                    turnBack();
                    turnBack();                    
                }else if(temp.charAt(0) == 'F'){
                    turnBack();

                    doligi(temp.charAt(1));
                
                    turnBack();
                    turnBack();
                    turnBack();
                }else if(temp.charAt(0) == 'B'){
                    turnBack();
                    turnBack();
                    turnBack();

                    doligi(temp.charAt(1));

                    turnBack();
                }else if(temp.charAt(0) == 'L'){
                    turnNext();
                    turnNext();
                    turnNext();
                    turnBack();

                    doligi(temp.charAt(1));

                    turnBack();
                    turnBack();
                    turnBack();
                    turnNext();
                }else if(temp.charAt(0) == 'R'){
                    turnNext();
                    turnBack();

                    doligi(temp.charAt(1));

                    turnBack();
                    turnBack();
                    turnBack();
                    turnNext();
                    turnNext();
                    turnNext();

                }
            }

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    bw.write(cube[0][i][j]);
                }
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void forDebug(){
        for(int a=0; a<6;a++){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    System.out.print(cube[a][i][j]);
                }
                System.out.println();
            }
            System.out.println("----------");
        }
        System.out.println("===========");
    }

    public static void init(){
        char[] colors = {'w', 'r', 'y', 'o', 'g', 'b'};

        for(int a=0; a<6; a++){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    cube[a][i][j] = colors[a];
                }
            }
        }
    }

    //시계방향 90도 돌림
    public static char[][] rotate90(char[][] rec){
        char[][] temp_rec = new char[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                temp_rec[i][j] = rec[2-j][i];
            }
        }
        return temp_rec;
    }

    public static char[][] rotate90reverse(char[][] rec){
        char[][] temp_rec = new char[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                temp_rec[i][j] = rec[j][2-i];
            }
        }
        return temp_rec;
    }



    public static void turnBack(){
        char[][] temp = new char[3][3];
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                temp[i][j] = cube[0][i][j];
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                cube[0][i][j] = cube[1][i][j];
                cube[1][i][j] = cube[2][i][j];
                cube[2][i][j] = cube[3][i][j];
                cube[3][i][j] = temp[i][j];
            }
        }
        cube[4] = rotate90reverse(cube[4]);
        cube[5] = rotate90(cube[5]);
    }

    public static void turnNext(){
        char[][] temp1 = new char[3][3]; 
        char[][] temp4 = new char[3][3];
        char[][] temp3 = new char[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                temp1[i][j] = cube[1][i][j];
                temp4[i][j] = cube[4][i][j];
                temp3[i][j] = cube[3][i][j];
            }
        }

        cube[1][0][0] = cube[5][2][0];
        cube[1][0][1] = cube[5][1][0];
        cube[1][0][2] = cube[5][0][0];
        cube[1][1][0] = cube[5][2][1];
        cube[1][1][1] = cube[5][1][1];
        cube[1][1][2] = cube[5][0][1];
        cube[1][2][0] = cube[5][2][2];
        cube[1][2][1] = cube[5][1][2];
        cube[1][2][2] = cube[5][0][2];


        cube[4][0][0] = temp1[2][0];
        cube[4][0][1] = temp1[1][0];
        cube[4][0][2] = temp1[0][0];
        cube[4][1][0] = temp1[2][1];
        cube[4][1][1] = temp1[1][1];
        cube[4][1][2] = temp1[0][1];
        cube[4][2][0] = temp1[2][2];
        cube[4][2][1] = temp1[1][2];
        cube[4][2][2] = temp1[0][2];


        cube[3][0][0] = temp4[2][0]; 
        cube[3][0][1] = temp4[1][0];
        cube[3][0][2] = temp4[0][0];
        cube[3][1][0] = temp4[2][1];
        cube[3][1][1] = temp4[1][1];
        cube[3][1][2] = temp4[0][1];
        cube[3][2][0] = temp4[2][2];
        cube[3][2][1] = temp4[1][2];
        cube[3][2][2] = temp4[0][2];


        cube[5][0][0] = temp3[2][0]; 
        cube[5][0][1] = temp3[1][0];
        cube[5][0][2] = temp3[0][0];
        cube[5][1][0] = temp3[2][1];
        cube[5][1][1] = temp3[1][1];
        cube[5][1][2] = temp3[0][1];
        cube[5][2][0] = temp3[2][2];
        cube[5][2][1] = temp3[1][2];
        cube[5][2][2] = temp3[0][2];      
        
        cube[0] = rotate90(cube[0]);
        cube[2] = rotate90reverse(cube[2]);
    }

    public static void doligi(char c){
        if(c=='+'){
            //시계
            doligiClock();
        }else{
            //반시계
            doligiClock();
            doligiClock();
            doligiClock();
        }
    }

    public static void doligiClock(){

        cube[0] = rotate90(cube[0]);

        char[][] temp = new char[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                temp[i][j] = cube[4][i][j];
            }
        }

        cube[4][0][2] = cube[1][0][0];
        cube[4][1][2] = cube[1][0][1];
        cube[4][2][2] = cube[1][0][2];

        cube[1][0][0] = cube[5][2][0];
        cube[1][0][1] = cube[5][1][0];
        cube[1][0][2] = cube[5][0][0];

        cube[5][2][0] = cube[3][2][2];
        cube[5][1][0] = cube[3][2][1];
        cube[5][0][0] = cube[3][2][0];

        cube[3][2][2] = temp[0][2];
        cube[3][2][1] = temp[1][2];
        cube[3][2][0] = temp[2][2];
    }
}