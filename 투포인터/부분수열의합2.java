import java.util.*;
import java.io.*;

class Main{

    static int N;
    static int S;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> part_a;
    static List<Integer> part_b;
    static List<Integer> result_a = new ArrayList<>();
    static List<Integer> result_b = new ArrayList<>();
    static long answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int a=0; a<N; a++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        if(N==1){
            if(list.get(0) == S){
                answer++;
            }
        }else{
            part_a = list.subList(0, list.size()/2);
            part_b = list.subList(list.size()/2, list.size());

            dfs_a(part_a, 0, 0, 0);
            dfs_b(part_b, 0, 0, 0);

            Collections.sort(result_a);
            Collections.sort(result_b);

            int a_index = 0;
            int b_index = result_b.size() - 1;
            while(a_index < result_a.size() && b_index >=0){
                int temp_result = result_a.get(a_index) + result_b.get(b_index);

                long temp_count_a = 1;
                long temp_count_b = 1;

                if(temp_result == S){
                    //
                    // !!! 매 우 주 의 !!!
                    // result_a.get(a_index) == result_a.get(a_index + 1) 로 하면 오답이 남 !!!!!
                    // 자바는 -128…127 범위의 Integer 값만 캐시에 두고 재사용하기 때문에, 그 범위를 벗어나는 수에 대해서는 같은 값이라도 서로 다른 객체가 만들어져 == 비교가 실패합니다.
                    // !!! 매 우 주 의 !!!
                    while(a_index < result_a.size() - 1 && result_a.get(a_index).equals(result_a.get(a_index + 1))){
                        a_index++;
                        temp_count_a++;
                    }

                    while(b_index > 0 && result_b.get(b_index).equals(result_b.get(b_index - 1))){
                        b_index--;
                        temp_count_b++;
                    }

                    answer += (temp_count_a * temp_count_b);

                    a_index++;
                    b_index--;

                }else if(temp_result < S){
                    a_index++;
                }else if(temp_result > S){
                    b_index--;
                }
            }

            for(int a=0; a < result_a.size(); a++){
                if(result_a.get(a) == S) answer++;
            }

            for(int b=0; b < result_b.size(); b++){
                if(result_b.get(b) == S) answer++;
            }

        }


        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }


    // a에서 한 번이라도 고른 경우 추출  
    static void dfs_a(List<Integer> temp, int index, int temp_result, int flag){
        if(index == temp.size()){
            if(flag == 1){
                result_a.add(temp_result);
            }
            return;
        }

        dfs_a(temp, index+1, temp_result, flag);
        dfs_a(temp, index+1, temp_result + temp.get(index), 1);
    }

    // b에서 한 번이라도 고른 경우 추출
    static void dfs_b(List<Integer> temp, int index, int temp_result, int flag){
        if(index == temp.size()){
            if(flag == 1){
                result_b.add(temp_result);
            }
            return;
        }

        dfs_b(temp, index+1, temp_result, flag);
        dfs_b(temp, index+1, temp_result + temp.get(index), 1);
    }
}