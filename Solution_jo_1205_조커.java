package com.ssafy.jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 연속된 숫자를 이용하므로 입력 숫자 배열을 정렬한 후 처리
// 조커의 활용 방안
//  1. 연속되지 않은 경우, 두 수의 차이를 채우기 위해 사용 => 사용하는 조커의 수는 두 수의 차이 - 1 ( 3-4-5-8 에서 8-5=3 이지만 조커는 2개 사용 )
//  2. 배열의 맨 마지막까지 왔을 때 남은 조커를 더 붙여준다
//  3. 두 수의 차이보다 조커가 작을 경우, 현재까지의 연속된 수에 조커를 더 붙여준다.
// 극단적인 상황
//  전부 다 조커라면? n 이 답
// 그리디 보다 완탐 (재귀)로 해결
// 조커의 수를 파라미터로 처리 - 전역변수를 공유하면 X
public class Solution_jo_1205_조커 {
	
	static int joker, n, ans;
	static int[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ans = 0;
		input = new int[n];
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if (input[i] == 0) {
				joker += 1;
			}
		}
		
		// 정렬
		Arrays.sort(input);
		
//		for(int i = 0 ; i < n; i++) {
//			System.out.print(input[i] + " ");
//		}
		for(int i = 0 ; i < n; i++) {
			if(input[i] == 0) continue;
			func(i, 1, joker);
		}
		
		System.out.println(joker == n ? joker : ans);
	}
	
	public static void func(int idx, int cnt, int jCnt) {
		// 기저 조건
		// 맨 끝에 도달하면 남은 조커를 뒤에 추가한 상태에서 max 갱신
		if( idx == n - 1) {
			ans = Math.max(cnt + jCnt, ans);
			return;
		}
		
		int gap = input[idx + 1] - input[idx]; // 정렬되어 있으므로 gap >= 0
		
		// 주의 !! - 아래는 기저 조건이 아니다!!
		// 두 수의 차이가 조커보다 크더라도 조커가 남아 있으면 조커를 그 뒤에 붙여서 사용해야 한다.
		// 3-4-5-6-10- 인 상태에서 조커가 2 라면 10-6 은 4이어서 10은 연결시킬 수 없지만, 2개의 조커를 6 뒤에 붙일 수 있다.
		// if( gap - 1 > x ) return; 

		if( gap == 0 ) { // 다음 수가 현재 수와 같으면 그 다음 수로 그냥 건너 뛴다.
			// 여기 코드를 구현하세요
			func( idx + 1, cnt, jCnt);
		}else if( gap == 1 ) { // 다음 수가 현재 수와 연속적이면 cnt 를 증가하고 재귀 호출.
			// 여기 코드를 구현하세요
			func( idx + 1, cnt + 1, jCnt);
		}else { // 다음 수가 현재와 연속적이지 않으면
			// 조커를 활용할 수 있으면 조커를 사용
			if( jCnt != 0 && gap - 1 <= jCnt ) {
				// ...4-5-8.. 이라면 5와 8의 차이는 3, 새로 생기는 연속숫자는 6,7 을 통해서 3개, 조커는 2개 사용
				// 여기 코드를 구현하세요
				func( idx + 1, cnt + gap, jCnt - (gap-1));
				
			}else {
				// 남은 조커를 뒤에 연속수로 사용하도록 cnt 를 증가 시킨다. 
				// 재귀 호출 X
				ans = Math.max(cnt + jCnt, ans);
			}
		}
	}

}
