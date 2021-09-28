import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea_D4_8458_원점으로집합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력
		for (int t = 1; t <= T; t++) { // 테스트 케이스 수 만큼 반복
			int N = Integer.parseInt(br.readLine()); // N : 점의 개수
			int [] len = new int[N]; // 원점으로부터 각 점의 거리를 넣기 위한 배열 생성
			int cnt = 0;  // cnt : 이동 횟수
			int max = 0; // max : 원점과 가장 멀리 위치한 점의 원점과의 거리
			for (int i = 0; i < N; i++) { // 점의 개수만큼 반복
				st = new StringTokenizer(br.readLine()); 
				len[i] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken())); // 원점과 점의 거리 계산하여 len배열에 저장 
			}
			
			max = len[0]; // max를 첫번째 점으로 초기화
			for (int i = 1; i < N; i++) { // 2번째 점부터 1번째 점과 비교
				max = Math.max(max, len[i]); // 거리를 비교하여 더 먼 점을 max로 지정
				if(len[i]%2 != len[0]%2) cnt = -1; // 1번째 점과 홀수 또는 짝수가 같지 않다면 cnt = -1
			}
			
			while(cnt>=0) { // cnt 를 -1로 설정한 것은 제외하고 반복
				if(max == 0 || (max < 0 && -max % 2 ==0)) break; // max가 0이 되거나 max가 음수일 때 2로 나눈 나머지가 0이면 break
				max -= ++cnt; // cnt 를 증가시켜서 맥스에서 빼기
			}
			
			System.out.println("#" + t + " " + cnt); // 결과 출력
			
		}
	}
}
