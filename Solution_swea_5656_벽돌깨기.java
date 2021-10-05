import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 	완탐. 떨어뜨리는 순서에 의미가 있으니 순열. 같은 자리에 계속 떨어뜨릴 수 있으니 중복순열
 	시간 복잡도는 최대 12가지 줄에서 4번까지 가능하니 12*12*12*12 => 거의 10000정도니 완탐(중복순열) 처리 가능!
 	
 	1. 구슬을 구슬을 0~N-1 열까지 시도
 	2. 구슬이 떨어졌을 때 처음 만나는 벽돌 찾기( 위에서부터 탐색)
 	3. 함께 제거될 벽돌들 식별(탐색) - BFS, DFS . BFS가 더 적합
 	4. 부서진 벽돌 정리(벽돌 내리기)
 	5. 다음 구슬 시도
 */
public class Solution_swea_5656_벽돌깨기 {
	private static class Point {
		int r, c, cnt; // 행, 열, 벽돌 숫자

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	static int N, W, H, min;
	static int map[][];
	static int dr[] = {0, 0, 1, -1};
	static int dc[] = {1, -1, 0, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			go(0, map);
			System.out.println("#" + t + " " + min);
			
		}
	}
	// 중복순열로 구슬을 던짐
	private static void go(int cnt, int[][] map) {
		
		if(cnt == N) { // 구슬을 다 던졌을 경우
			// 남아있는 벽돌 수 카운트 최소값 갱신
			int result = getRemain(map);
			min = Math.min(result, min);
			return;
		}
		
		int [][] newMap = new int[H][W];
		for (int c = 0; c < W; c++) { // 0열부터 마지막 열까지 시도
			
			// c열에 구슬이 던져졌을 때 위에서  처음 만나는 벽돌 찾기
			
			int r = 0;
			while(r<H && map[r][c] == 0) r++;
			
			if(r == H) { // 구슬을 던졌지만 맞은 벽돌이 없는 경우(해당 열에 모두 빈칸)
				go(cnt+1, map); // 다음 구슬 던지기
			} else { // 맞은 벽돌이 있는 경우
				
				// 이전 cnt까지 map의 상태를 복사해서 사용
				copy(map, newMap);
				// 맞은 벽돌 및 주변 벽돌 함께 제거 처리(연쇄적 처리)
				boom(newMap, r, c);
				// 제거된 벽돌들 내리기
				down(newMap);
				// 다음 구슬 던지기
				go(cnt+1, newMap);
			}
		} 
	}
	private static int getRemain(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j]>0) count++;
			}
		}
		return count;
	}
	private static void down(int[][] map) {
		
		for (int c = 0; c < W; c++) {
			int r = H - 1; // 제일 아래 행부터 시작
			while(r>0) {
				if(map[r][c] == 0) { // 0이라면( 빈칸이라면) 벽돌 내리기
					int nr = r-1; // 자신의 직전 행부터 탐색
					while(nr>0 && map[nr][c] == 0) nr--;
					
					map[r][c] = map[nr][c]; // 현재 빈칸에는 자신의 위쪽으로 처음 만나는 0이 아닌 벽돌 내리기
					map[nr][c] = 0; // 내린 벽돌 자리는 빈칸으로 바꾸기
				}
				--r;
			}
		}
	}
	
	private static void boom(int[][] map, int r, int c) {
		// BFS로 함께 부숴질 벽돌 처리
		Queue<Point> queue = new LinkedList<Point>();
		if(map[r][c]>1) { // 벽돌의 숫자가 1보다 클 때만 주변 벽돌 연쇄 처리
			queue.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0; // 벽돌 제거하고 0으로 채우기 ( queue 에 map[r][c] 값을 넣었기 때문에 0으로 바꿔도 괜찮음)
		
		Point p = null;
		while(!queue.isEmpty()) {
			p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r;
				int nc = p.c;
				for (int k = 1; k < p.cnt; k++) {
					nr += dr[d];
					nc += dc[d];
					if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc] != 0) {
						if(map[nr][nc]>1) {
							queue.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}
			}
		}
	}
	private static void copy(int[][] map, int[][] mapcopy) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				mapcopy[i][j] = map[i][j];
			}
		}
	}
}
