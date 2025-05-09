// KEY POINT !!!! >> new int[N] 도 O(N) 의 시간 복잡도를 가진다

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] cost;
    static Set<Integer> must = new HashSet<>();
    static int answer = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        
        for(int a=0; a<=N; a++){
            graph.add(new ArrayList<>());
        }

        cost = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int add_flag = 0;
        for(int a=1; a<=N; a++){
            cost[a] = Integer.parseInt(st.nextToken());
        }

        for(int a=0; a<N-1; a++){
            st = new StringTokenizer(br.readLine());

            int tempA = Integer.parseInt(st.nextToken());
            int tempB = Integer.parseInt(st.nextToken());

            graph.get(tempA).add(tempB);
            graph.get(tempB).add(tempA);
        }

        for(int a=1; a<=N; a++){
            if(cost[a] != 0){
                dfs_find(a,0);
                must.add(a);
            }
        }

        answer = (must.size() > 0 ? (must.size() - 1) * 2 : 0);
        bw.write(answer +"\n");

        int t = Integer.parseInt(br.readLine());

        for(int a=0; a<t; a++){
            st = new StringTokenizer(br.readLine());
            int temp_a = Integer.parseInt(st.nextToken());
            int temp_b = Integer.parseInt(st.nextToken());
            int temp_c = Integer.parseInt(st.nextToken());

            cost[temp_a] = temp_c;
            cost[temp_b] = -temp_c;

            if(!must.contains(temp_a)){
                dfs_find(temp_a, 0);
                answer = (must.size() > 0 ? (must.size() - 1) * 2 : 0);
            }

            if(!must.contains(temp_b)){
                dfs_find(temp_b, 0);
                answer = (must.size() > 0 ? (must.size() - 1) * 2 : 0);
            }
            
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }


    public static int dfs_find(int point, int parent){
        
        if(must.contains(point)){
            return 1;
        }
        
        for(int a=0; a<graph.get(point).size(); a++){
            if(graph.get(point).get(a) != parent){
                int temp_result = dfs_find(graph.get(point).get(a), point);
                if(temp_result != 0){

                    if(!must.contains(point)) must.add(point);
                    return temp_result;
                }
            }
        }

        return 0;
    }
}
/*
이 문제는 선물 나눠주기 문제의 쉬운 버전입니다. 두 버전의 유일한 차이점은 주어지는 질의의 정점에 대해 제한이 있는지 여부입니다.



산타는 도시 내에 있는 마을에 선물을 나눠주려고 합니다. 이 도시는 n개의 마을로 이루어져 있고, 마을은 트리 모양을 이루고 있습니다. 트리를 이루고 있기에 이 도시는 n개의 마을(노드)을 n−1개의 간선이 연결하고 있는 모양이며 이로부터 모든 마을이 연결됩니다. Figure 1은 n이 7인 경우의 예입니다.







처음 각 i번째 마을에는 정수 ai​값이 주어져있습니다. ai​>0인 경우에는 해당 마을에 선물이 ai​개 놓여 있음을, ai​<0인 경우에는 해당 마을에 선물이 −ai​개 만큼 배달이 되어야만 함을 의미합니다. ∑ai​는 항상 0이며, 산타는 ai​>0인 마을에 놓인 선물들을 잘 챙겨서 ai​<0인 마을에 배달해야 합니다. Figure 2는 Figure 1에서 a2​=1,a3​=−2,a4​=1인 예입니다.







산타는 처음에 시작점에 해당하는 마을 s를 잘 골라, 이 마을에서 출발하여 모든 선물 배달을 완료한 뒤 다시 시작 마을 s로 되돌아오려고 합니다. 이때 선으로 연결된 두 마을을 지나는 데에는 1초가 소요되며, 전략을 잘 세워 선물 배달을 완료하고 다시 시작 위치로 돌아오는 데 걸리는 시간을 최소로 만들고자 합니다.



예로 Figure 2에서 만약 산타가 1번 마을에서 출발하여 1 -> 2 -> 3 -> 4 -> 3 -> 2 -> 1 순으로 이동했다면 모든 배달을 완료하고 다시 처음 위치로 돌아오게 되지만 이때 걸리는 시간은 총 6초가 됩니다. 하지만 만약 산타가 4번 마을에서 출발하여 4 -> 3 -> 2 -> 3 -> 4 순으로 이동했다면 모든 배달을 완료하고 다시 처음 위치로 돌아오는 시간이 총 4초가 되어 최소가 됩니다.



하지만 처음 주어진 ai​들의 정보가 완벽한 정보는 아닐 수 있기에 산타는 여러 상황에 대해 최소 이동 시간을 추가로 구해보려고 합니다. 이는 q개의 질의로 표현되며, 산타는 처음 주어진 ai​에 대한 답을 구한 뒤 q개의 질의를 순차적으로 실행한 이후의 결과를 매 질의마다 구해주려고 합니다. 즉, q+1번 답을 구해보려고 합니다.



질의는 (xi​,yi​,zi​)형태로 주어지며, 이는 axi​​값에 zi​를 더하고 ayi​​값에 zi​를 빼야함을 의미합니다.



만약 Figure 2에서 (5,6,4)라는 질의가 주어졌다면, 도시는 Figure 3과 같은 모습으로 바뀌게 됩니다.







이 경우에는 산타가 5번 마을에서 출발하여 5 -> 4 -> 3 -> 2 -> 3 -> 6 -> 3 -> 4 -> 5순으로 이동하는게 8초로 최소가 됩니다.

이후 Figure 3에서 (1,7,2)라는 질의가 주어졌다면, 도시는 Figure 4와 같은 모습으로 바뀌게 됩니다.







이 경우에는 산타가 1번 마을에서 출발하여 1 -> 2 -> 3 -> 4 -> 5 -> 4 -> 3 -> 6 -> 7 -> 6 -> 3 -> 2 -> 1순으로 이동하는게 12초로 최소가 됩니다.

산타가 총 q+1개의 상황에 대해 선물 배달을 완료하는데 걸리는 최소 시간을 구하는 프로그램을 작성해보세요.



본 문제의 저작권은 (주)브랜치앤바운드에 있으며, 저작자의 동의 없이 무단 전재/복제/배포를 금지합니다.

제약조건
[조건 1] 4 ≤ n ≤ 100,000

[조건 2] 1 ≤ q ≤ 100,000

[조건 3] −109 ≤ ai​ ≤ 109

[조건 4] 1 ≤ v1​,v2​ ≤ n, v1​=v2​

[조건 5] 1 ≤ xi​,yi​ ≤ n, xi​=yi​

[조건 6] 1 ≤ zi​ ≤ 109



(Easy 버전에만 해당하는 조건) 단, 주어진 모든 질의에 대해 질의가 주어진 그 순간에는 항상 axi​​=0,ayi​​=0을 만족함을 가정해도 좋습니다.

입력형식
첫 번째 줄에는 마을의 수 n이 주어집니다.

두 번째 줄에는 ai​에 대한 정보 n개가 공백을 사이에 두고 주어집니다. a1​부터 순서대로 an​까지 주어지며, 모든 ai​가 0으로 주어지지는 않습니다.

세 번째 줄부터는 n−1개의 줄에 걸쳐 선의 정보 (v1​,v2​)가 공백을 사이에 두고 주어집니다. 이는 v1​번 마을과 v2​번 마을이 선으로 직접 연결되어 있음을 뜻합니다.

n+2 번째 줄에는 질의의 수 q가 주어집니다.

n+3 번째 줄부터는 q개의 줄에 걸쳐 질의에 해당하는 정보 (xi​,yi​,zi​)가 공백을 사이에 두고 주어집니다. 이는 axi​​값에 zi​를 더하고 ayi​​값에 zi​를 빼야함을 의미합니다.

출력형식
q+1개의 줄에 걸쳐 각 상황에 대해 산타가 선물 배달을 완료하는데 걸리는 최소 시간을 한 줄에 하나씩 출력합니다. 초기 상태부터 시작하여 각 질의가 순차적으로 실행된 직후의 상황에서의 답을 출력합니다. 만약 놓여 있는 선물이 전혀 없는 경우라면 0을 출력합니다.

입력예제1

7
0 1 -2 1 0 0 0
1 2
2 3
3 4
4 5
3 6
6 7
2
5 6 4
1 7 2

출력예제1

4
8
12

입력예제2

6
1 0 0 0 0 -1
1 2
2 3
3 4
4 5
5 6
2
2 4 1
3 5 2

출력예제2

10
10
10
*/