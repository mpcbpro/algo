import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BJ_2533 {
	public static LinkedList<Integer>[] adjList;
	public static boolean[] visited;
	public static int[][] dp;
	public static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adjList = new LinkedList[N+1];
		visited = new boolean[N+1];
		dp = new int[N+1][2];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		for(int i = 0; i < N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			adjList[a].add(b);
			adjList[b].add(a);
		}

		dp(1, -1);  

		System.out.println(Math.min(dp[1][0], dp[1][1]));

	}

	public static void dfs(int cur) {

		dp[cur][0] = 0; 

		dp[cur][1] = 1; 
		visited[cur] = true;
		
		LinkedList<Integer> list = adjList[cur];
		
		for(int i = 0; i < list.size(); i++) {
			if(!visited[list.get(i)]) { 
				dfs(list.get(i)); 
				dp[cur][0] += dp[list.get(i)][1];
				dp[cur][1] += Math.min(dp[list.get(i)][0], dp[list.get(i)][1]); 
			}
		}
	}

	public static void dp(int cur, int parent) {
		dp[cur][0] = 0; 
		dp[cur][1] = 1;
		
		for(int next : adjList[cur]) {
			if(next != parent) { 
				dp(next, cur); 
				dp[cur][0] += dp[next][1];
				dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
			}
		}
	}

}