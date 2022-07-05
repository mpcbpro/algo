package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_swea_D3_4047_영준이의카드카운팅 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// 테스트케이스 반복
		for (int t = 1; t <= T; t++) {
			//한 줄 씩 읽어와서 무늬별 카드 부족한 수, 만약 중복카드 있으면 error 출력
			boolean flag = true;
			int[] fig = new int[4];
			for (int i = 0; i < 4; i++) {
				fig[i] = 13;
			}
			
			String str = br.readLine();
		out:	for (int i = 0; i < str.length(); i+=3) {
				String a = str.substring(i, i+3);
				char c = a.charAt(0);
				int num = Integer.parseInt(a.substring(1, 3));
				
				for (int j = i+3; j < str.length(); j+=3) {
					String b = str.substring(j, j+3);
					
					if(a.equals(b)) {
						System.out.println("#"+t + " " + "ERROR");
						flag = false;
						break out;
					}
				}
				
				if(c=='S') fig[0]--;
				if(c=='D') fig[1]--;
				if(c=='H') fig[2]--;
				if(c=='C') fig[3]--;
			}
			if(flag == true) {
				System.out.print("#" +  t);
				for (int i = 0; i < 4; i++) {
					System.out.print(" " + fig[i]);
				}
				System.out.println();
			}
		}
	}
}
