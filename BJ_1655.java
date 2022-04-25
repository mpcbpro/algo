import java.util.*;
 
public class BJ_1655 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
 
        int n = scan.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int num = scan.nextInt();
            
            if(minHeap.size() == maxHeap.size()) maxHeap.add(num);
            else minHeap.add(num);
            
            if(!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                int temp = minHeap.poll();
                minHeap.add(maxHeap.poll());
                maxHeap.add(temp);
            }
            sb.append(maxHeap.peek() + "\n");        
        }
        System.out.println(sb);
    }
}
 