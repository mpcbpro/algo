package com.ssafy.swea;
// N-S=> 교착. NSS NNS 모두 교착 1개 취급
import java.util.Scanner;

public class Solution_swea_D3_1220_Magnetic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
	
			int N = sc.nextInt();
			int [][] arr = new int[N][N]; 
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int ans = 0;
			
			for(int i = 0; i< N ; i++) {
				int cnt = 0; 
				for (int j = 0; j < N; j++) {
					if(arr[j][i]==2 && cnt==1) {
						ans++;
						cnt=0;
					}
					else if(arr[j][i] ==1) cnt = 1;
                  }
              }
          System.out.println("#"+t+" "+ans);
		}
	}
}