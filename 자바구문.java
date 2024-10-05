// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
import java.io.*;

class HelloWorld {
    public static void main(String[] args) {
        // scanner input
        //Scanner scanner = new Scanner(System.in);
        //int age = Integer.parseInt(scanner.nextLine());
        //System.out.println(age);
        
        
        //1-dim array + sort
        int a[] = {5,4,3,2,1};
        
        for(int i=0; i<a.length; i++){
            System.out.print(a[i] +" ");
        }
        System.out.println();
        
        //2-dim array + sort
        List<int[]> pairs = new ArrayList();
        
        pairs.add(new int[]{5,6});
        pairs.add(new int[]{3,4});
        pairs.add(new int[]{1,2});
        
        pairs.sort( (o1, o2) -> {
           if(o1[0] != o2[0]){
               return Integer.compare(o1[0], o2[0]);
           } 
           return Integer.compare(o1[1], o2[1]);
        });
        
        for (int[] pair : pairs) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
        
        
        // stack
        Stack<Integer> stack = new Stack<>();
        
        stack.add(3);
        stack.add(2);
        stack.add(1);
        
        System.out.println(stack.pop());
        
        
        // queue
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(3);
        queue.add(2);
        queue.add(1);
        
        System.out.println(queue.poll());
        
        // priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        pq.add(3);
        pq.add(2);
        pq.add(1);
        
        System.out.println(pq.poll());
        
    }
}