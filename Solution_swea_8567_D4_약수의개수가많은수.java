import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_swea_8567_D4_약수의개수가많은수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int [] arr = new int[100001];
		
		for (int i = 1; i <= 100000; i++) {
			for (int j = 1; i*j <= 100000; j++) {
				arr[i*j]++;					// 약수의 개수 추가
			}
		}
		
		int [] max = new int[100001];
		int cnt = 0;
		int maxidx = 0;
		for (int i = 1; i <= 100000; i++) {
			if(cnt <= arr[i]) {
				cnt = arr[i];
				maxidx = i;
			}
			max[i] = maxidx;
		}
		for (int t = 1; t <= T; t++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println("#" + t + " " + max[num]);
		}
	}
}
