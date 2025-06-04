import java.util.*;
import java.io.*;

class Shark{
    public int live;
    public int r;
    public int c;
    public int s;
    public int d;
    public int z;
}
class Main{

    static int R;
    static int C;
    static int M;


    public static void main(String[] args) throws IOException{

        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Shark> sharkList = new ArrayList<>();
        int[][] temp_shark = new int[R+1][C+1];
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());

            Shark newShark = new Shark();
            newShark.live = 1;
            newShark.r = Integer.parseInt(st.nextToken());
            newShark.c = Integer.parseInt(st.nextToken());
            newShark.s = Integer.parseInt(st.nextToken());
            newShark.d = Integer.parseInt(st.nextToken());
            newShark.z = Integer.parseInt(st.nextToken());

            temp_shark[newShark.r][newShark.c] = m+1;
            sharkList.add(newShark);
        }

        //낚시왕 등장~!
        for(int c=1; c<=C; c++){
            
            //1.낚시왕은 알아서 for-loop 로 이동
            //2.낚시왕이 상어 잡기
            int min_r = R+2;
            int min_index = -1;

            for(int s=0; s<sharkList.size(); s++){
                Shark nowShark = sharkList.get(s);

                if(nowShark.live ==0) continue;

                if(nowShark.c == c && nowShark.r <min_r){
                    min_r = nowShark.r;
                    min_index = s;
                }
            }

            if(min_index != -1){
                answer += sharkList.get(min_index).z;
                sharkList.get(min_index).live = 0;
            }

            //System.out.println(answer);


            //상어 번호 저장 용 (index 값 보다 +1 해서 저장)
            temp_shark = new int[R+1][C+1];

            //3. 상어의 이동
            for(int s=0; s<sharkList.size(); s++){

                Shark nowShark = sharkList.get(s);
                
                if(nowShark.live == 0) continue;
                
                if(nowShark.d == 1){
                    nowShark.r -= nowShark.s;

                    if(nowShark.r <= 0){
                        int temp_r = -nowShark.r;

                        if((temp_r /(R-1))%2 ==0){
                            nowShark.d = 2;
                            nowShark.r = (temp_r%(R-1)) + 2;
                        }else{
                            nowShark.d = 1;
                            nowShark.r = R-1-(temp_r%(R-1));
                        }
                    }

                    if(temp_shark[nowShark.r][nowShark.c] == 0){
                        temp_shark[nowShark.r][nowShark.c] = s+1;
                    }else{
                        if(sharkList.get(temp_shark[nowShark.r][nowShark.c]-1).z > nowShark.z){
                            nowShark.live = 0;
                        }else{
                            sharkList.get(temp_shark[nowShark.r][nowShark.c]-1).live = 0;
                            temp_shark[nowShark.r][nowShark.c] = s+1;
                        }
                    }
                }else if(nowShark.d == 2){
                    
                    nowShark.r += nowShark.s;

                    if(nowShark.r > R){
                        int temp_r = nowShark.r - 2;

                        if((temp_r /(R-1))%2 ==0){
                            nowShark.d = 2;
                            nowShark.r = 2+(temp_r%(R-1));
                        }else{
                            nowShark.d = 1;
                            nowShark.r = R-1-(temp_r%(R-1));
                        }
                    }

                    if(temp_shark[nowShark.r][nowShark.c] == 0){
                        temp_shark[nowShark.r][nowShark.c] = s+1;
                    }else{
                        if(sharkList.get(temp_shark[nowShark.r][nowShark.c]-1).z > nowShark.z){
                            nowShark.live = 0;
                        }else{
                            sharkList.get(temp_shark[nowShark.r][nowShark.c]-1).live = 0;
                            temp_shark[nowShark.r][nowShark.c] = s+1;
                        }
                    }
                    
                }else if(nowShark.d == 3){
                    
                    nowShark.c += nowShark.s;

                    if(nowShark.c > C){
                        int temp_c = nowShark.c - 2;

                        if((temp_c /(C-1))%2 ==0){
                            nowShark.d = 3;
                            nowShark.c = 2+(temp_c%(C-1));
                        }else{
                            nowShark.d = 4;
                            nowShark.c = C-1-(temp_c%(C-1));
                        }
                    }

                    if(temp_shark[nowShark.r][nowShark.c] == 0){
                        temp_shark[nowShark.r][nowShark.c] = s+1;
                    }else{
                        if(sharkList.get(temp_shark[nowShark.r][nowShark.c]-1).z > nowShark.z){
                            nowShark.live = 0;
                        }else{
                            sharkList.get(temp_shark[nowShark.r][nowShark.c]-1).live = 0;
                            temp_shark[nowShark.r][nowShark.c] = s+1;
                        }
                    }

                }else{
                    nowShark.c -= nowShark.s;

                    if(nowShark.c <= 0){
                        int temp_c = -nowShark.c;

                        if((temp_c /(C-1))%2 ==0){
                            nowShark.d = 3;
                            nowShark.c = (temp_c%(C-1)) + 2;
                        }else{
                            nowShark.d = 4;
                            nowShark.c = C-1-(temp_c%(C-1));
                        }
                    }

                    if(temp_shark[nowShark.r][nowShark.c] == 0){
                        temp_shark[nowShark.r][nowShark.c] = s+1;
                    }else{
                        if(sharkList.get(temp_shark[nowShark.r][nowShark.c]-1).z > nowShark.z){
                            nowShark.live = 0;
                        }else{
                            sharkList.get(temp_shark[nowShark.r][nowShark.c]-1).live = 0;
                            temp_shark[nowShark.r][nowShark.c] = s+1;
                        }
                    }
                }
            }
            /*
            System.out.println("------------------");
            for(int a=1; a<=R; a++){
                for(int b=1; b<=C; b++){
                    System.out.print(temp_shark[a][b] + " ");
                }
                System.out.println();
            }
            */
        }

        System.out.println(answer);
    }
}