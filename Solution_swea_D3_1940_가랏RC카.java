package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea_D3_1940_가랏RC카 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][2]; 
			int sum = 0;
			int v = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				
				switch (num) {
				case 1:
					v += Integer.parseInt(st.nextToken());
					sum += v;
					
					break;
				case 2:
					v -= Integer.parseInt(st.nextToken());
					sum += v;
					
					break;
				case 0:
					sum += v;
					
					break;
				}
				if(v<1) v = 0;
			}
			System.out.println("#" + t + " " + sum);
		}
	}
	
}
