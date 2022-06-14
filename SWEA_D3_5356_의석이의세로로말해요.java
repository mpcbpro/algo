package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_5356_의석이의세로로말해요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			char[][] arr = new char[5][15];
			int [] len = new int[5];
			for (int i = 0; i < 5; i++) {
				String str = br.readLine();
				len[i] = str.length();
				for (int j = 0; j < str.length(); j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			int max = 0;
			for (int i = 0; i < 5; i++) {
				
			}
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 5; j++) {
					if(arr[j][i] != null) continue;
					System.out.print(arr[j][i]);
				}
			}
		}
	}
}
