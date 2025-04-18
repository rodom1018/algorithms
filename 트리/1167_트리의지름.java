import java.util.*;
import java.io.*;

class Main{

    static int V;
    static ArrayList<ArrayList<int[]>> graph;
    static int answer = 0; 

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        V = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for(int a=0; a<=V; a++){
            graph.add(new ArrayList<int[]>());
        }

        for(int a=0; a<V; a++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now_v = Integer.parseInt(st.nextToken());

            while(true){
                int now_dest = Integer.parseInt(st.nextToken());

                if(now_dest == -1) break;

                int now_cost = Integer.parseInt(st.nextToken());

                graph.get(now_v).add(new int[]{now_dest, now_cost});
            }
        }

        int[] temp = bfs(1);
        int[] result = bfs(temp[0]);
        answer = result[1];

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] bfs(int v){

        int result = 0;
        int result_p = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{v,0});
        int[] visited = new int[V+1];
        visited[v] = 1;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int temp_v = temp[0];
            int temp_cost = temp[1];
            visited[temp_v] = 1;

            if(temp_cost > result){
                result = temp_cost;
                result_p = temp_v;
            }

            for(int a=0; a<graph.get(temp_v).size(); a++){
                if(visited[graph.get(temp_v).get(a)[0]] == 0){
                    queue.add(new int[]{graph.get(temp_v).get(a)[0],
                    temp_cost + graph.get(temp_v).get(a)[1]});
                }
            }
        }
        return new int[]{result_p, result};
    }
}