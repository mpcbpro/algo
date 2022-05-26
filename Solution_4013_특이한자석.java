
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_4013_특이한자석 {
	static LinkedList<Integer>[] mag;
	static int K; // 자석을 임의로 돌리는 횟수 K

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			K = sc.nextInt();
			mag = new LinkedList[5]; // 1,2,3,4번 자석

			for (int i = 1; i <= 4; i++) {
				mag[i] = new LinkedList<>();
				for (int j = 0; j < 8; j++) {
					mag[i].add(sc.nextInt());  // 8개의 톱니정보
				}
			}

			for (int k = 0; k < K; k++) { // 자석 회전 횟수
				int magNum = sc.nextInt(); // 자석번호
				boolean dir = sc.nextInt() == 1 ? true : false; // 1이면 시계 true, 아니면 반시계 false
				if      (magNum == 1) execute(magNum, 2, dir);
				else if (magNum == 4) execute(magNum, 6, dir);
				else { 
					execute(magNum, 2, dir);
					rotate(magNum, !dir);
					execute(magNum, 6, dir);
				}
			}

			int ans = 0;
			for (int i = 1; i <= 4; i++) { // 자석번호 1,2,3,4 : N극 0, S극 1, 각각의 점수 1,2,4,8
				ans += (mag[i].get(0) * (1 << (i - 1)));   
			}
			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}
	/**
	 * 현재 선택된 자석의 왼쪽 또는 오른쪽 방향에 붙어 있는 자석을 체크하여 회전 여부를 확인, 재귀적으로 같은 상황의 자석을 가능한 자석까지 찾는다.
	 * @param magNum : 현재 자석번
	 * @param idx : 자석이 체크할 방향(2번은 오른쪽의 자석과 6번을 체크, 6번은 왼쪽의 자석과 2번을 체크)
	 * @param dir : 진행방향, true(시계방향),  false(반시계방향)
	 */
	static void execute(int magNum, int idx, boolean dir) {
		int next = magNum + (idx == 2 ? +1 : -1); 
		if (next > 0 && next < 5 && mag[magNum].get(idx) != mag[next].get((idx + 4) % 8)) {
			execute(next, idx, !dir); // 옆자석번호, 왼오 방향은 유지, 시계반시계 방향은 반대
		}
		rotate(magNum, dir); 
	}
	/**
	 * 자석 돌리기
	 * @param magNum : 자석번
	 * @param dir : 진행방향, true(시계방향), false(반시계방향)
	 */
	static void rotate(int magNum, boolean dir) {
		if (dir) {
			mag[magNum].addFirst(mag[magNum].removeLast());
		} else {
			mag[magNum].addLast(mag[magNum].removeFirst());
		}
	}
}