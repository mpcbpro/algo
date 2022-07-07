import java.util.*;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int answer = 0;
        int index = 0;
        for(int i=0; i<k; i++){
            if(i == dates[index] && index < dates.length){
                pq.add(supplies[index]);
                index++;
            }   
            if(stock == 0){
                stock += pq.poll();
                answer++;
            }
            stock--; 
        }
        return answer;
    }
}