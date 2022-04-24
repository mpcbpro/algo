import java.util.*;

public class BJ_1707 {
	static int K, V, E;
	static String answer;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] set;
	
	public static void main(String [] args) {
		int a, b;
		
		Scanner scan= new Scanner(System.in);
		
		K= scan.nextInt();
		
		while(K-->0) {
			answer= "YES";
			V= scan.nextInt();
			E= scan.nextInt();
			
			graph= new ArrayList<>();
			
			for(int i=0; i<V; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0; i<E; i++) {
				a= scan.nextInt()-1;
				b= scan.nextInt()-1;
				
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			set= new int[V];
			for(int i=0; i<V; i++) {
				if(set[i]==0) {
					if(!bfs(i)) break;
				}
			}
			System.out.println(answer);
		}//while
		
	}//main
	
	
	public static boolean bfs(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(n);
		set[n]= 1;
		
		while(!queue.isEmpty()) {
			n= queue.poll();
			for(Integer i: graph.get(n)) {
				if(set[n]==set[i]) {
					answer="NO";
					return false;
				}
				if(set[i]==0) {
					set[i]=set[n]*-1;
					queue.add(i);
				}
			}
		}
		return true;
	}	
}