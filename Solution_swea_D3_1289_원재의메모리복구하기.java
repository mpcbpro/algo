package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea_D3_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			String str = br.readLine();
			str.toCharArray();
			int l = str.length();
			int cnt = 0;
			boolean flag = false;
			for (int i = 0; i < l; i++) {
				if(str.charAt(i) == '1') {
					if(!flag) {
						cnt++;
						flag = true;
					}
				}
				if(str.charAt(i) == '0') {
					if(flag) {
						cnt++;
						flag = false;
					}
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
