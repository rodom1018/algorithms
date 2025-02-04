import java.util.*;
import java.io.*;

public class Main{

    static int N;
    static int M;
    static int K;

    static long[] tree;
    static long[] array;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        tree = new long[N*4];
        array = new long[N];

        for(int i=0; i<N; i++){
            //주어진 N개의 수를 입력 받음 
            array[i] = Long.parseLong(br.readLine());
        }

        //초기 배열을 읽어서 부분 합 배열을 만든다
        tree_init(1,0,N-1);
        //tree_print(N);

        for(int i=0; i<M+K; i++){
            //부분합 구하기 또는 숫자 바꾸기
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                // array 의 b 번째 수를 c로 바꾼다
                b = b - 1; //array index가 0부터 시작, 문제 지문의 b 인덱스는 1부터 시작이라 통일을 위해서  -1 처리
                long diff = c - array[b];
                array[b] = c;
                tree_update(1, 0, N-1, b, diff);
                //tree_print(N);

            }else{
                // array 의 b 번째 수부터 c 번째 수까지의 합을 구하기
                
                //array index가 0부터 시작, 문제 지문의 b,c인덱스는 1부터 시작이라 통일을 위해서 -1 처리
                b = b - 1;
                c = c - 1;

                long now_sum = tree_sum(1, 0, N-1, b, (int) c);
                bw.write(String.valueOf(now_sum)+ "\n");
            }
        }
        //int tree[]

        bw.flush();
        bw.close();
        br.close();
    }

    public static long tree_init(int idx, int start, int end){
        if(start == end){
            // 예 : 배열 2번째 ~2번째 구간 합 구할 때는 array에서 바로 가져오면 됨 
            tree[idx] = array[start];
            return tree[idx];
        }else{
            // 예 : 배열 0 ~4 번째 구간 합 구하기 -> [0-2] 번째 구간 합 구하기 + [3-4] 번째 구간 합 구하기로 재귀 함수 처리
            tree[idx] = tree_init(idx*2, start, (start+end) / 2) + tree_init(idx*2+1, (start+end) / 2 + 1, end);
            return tree[idx];
        }
    }

    public static void tree_update(int idx, int start, int end, int change_value_index, long change_value){
        //change_value_index에 있는 연관된 tree 원소를 change_value 만큼 변화 시킨다
        //change_value_index에 연관된 tree 원소인가?
        if(start<=change_value_index && end>=change_value_index){
            tree[idx] += change_value;

            if(start != end){
                tree_update(idx*2, start, (start+end)/2, change_value_index, change_value);
                tree_update(idx*2+1, (start+end)/2 + 1, end, change_value_index, change_value);
            }
        }
    }

    public static long tree_sum(int idx, int start, int end, int want_start, int want_end){
        // tree 의 [idx] 번째 숫자는, array의 [start ~ end] 의 합을 말함
        // 관심사는 [want_start ~ want_end] 의 부분합

        // 관심사 밖 구간은 0으로 리턴. 
        if(start < want_start && end < want_start) return 0;
        if(start > want_end && end > want_end) return 0;

        // tree 의 idx 번째 숫자 - (start ~ end) 의 구간이 원하는 부분 합의 전체 이거나 부분 집합임. 따라서 구하고자 하는 부분 합에 넣어야 함
        if(start >= want_start && end <= want_end){
            return tree[idx];
        }else{
            // tree 의 idx 번째 (start~end) 구간이 원하는 부분 합의 범위 바깥임. 따라서 더 작게 쪼개서 부분합을 구해야 함
            return tree_sum(idx*2, start, (start+end)/2, want_start, want_end) + tree_sum(idx*2+1, (start+end)/2 + 1, end, want_start, want_end);
        }
    }

    // 트리 디버그용 프린트 함수
    public static void tree_print(int N){
        for(int i=0; i<4*N; i++){
            System.out.println(tree[i] + " ");
        }
    }
}