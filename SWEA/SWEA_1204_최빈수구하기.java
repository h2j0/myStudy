import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1204_최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt();
			// 점수당 학생수를 카운트할 배열
			int[] scoreCnt = new int[101];

			for (int std = 0; std < 1000; std++) { // 학생수는 1000명
				int score = sc.nextInt();
				scoreCnt[score]++; // 점수당 학생수를 배열로 저장
			}
//			System.out.println(Arrays.toString(scoreCnt));

			// 최빈수 구하기
			int maxCnt = 0;
			for (int cnt : scoreCnt) {
				if (maxCnt < cnt) {
					maxCnt = cnt;
				}
			}

			// 최고 빈도수인 점수 구하기
			// scoreCnt의 값이 최빈수일 때 그 때의 인덱스 값
			// i가 0부터 101번 돌기 때문에 i의 최대값이 ans로 나온다
			int ans = 0;
			for (int i = 0; i < 101; i++) {
				if (scoreCnt[i] == maxCnt) {
					ans = i;
				}
			}

			System.out.println("#" + a + " " + ans);

		}

	}
}
