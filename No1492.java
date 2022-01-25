package day04_codeup_220120;

import java.util.Scanner;

public class No1492 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// sum 초기값 0
		int sum = 0;
		for (int i = 0; i < n; i++) {
			// 입력 받으면서 앞의 값에 더해준다
			int res = sc.nextInt();
			sum += res;
			System.out.print(sum + " ");
		}

	}
}
