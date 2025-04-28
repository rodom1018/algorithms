import java.util.*;
import java.io.*;

class Point{
    int r;
    int c;
    
    Point(int r, int c){
        this.r = r;
        this.c = c;
    }
    
    @Override
    public boolean equals(Object o) {
        Point p = (Point) o;
        return this.r == p.r && this.c == p.c;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }
}

class Solution {
    
    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};
    
    static int[] checked;
    
    static HashMap<Point, HashSet<Point>> graph = new HashMap<>();
    
    static int answer = 0;
    
    public int solution(int[] arrows) {
        
        int now_r = 0;
        int now_c = 0;
        graph.put(new Point(0, 0), new HashSet<>());
        Point prevPoint = new Point(0,0);
        
        for(int a=0; a<arrows.length; a++){
            for(int t=0; t<2 ;t++){
                now_r = now_r + dr[arrows[a]];
                now_c = now_c + dc[arrows[a]];
                Point nowPoint = new Point(now_r, now_c);

                //arrows로 이동 후의 좌표가 리스트에 있는 좌표인가?
                
                if(graph.get(nowPoint) != null){
                    //왔다갔다가 아니라 진짜 사이클
                    if(!graph.get(nowPoint).contains(prevPoint)){
                        graph.get(nowPoint).add(prevPoint);
                        answer++;
                    }
                }else{
                    graph.put(nowPoint, new HashSet<>());
                    graph.get(nowPoint).add(prevPoint);        
                }
                
                graph.get(prevPoint).add(nowPoint);
                prevPoint = nowPoint;
            }
        }
        
        return answer;
    }
}

