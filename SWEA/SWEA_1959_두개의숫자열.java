import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1959_두개의숫자열 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			// 배열 2개 만들고 입력받기
			int[] arrN = new int[N];
			int[] arrM = new int[M];

			for (int i = 0; i < N; i++) {
				arrN[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				arrM[i] = sc.nextInt();
			}

			// 길이가 짧은 배열 A, 긴 배열 B로 바꿔준다
			int[] arrA = N <= M ? arrN : arrM;
			int[] arrB = N <= M ? arrM : arrN;
			int a = arrA.length;
			int b = arrB.length;


			int max = 0;
			// 배열이 움직일 수 있는 횟수(move)는 b-a+1
			for (int move = 0; move <= b - a; move++) {
				int sum = 0;
				// move만큼 움직인 arrB * arrA 을 더해준다
				for (int aIdx = 0; aIdx < a; aIdx++) {
					sum += arrB[aIdx + move] * arrA[aIdx];
				}
				// 최대값 구하기
				if (sum > max) {
					max = sum;
				}

			}

			System.out.println("#" + tc + " " + max);
		}

	}
}
