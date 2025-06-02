import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int M = Integer.parseInt(br.readLine());
            int c = (M+1) / 2;
            int[] arr = new int[M];
            int[] result = new int[c];


            int index = 0;
            for(int a=0; a<(M/10); a++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int b=0; b<10; b++){
                    arr[index++] = Integer.parseInt(st.nextToken());
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int a=0; a<(M%10); a++){
                arr[index++] = Integer.parseInt(st.nextToken());
            }


            int gijun = arr[0];
            result[0] = arr[0];
            PriorityQueue<Integer> small_pq = new PriorityQueue<>();
            PriorityQueue<Integer> large_pq = new PriorityQueue<>();

            for(int m=0; m<c-1; m++){

                if(arr[m*2+1] > gijun){
                    large_pq.add(arr[m*2+1]);
                }else{
                    small_pq.add(-arr[m*2+1]);
                }

                if(arr[m*2+2] > gijun){
                    large_pq.add(arr[m*2+2]);
                }else{
                    small_pq.add(-arr[m*2+2]);
                }

                //System.out.println("Debug: " + large_pq.size() + ", " + small_pq.size());

                if(large_pq.size() > small_pq.size()){
                    small_pq.add(-gijun);
                    gijun = large_pq.poll();
                }else if(large_pq.size() < small_pq.size()){
                    large_pq.add(gijun);
                    gijun = -small_pq.poll();
                }

                //System.out.println("Debug: " + gijun);

                result[m+1] = gijun;
            }

            System.out.println(c);

            int ten = 0;
            for(int a=0; a<(c/10); a++){
                for(int b=0; b<10; b++){
                    System.out.print(result[a*10+b] + " ");
                }
                System.out.println();
                ten++;
            }

            for(int a=0; a<(c%10); a++){
                System.out.print(result[ten*10+a] + " ");
            }
            System.out.println();

        }



        bw.flush();
        bw.close();
        br.close();
    }
}