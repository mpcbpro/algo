import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 월0 화1 수2 목3 금4 토5 일6
// 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
public class Solution_swea_D3_5515_2016년요일맞추기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int month[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int arr[] = {3, 4, 5, 6, 0, 1, 2};
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			
			for (int i = 1; i <= m-1; i++) {
				sum += month[i];
			}
			sum += d;
			
			System.out.println("#" + t + " " + arr[sum%7]);
		}
	}
}
