import java.util.Arrays;
import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {
	static int[] score;
	static int[] cal;
	static boolean[] sel;
	static int N; // 재료의 수
	static int L; // 제한 칼로리
	static int maxScore; // 최대 점수

	public static void main(String[] args) {
		// 정해진 칼로리 이하의 조합
		// 그 중 점수가 가장 높은 친구
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 입력

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 재료의 수
			L = sc.nextInt(); // 제한 칼로리
			score = new int[N];	// 점수 입력받을 배열
			cal = new int[N];	// 칼로리 입력받을 배열
			sel = new boolean[N]; // true / false 배열
			maxScore = 0;

			// 점수와 칼로리 입력받음
			for (int n = 0; n < N; n++) {
				score[n] = sc.nextInt();
				cal[n] = sc.nextInt();
			}
			check(0);
			System.out.println("#" + tc + " " + maxScore);
		}

	}

	public static void check(int idx) {
		// 기본파트
		if (idx == N) {
			int calSum = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i]) {	// true인 인덱스에 해당되는 
					calSum += cal[i]; // cal를 더한다
				}
			}

			if (calSum < L) {	// 칼로리 합이 제한칼로리보다 작다면 
				int scoreSum = 0;	// 합계를 0으로 초기화하고
				for (int i = 0; i < N; i++) {	
					if (sel[i]) {	
						scoreSum += score[i]; // true인 애들의 점수를 더한다
					}

				}
				maxScore = Math.max(maxScore, scoreSum);
			}
		} else { // 재귀파트
			sel[idx] = true;	// 뽑고
			check(idx + 1);		// 다음 차례 부르고
			sel[idx] = false;	// 안뽑고
			check(idx + 1);		// 다음 차례 부른다
		}

	}

}
