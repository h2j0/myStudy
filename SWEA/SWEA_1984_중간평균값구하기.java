import java.util.Scanner;

public class SWEA_1984_중간평균값구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 입력
		int T = sc.nextInt();
		// 테케 만큼 반복
		// 입력을 받으면서
		// (1) 모든 수를 더하고 (2) 최소, 최대를 구해서 (3) 모든수-최대-최소
		for (int tc = 1; tc <= T; tc++) {
			// 총합 0으로 초기화
			int sum = 0;
			int max = 0;
			int min = 987654321;
			// 10개씩 수 입력받기
			for (int i = 0; i < 10; i++) {
				int num = sc.nextInt();
				sum += num; 		// (1)
				if (max < num) {	// (2)
					max = num;
				}
				if (min > num) {
					min = num;
				}
			}
			// (4) : (3)의 반올림된 평균 구하기
			// double형변환을 위해 8.0으로 나누고 round로 반올림 후 int로 형변환
			int ans = (int) Math.round((sum - max - min) / 8.0);

			System.out.printf("#%d %d", tc, ans);

		}
	}
}
