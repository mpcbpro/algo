package com.ssafy.jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가로 세로 틀린 경우가 한 개면 그 점을 고치면 된다.
public class Solution_jo_1037_오류교정 {
	
	static int n; // (n<100)
	static int[][] input;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		input = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 행
		//boolean wWrong = false;
		int wrongY = 0;	// 잘못된 행의 수
		int wrongCntY = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				sum += input[i][j];
			}
			if( sum % 2 != 0 ) {
				//wWrong = true;
				wrongY = i;
				wrongCntY++;
			}
		}
		
		// 열
		//boolean hWrong = false;
		
		int wrongX = 0;
		int wrongCntX = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				sum += input[j][i];
			}
			if( sum % 2 != 0 ) {
				//wWrong = true;
				wrongX = i;
				wrongCntX++;
			}
		}
		
		if( wrongCntY > 0 || wrongCntX > 0 ) {

		}else {
			System.out.println("OK");
		}
	}

}