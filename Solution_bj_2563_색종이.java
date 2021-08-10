package com.ssafy.bj;

import java.util.Scanner;

public class Solution_bj_2563_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				int num = sc.nextInt(); // 10x10 종이 수
				int[][] paper = new int[100][100];
				int answer = 0;
				for(int i = 0; i<num; i++) {
					int x = sc.nextInt();   
					int y = sc.nextInt(); 
					for (int j = x; j < x+10; j++) {
						for (int k = y; k < y+10; k++) {
							// 10x10 정사각형 자리에 1 넣기
							if(paper[j][k]==1) continue; // 이미 1이 있다면 continue
							paper[j][k] = 1;
							answer++;
						}
					}
				}
				System.out.println(answer);

	}
}
