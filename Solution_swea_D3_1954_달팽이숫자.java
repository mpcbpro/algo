package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea_D3_1954_달팽이숫자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
			for (int t = 1; t <= T; t++) {
				int n = Integer.parseInt(br.readLine());
				int[][] arr = new int[n][n];
				int cnt = 1;
				int dx = 0, dy = -1;
				int mv = 1;
				int k = n;
				while(true) {
				for (int i = 0; i < k; i++) {
					arr[dx][dy += mv] = cnt++;
				}
				if(--k == 0) break;
				
				for (int i = 0; i < k; i++) {
					arr[dx += mv][dy] = cnt++;
				}
				mv *= -1 ;
			}
				System.out.println("#"+t);
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						System.out.print(arr[i][j] + " ");
					}
					System.out.println();
				}
		}
	}
	
}
